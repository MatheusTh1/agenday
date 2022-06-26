package com.projeto.sistema.agendamento.controller;

import com.projeto.sistema.agendamento.model.dto.BarbeiroDTO;
import com.projeto.sistema.agendamento.service.BarbeiroService;
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
@RequestMapping("/barbeiro")
public class BarbeiroController {

    @Autowired
    private BarbeiroService barbeiroService;

    @GetMapping
    @Cacheable(value = "listarBarbeiros")
    public ResponseEntity<List<BarbeiroDTO>> listar() {
        return ResponseEntity.ok().body(barbeiroService.listar());
    }

    @PostMapping
    @CacheEvict(value = "listarBarbeiros", allEntries = true)
    public ResponseEntity<BarbeiroDTO> criar(@RequestBody BarbeiroDTO barbeiroDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(barbeiroService.salvar(barbeiroDTO));
    }

    @PutMapping()
    @CacheEvict(value = "listarBarbeiros", allEntries = true)
    public ResponseEntity<BarbeiroDTO> atualizar(@RequestBody BarbeiroDTO barbeiroDTO, @PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(barbeiroService.atualizar(barbeiroDTO, id));
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "listarBarbeiros", allEntries = true)
    public ResponseEntity<Response> excluir(@PathVariable("id") Integer id) {
        barbeiroService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
