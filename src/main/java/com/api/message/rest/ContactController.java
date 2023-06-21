package com.api.message.rest;

import com.api.message.domain.dto.ContactDTO;
import com.api.message.domain.entity.Contact;
import com.api.message.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/contact")
public class ContactController {

    private final ContactService contactService;

    @PostMapping("/insert")
    public Contact registerContact (@RequestBody ContactDTO contactDTO){
        return contactService.insert(contactDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact (@PathVariable Long id){
        contactService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Long id, @RequestBody boolean status) {
        return ResponseEntity.ok(contactService.updateAutomationStatus(id, status));
    }

    @GetMapping("/list")
    public Page<Contact> listContacts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return contactService.findAll(pageable);
    }

}
