package com.api.message.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageWhatsappJsDTO {
    @JsonProperty("number")
    private String number;

    @JsonProperty("message")
    private String message;
}
