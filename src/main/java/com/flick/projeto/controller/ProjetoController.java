package com.flick.projeto.controller;

import com.flick.projeto.model.Projeto;
import com.flick.projeto.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public Projeto criarProjeto(@RequestBody Projeto projeto) {
        return projetoService.criarProjeto(projeto);
    }

    @GetMapping
    public List<Projeto> listarProjetos() {
        return projetoService.listarProjetos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> buscarProjetoPorId(@PathVariable Long id) {
        return projetoService.buscarProjetoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable Long id) {
        projetoService.deletarProjeto(id);
        return ResponseEntity.noContent().build();
    }
}