package com.example.apivotacao.repository;

import com.example.apivotacao.document.Projeto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjetoRepository extends MongoRepository<Projeto, String> {
}
