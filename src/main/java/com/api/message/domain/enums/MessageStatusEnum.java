package com.api.message.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MessageStatusEnum {

        SENT("SENT"),
        SCHEDULED("SCHEDULED"),
        ERROR_SEND("ERROR_SEND");

        @Getter
        private final String key;
}
