package com.api.message.service;

import com.api.message.domain.dto.ContactDTO;
import com.api.message.domain.entity.Contact;
import com.api.message.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

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

    public void delete (Long id){

        try {
            contactRepository.deleteById(id);
        }catch (Exception e){
            log.error("#### ERROR WHEN TRYING TO DELETE CONTACT ID [{}], [{}]", id, e);
        }
    }

    public Page<Contact> findAll(Pageable pageable) {

        return contactRepository.findAll(pageable);
    }

    public String updateAutomationStatus(Long id, boolean status) {

        Optional<Contact> contactEntity = contactRepository.findById(id);

        if (contactEntity.isPresent()){
            Contact contact = contactEntity.get();
            contact.setHasActiveAutomation(status);
            contactRepository.save(contact);
            return ("#### CONTACT: "+contact.getName()+", ID: "+contact.getId()+" HAS BEEN UPDATED SUCCESSFULLY!" );
        } else {
            return ("#### ERROR WHEN TRYING TO UPDATE CONTACT ID: "+id+" NOT FOUND!" );
        }
    }
}
