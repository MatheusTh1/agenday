package com.projeto.sistema.agendamento.controller;

import com.projeto.sistema.agendamento.model.dto.Status;
import com.projeto.sistema.agendamento.model.dto.StatusDTO;
import com.projeto.sistema.agendamento.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    public ResponseEntity<List<Status>> listar() {
        return ResponseEntity.ok().body(statusService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<StatusDTO> criar(@RequestBody StatusDTO statusDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(statusService.salvar(statusDTO));
    }
}
