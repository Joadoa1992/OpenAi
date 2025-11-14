
package org.example.openai.dto;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "role",
    "content",
    "refusal",
    "reasoning"
})
@Generated("jsonschema2pojo")
public class Message {

    @JsonProperty("role")
    private String role;
    @JsonProperty("content")
    private String content;
    @JsonProperty("refusal")
    private Object refusal;
    @JsonProperty("reasoning")
    private Object reasoning;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("refusal")
    public Object getRefusal() {
        return refusal;
    }

    @JsonProperty("refusal")
    public void setRefusal(Object refusal) {
        this.refusal = refusal;
    }

    @JsonProperty("reasoning")
    public Object getReasoning() {
        return reasoning;
    }

    @JsonProperty("reasoning")
    public void setReasoning(Object reasoning) {
        this.reasoning = reasoning;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }
}
