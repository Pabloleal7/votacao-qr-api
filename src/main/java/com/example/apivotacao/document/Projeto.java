package com.example.apivotacao.document;

import com.example.apivotacao.enums.Turno;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@Document
public class Projeto {

    @Id
    private String id;
    private String nome;
    private String participantes;
    private String base64;
    private String turma;
    private Turno turno;
    private String descricao;
}
