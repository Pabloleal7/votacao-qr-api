package com.example.apivotacao.repository;

import com.example.apivotacao.document.Permissao;
import com.example.apivotacao.document.Voto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository extends MongoRepository<Permissao, String> {

}
