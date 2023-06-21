package com.api.message.service;

import com.api.message.domain.dto.MessageWhatsappJsDTO;
import com.api.message.domain.dto.PaymentNotificationMessageParamsDTO;
import com.api.message.domain.entity.Contact;
import com.api.message.domain.entity.MessageCreator;
import com.api.message.domain.enums.MessageStatusEnum;
import com.api.message.feign.client.WhatsappSendMessageJsClient;
import com.api.message.repository.ContactRepository;
import com.api.message.utils.ValidateContactNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Slf4j
public class SendMessageService {

    private final WhatsappSendMessageJsClient whatsappSendMessageJsClient;
    private final MessageCreator messageCreator;
    private final MessageService saveMessage;
    private final ContactRepository contactRepository;
    private boolean hasSendingError = false;

    public List<Map<String, String>> send(PaymentNotificationMessageParamsDTO paymentNotificationMessageParamsDTO) {

        List<Contact> contactList = contactRepository.findAllByHasActiveAutomationIsTrue();
        String content = messageCreator.paymentNotificationMessage(paymentNotificationMessageParamsDTO);
        List<Map<String, String>> contactsToReceiveMessage = new ArrayList<>();
        List<Map<String, String>> errorReceiveMessage = new ArrayList<>();

            contactList.forEach(contact -> {
                try {
                    log.info("#### START MESSAGE SEND TO CONTACT [{}], [{}]", contact.getName(), contact.getNumber());

                    whatsappSendMessageJsClient.sendMessageWhatsapp(MessageWhatsappJsDTO.builder()
                            .number(ValidateContactNumber.formatContactNumber(contact.getNumber()))
                            .message(content)
                            .build());

                } catch (Exception exception) {
                    String e = exception.toString();
                    hasSendingError = true;
                    errorReceiveMessage.add(Map.of("Log: ","ERROR WHEN TRYING TO SEND THE MESSAGE TO CONTACT" ,"Name", contact.getName(), "Number", contact.getNumber()));
                    log.error("#### ERROR WHEN TRYING TO SEND THE MESSAGE TO CONTACT [{}], [{}]", contact.getName(), contact.getNumber());
                    log.error("#### ERROR LOG: [{}]", e);
                }
                if(hasSendingError){
                    saveMessage.saveMessage(contact, paymentNotificationMessageParamsDTO, content, MessageStatusEnum.ERROR_SEND);
                }
                saveMessage.saveMessage(contact, paymentNotificationMessageParamsDTO, content, MessageStatusEnum.SENT);
                contactsToReceiveMessage.add(Map.of("Log: ","MESSAGE SENT!","Name ", contact.getName(), "Number", contact.getNumber()));
            });

            if(hasSendingError){
                return errorReceiveMessage;
            }
            else return contactsToReceiveMessage;
    }
}
