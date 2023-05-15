package com.api.message.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MessageTypeEnum {

    PAYMENT_NOTIFICATION("PAYMENT_NOTIFICATION"),
    OVERDUE_PAYMENT_NOTIFICATION("OVERDUE_PAYMENT_NOTIFICATION");

    @Getter
    private final String key;
}
