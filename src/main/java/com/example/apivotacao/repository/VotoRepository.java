package com.example.apivotacao.repository;

import com.example.apivotacao.document.Projeto;
import com.example.apivotacao.document.Voto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VotoRepository extends MongoRepository<Voto, String> {
    Integer countVotoByProjetoID(String id);
}
