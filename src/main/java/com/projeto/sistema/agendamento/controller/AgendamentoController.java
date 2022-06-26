package com.projeto.sistema.agendamento.controller;

import com.projeto.sistema.agendamento.model.dto.AgendamentoDTO;
import com.projeto.sistema.agendamento.model.entity.AgendamentoEntity;
import com.projeto.sistema.agendamento.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PutMapping
    public ResponseEntity<AgendamentoEntity> atualizar(@RequestBody AgendamentoDTO agendamentoDTO) {
        agendamentoService.atualizar(agendamentoDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
