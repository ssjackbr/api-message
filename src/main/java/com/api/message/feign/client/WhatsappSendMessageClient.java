package com.api.message.feign.client;

import com.api.message.domain.dto.MessageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(contextId = "WhatsappSendMessageClientId",
             value = "whatsappSendMessageClient",
             url = "${whatsapp.host}")
public interface WhatsappSendMessageClient {

    @PostMapping(value = "${whatsapp.send-message}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> sendMessageWhatsapp(@RequestBody MessageDTO message);
}