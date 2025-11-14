
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
    "logprobs",
    "finish_reason",
    "native_finish_reason",
    "index",
    "message"
})
@Generated("jsonschema2pojo")
public class Choice {

    @JsonProperty("logprobs")
    private Object logprobs;
    @JsonProperty("finish_reason")
    private String finishReason;
    @JsonProperty("native_finish_reason")
    private String nativeFinishReason;
    @JsonProperty("index")
    private Integer index;
    @JsonProperty("message")
    private Message message;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("logprobs")
    public Object getLogprobs() {
        return logprobs;
    }

    @JsonProperty("logprobs")
    public void setLogprobs(Object logprobs) {
        this.logprobs = logprobs;
    }

    @JsonProperty("finish_reason")
    public String getFinishReason() {
        return finishReason;
    }

    @JsonProperty("finish_reason")
    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }

    @JsonProperty("native_finish_reason")
    public String getNativeFinishReason() {
        return nativeFinishReason;
    }

    @JsonProperty("native_finish_reason")
    public void setNativeFinishReason(String nativeFinishReason) {
        this.nativeFinishReason = nativeFinishReason;
    }

    @JsonProperty("index")
    public Integer getIndex() {
        return index;
    }

    @JsonProperty("index")
    public void setIndex(Integer index) {
        this.index = index;
    }

    @JsonProperty("message")
    public Message getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(Message message) {
        this.message = message;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
