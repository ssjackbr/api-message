package com.api.message.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MessageFormatEnum {

    TEXT("TEXT"),
    AUDIO("AUDIO");

    @Getter
    private final String key;
}
