package com.api.message.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String country;
    private String cep;

    @ManyToOne(fetch = FetchType.EAGER)
    private Contact contact;
}
