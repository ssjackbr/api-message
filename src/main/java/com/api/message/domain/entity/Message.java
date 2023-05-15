package com.api.message.domain.entity;

import com.api.message.domain.enums.MessageFormatEnum;
import com.api.message.domain.enums.MessageStatusEnum;
import com.api.message.domain.enums.MessageTypeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "message")
public class Message {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Enumerated(EnumType.STRING)
        private MessageTypeEnum messageTypeEnum;

        @Column(name = "contact_number_to")
        private String contactNumberTo;

        @Column(name = "contact_name_to")
        private String contactNameTo;

        @Column(name = "contact_number_from")
        private String contactNumberFrom;

        @Column(name = "contact_name_from")
        private String contactNameFrom;

        @Column(name = "creation_date")
        private Instant creationDate;

        @Column(name = "send_date")
        private Instant sendDate;

        @Column(name = "url")
        private String url;

        @Column(name = "content", columnDefinition = "varchar(1000)")
        private String content;

        @Enumerated(EnumType.STRING)
        private MessageFormatEnum format;

        @Enumerated(EnumType.STRING)
        private MessageStatusEnum status;

}
