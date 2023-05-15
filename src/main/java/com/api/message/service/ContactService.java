package com.api.message.service;

import com.api.message.domain.dto.ContactDTO;
import com.api.message.domain.entity.Contact;
import com.api.message.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactService {

    private final ContactRepository contactRepository;

    @Transactional
    public Contact insert(ContactDTO contactDTO) {

        log.info("#### REGISTER A NEW CONTACT | NAME: [{}], NUMBER: [{}]", contactDTO.getName(), contactDTO.getNumber());
        Contact contact =  Contact.builder()
                .name(contactDTO.getName())
                .number(contactDTO.getNumber())
                .hasActiveAutomation(contactDTO.isHasActiveAutomation())
                .address(contactDTO.getAddress())
                .build();
      return contactRepository.save(contact);
    }
}
