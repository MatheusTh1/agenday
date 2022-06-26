package com.projeto.sistema.agendamento.mapper;

import com.projeto.sistema.agendamento.model.dto.AgendaDTO;
import com.projeto.sistema.agendamento.model.dto.BarbeiroDTO;
import com.projeto.sistema.agendamento.model.entity.AgendaEntity;
import com.projeto.sistema.agendamento.model.entity.BarbeiroEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AgendaMapper {

    private final ModelMapper mapper;

    public List<AgendaDTO> toAgendaResponseList(List<AgendaEntity> agendaEntityList) {
        return agendaEntityList.stream()
                .map(this::toAgendaResponse)
                .collect(Collectors.toList());
    }

    public AgendaEntity toAgendaEntity(AgendaDTO agendaDTO) {
        return mapper.map(agendaDTO, AgendaEntity.class);
    }

    public AgendaDTO toAgendaResponse(AgendaEntity agendaEntity) {
        return mapper.map(agendaEntity, AgendaDTO.class);
    }
}
