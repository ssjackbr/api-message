package com.api.message.service;

import com.api.message.domain.dto.PaymentNotificationMessageParamsDTO;
import com.api.message.domain.entity.Contact;
import com.api.message.domain.entity.Message;
import com.api.message.domain.enums.MessageFormatEnum;
import com.api.message.domain.enums.MessageStatusEnum;
import com.api.message.domain.enums.MessageTypeEnum;
import com.api.message.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@RequiredArgsConstructor
@Service
@Slf4j
public class MessageService {

    @Value("${security.token}")
    private String accessToken;

    @Value("${security.secretKey}")
    private String secretKey;

    @Value("${security.deviceToken}")
    private String deviceToken;

    @Value("${security.publicToken}")
    private String publicToken;

    private final MessageRepository messageRepository;

    public void saveMessage(Contact contact, PaymentNotificationMessageParamsDTO messageParamsDTO, String content, MessageStatusEnum statusEnum) {

        messageRepository.save(Message.builder()
                .messageTypeEnum(MessageTypeEnum.PAYMENT_NOTIFICATION)
                .contactNameTo(contact.getName())
                .contactNumberTo(contact.getNumber())
                .contactNameFrom("Jackson TIM - Admin")
                .contactNumberFrom("5531991987660")
                .creationDate(Instant.now())
                .format(MessageFormatEnum.TEXT)
                .sendDate(Instant.now())
                .url(messageParamsDTO.getLinkReport())
                .content(content)
                .status(statusEnum)
                .build());
    }
}
