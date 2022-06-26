package com.projeto.sistema.agendamento.controller;

import com.projeto.sistema.agendamento.model.dto.ServicoDTO;
import com.projeto.sistema.agendamento.service.ServicoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    @Cacheable(value = "listarServicos")
    public ResponseEntity<List<ServicoDTO>> listar() {
        return ResponseEntity.ok().body(servicoService.listar());
    }

    @PostMapping
    @CacheEvict(value = "listarServicos", allEntries = true)
    public ResponseEntity<ServicoDTO> criar(@RequestBody ServicoDTO servicoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicoService.salvar(servicoDTO));
    }

    @PutMapping("/{id}")
    @CacheEvict(value = "listarServicos", allEntries = true)
    public ResponseEntity<ServicoDTO> atualizar(@RequestBody ServicoDTO servicoDTO, @PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(servicoService.atualizar(servicoDTO, id));
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "listarServicos", allEntries = true)
    public ResponseEntity<Response> excluir(@PathVariable("id") Integer id) {
        servicoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
