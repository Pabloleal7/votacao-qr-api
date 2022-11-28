package com.example.apivotacao.controller;

import com.example.apivotacao.document.Permissao;
import com.example.apivotacao.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("liberar")
@CrossOrigin("*")
public class PermissaoController {

    @Autowired
    PermissaoRepository permissaoRepository;

    @GetMapping
    public Boolean find(){

        Optional<Permissao> permissao =  permissaoRepository.findById("6382ed6e28e80a64b7df4ea1");
        return permissao.get().getLiberado();
    }
    @PostMapping("true")
    public Boolean liberar(){

       Optional<Permissao> permissao =  permissaoRepository.findById("6382ed6e28e80a64b7df4ea1");
       permissao.get().setLiberado(true);
       permissaoRepository.save(permissao.get());
        return permissao.get().getLiberado();
    }
    @PostMapping("false")
    public Boolean bloquear(){

        Optional<Permissao> permissao =  permissaoRepository.findById("6382ed6e28e80a64b7df4ea1");
        permissao.get().setLiberado(false);
        permissaoRepository.save(permissao.get());
        return permissao.get().getLiberado();
    }
}
