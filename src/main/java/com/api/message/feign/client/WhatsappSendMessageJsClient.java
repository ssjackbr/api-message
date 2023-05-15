package com.api.message.feign.client;


import com.api.message.domain.dto.MessageWhatsappJsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(contextId = "WhatsappSendMessageJsClientId",
                 value = "whatsappSendMessageJsClient",
                   url = "${whatsapp-local.host}")

public interface WhatsappSendMessageJsClient {
    @PostMapping(value = "${whatsapp-local.send-message}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> sendMessageWhatsapp(@RequestBody MessageWhatsappJsDTO message);
}