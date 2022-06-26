package com.projeto.sistema.agendamento.controller;

import com.projeto.sistema.agendamento.model.dto.StatusDTO;
import com.projeto.sistema.agendamento.service.StatusService;
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
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    @Cacheable(value = "listarStatus")
    public ResponseEntity<List<StatusDTO>> listar() {
        return ResponseEntity.ok().body(statusService.listar());
    }

    @PostMapping
    @CacheEvict(value = "listarStatus", allEntries = true)
    public ResponseEntity<StatusDTO> criar(@RequestBody StatusDTO statusDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(statusService.salvar(statusDTO));
    }

    @PutMapping()
    @CacheEvict(value = "listarStatus", allEntries = true)
    public ResponseEntity<StatusDTO> atualizar(@RequestBody StatusDTO statusDTO, @PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(statusService.atualizar(statusDTO, id));
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "listarStatus", allEntries = true)
    public ResponseEntity<Response> excluir(@PathVariable("id") Integer id) {
        statusService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
