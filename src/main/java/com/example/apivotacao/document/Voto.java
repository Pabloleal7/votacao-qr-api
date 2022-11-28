package com.example.apivotacao.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;

@Document
@Getter
@Setter
public class Voto {
    @Id
    private String id;
    private String projetoID;
    private LocalDateTime dateTime = LocalDateTime.now();
}
