package com.projeto.sistema.agendamento.service;

import com.projeto.sistema.agendamento.mapper.AgendaMapper;
import com.projeto.sistema.agendamento.model.dto.AgendaDTO;
import com.projeto.sistema.agendamento.model.entity.AgendaEntity;
import com.projeto.sistema.agendamento.repository.AgendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    private final AgendaMapper mapper;

    public List<AgendaDTO> listar() {
        List<AgendaEntity> lstAgendaEntity = agendaRepository.findByStatusAvailable();

        return mapper.toAgendaResponseList(lstAgendaEntity);
    }
}
