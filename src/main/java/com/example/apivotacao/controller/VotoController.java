package com.example.apivotacao.controller;

import com.example.apivotacao.document.Permissao;
import com.example.apivotacao.document.Voto;
import com.example.apivotacao.document.VotoResponse;
import com.example.apivotacao.repository.PermissaoRepository;
import com.example.apivotacao.repository.ProjetoRepository;
import com.example.apivotacao.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController()
@RequestMapping("voto")
@CrossOrigin("*")
public class VotoController {
    @Autowired
    private VotoRepository repository;

    @Autowired
    private ProjetoRepository repositoryProjeto;

    @Autowired
    PermissaoRepository permissaoRepository;


    @GetMapping
    public ResponseEntity<List<Voto>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("all")
    public ResponseEntity<List<VotoResponse>> findProjetoVotos() {
        System.out.println("entrouuu");
        List<VotoResponse> lista = new ArrayList<>();
        repositoryProjeto.findAll().forEach((i) -> {
            VotoResponse votoResponse = new VotoResponse();
            Integer votos = repository.countVotoByProjetoID(i.getId());
            votoResponse.setNome(i.getNome());
            votoResponse.setVotos(votos);
            lista.add(votoResponse);
        });

        return ResponseEntity.ok(lista);
    }

    @PostMapping("{idProjeto}")
    public ResponseEntity<Voto> save(@PathVariable String idProjeto) {

       Permissao permissao = permissaoRepository.findById("6382ed6e28e80a64b7df4ea1").get();
       if (permissao.getLiberado()){
           repositoryProjeto.findById(idProjeto).orElseThrow(() -> new RuntimeException("Erro"));
           Voto voto = new Voto();
           voto.setProjetoID(idProjeto);
           return ResponseEntity.ok(repository.save(voto));
       }else {
           Voto voto = new Voto();
           voto.setId("bloqueado");
           return ResponseEntity.ok(voto);
       }


    }
}
