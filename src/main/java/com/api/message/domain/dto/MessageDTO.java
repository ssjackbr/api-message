package com.api.message.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDTO {

    private String apikey;

    @JsonProperty("phone_number")
    private String userNumberFrom;

    @JsonProperty("contact_phone_number")
    private String userNumberTo;

    @JsonProperty("message_custom_id")
    private String messageTypeEnum;

    @JsonProperty("message_type")
    private String format;

    @JsonProperty("message_body")
    private String content;

    @JsonProperty("check_status")
    private String checkStatus = "1";
}
