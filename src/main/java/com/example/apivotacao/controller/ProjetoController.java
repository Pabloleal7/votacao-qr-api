package com.example.apivotacao.controller;

import com.example.apivotacao.document.Projeto;
import com.example.apivotacao.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController()
@RequestMapping("projeto")
@CrossOrigin("*")
public class ProjetoController {
    @Autowired
    private ProjetoRepository repository;

    @GetMapping("/{uuid}")
    public ResponseEntity<Projeto> findById(@PathVariable String uuid){
       Projeto projeto = repository.findById(uuid).orElseThrow(()-> new RuntimeException("Não existe projeto com esse id: "+ uuid));
        return ResponseEntity.ok(projeto);
    }

    @GetMapping()
    public ResponseEntity<List<Projeto>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }
    @PostMapping
    public ResponseEntity<Projeto> save(@RequestBody Projeto projeto){
        System.out.println("Entrou");
        return ResponseEntity.ok(repository.save(projeto));
    }
}
