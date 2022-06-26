package com.projeto.sistema.agendamento.controller;

import com.projeto.sistema.agendamento.model.dto.AgendaDTO;
import com.projeto.sistema.agendamento.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @GetMapping
    public ResponseEntity<List<AgendaDTO>> listar() {
        return ResponseEntity.ok().body(agendaService.listar());
    }
}
