package com.api.message.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageApiBraDTO {
    @JsonProperty("number")
    private String contactNumberTo;

    @JsonProperty("text")
    private String content;
}
