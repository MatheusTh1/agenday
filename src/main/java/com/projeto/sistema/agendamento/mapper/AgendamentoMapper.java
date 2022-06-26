package com.projeto.sistema.agendamento.mapper;

import com.projeto.sistema.agendamento.model.dto.AgendamentoDTO;
import com.projeto.sistema.agendamento.model.entity.AgendamentoEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AgendamentoMapper {

    private final ModelMapper mapper;

    public List<AgendamentoDTO> toAgendamentoResponseList(List<AgendamentoEntity> agendamentoEntityList) {
        return agendamentoEntityList.stream()
                .map(this::toAgendamentoResponse)
                .collect(Collectors.toList());
    }

    public AgendamentoEntity toAgendamentoEntity(AgendamentoDTO agendamentoDTO) {
        return mapper.map(agendamentoDTO, AgendamentoEntity.class);
    }

    public AgendamentoEntity toAgendamentoEntity(AgendamentoEntity agendamentoEntity) {
        return mapper.map(agendamentoEntity, AgendamentoEntity.class);
    }

    public AgendamentoDTO toAgendamentoResponse(AgendamentoEntity agendamentoEntity) {
        return mapper.map(agendamentoEntity, AgendamentoDTO.class);
    }
}
