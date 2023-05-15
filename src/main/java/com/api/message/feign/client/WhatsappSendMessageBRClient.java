package com.api.message.feign.client;

import com.api.message.domain.dto.MessageApiBraDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(contextId = "WhatsappSendMessageBRClientClientId",
             value = "whatsappSendMessageBRClient",
             url = "${api-brasil.host}")
public interface WhatsappSendMessageBRClient {

    @PostMapping(value = "${api-brasil.send-message}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> sendMessageWhatsappBR(@RequestHeader(HttpHeaders.AUTHORIZATION) String accessToken,
                                                 @RequestHeader(name = "SecretKey") String secretKey,
                                                 @RequestHeader(name = "DeviceToken") String deviceToken,
                                                 @RequestHeader(name = "PublicToken") String publicToken,
                                                 @RequestBody MessageApiBraDTO message);
}