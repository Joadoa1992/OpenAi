package org.example.openai.controller;

import org.example.openai.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.MediaType;

import java.util.*;
import java.util.concurrent.Semaphore;

@RestController
public class ChatGPTController {

    @Value("${openai.api.key}")
    private String openapikey;

    private final WebClient webClient;
    private final Map<String, List<Message>> sessions = new HashMap<>();

    private final Semaphore semaphore = new Semaphore(5);

    public ChatGPTController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://openrouter.ai/api/v1/chat/completions").build();
    }

    @GetMapping("/chat")
    public Map<String, Object> chatWithGPT(@RequestParam String sessionId,
                                           @RequestParam String message) {
        try {
            semaphore.acquire();

            sessions.putIfAbsent(sessionId, new ArrayList<>());
            List<Message> history = sessions.get(sessionId);

            history.add(new Message("user", message));

            ChatRequest chatRequest = new ChatRequest();
            chatRequest.setModel("kwaipilot/kat-coder-pro:free");
            chatRequest.setMessages(history);
            chatRequest.setN(1);
            chatRequest.setTemperature(1);
            chatRequest.setMaxTokens(5000);
            chatRequest.setStream(false);
            chatRequest.setPresencePenalty(1);

            ChatResponse response = webClient.post()
                    .contentType(MediaType.APPLICATION_JSON)
                    .headers(h -> h.setBearerAuth(openapikey))
                    .bodyValue(chatRequest)
                    .retrieve()
                    .bodyToMono(ChatResponse.class)
                    .block();

            Choice choice = response.getChoices().get(0);
            String assistantMessage = choice.getMessage().getContent();

            history.add(new Message("assistant", assistantMessage));

            Map<String, Object> map = new HashMap<>();
            map.put("reply", assistantMessage);
            map.put("usage", response.getUsage());
            map.put("fullHistory", history);

            return map;

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            Map<String, Object> errorMap = new HashMap<>();
            errorMap.put("error", "Server interrupted. Try again.");
            return errorMap;

        } finally {
            semaphore.release();
        }
    }

}
