package com.api.message.rest;

import com.api.message.domain.dto.ContactDTO;
import com.api.message.domain.entity.Contact;
import com.api.message.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/contact")
public class ContactController {

    private final ContactService contactService;

    @PostMapping("/insert")
    public Contact registerContact (@RequestBody ContactDTO contactDTO){
        return contactService.insert(contactDTO);
    }
}
