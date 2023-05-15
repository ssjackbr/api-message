package com.api.message.rest;

import com.api.message.domain.dto.PaymentNotificationMessageParamsDTO;
import com.api.message.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/whatsapp")
public class SendMessageController {

    private final SendMessageService sendMessageService;

    @PostMapping("/send-message")
    public List<Map<String, String>> sendMessage (@RequestBody PaymentNotificationMessageParamsDTO paymentNotificationMessageParamsDTO){
        return sendMessageService.send(paymentNotificationMessageParamsDTO);
    }

}
