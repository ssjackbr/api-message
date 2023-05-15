package com.api.message.domain.dto;

import com.api.message.domain.entity.Address;
import lombok.*;

import java.util.List;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {

    private String name;
    private String number;
    private boolean hasActiveAutomation;
    private List<Address> address;
}
