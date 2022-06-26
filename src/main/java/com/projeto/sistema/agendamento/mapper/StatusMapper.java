package com.projeto.sistema.agendamento.mapper;

import com.projeto.sistema.agendamento.model.dto.StatusDTO;
import com.projeto.sistema.agendamento.model.entity.StatusEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StatusMapper {

    private final ModelMapper mapper;

    public List<StatusDTO> toStatusResponseList(List<StatusEntity> lstStatusEntity) {
        return lstStatusEntity.stream()
                .map(this::toStatusResponse)
                .collect(Collectors.toList());
    }

    public StatusEntity toStatusEntity(StatusDTO statusDTO) {
        return mapper.map(statusDTO, StatusEntity.class);
    }

    public StatusDTO toStatusResponse(StatusEntity statusEntity) {
        return mapper.map(statusEntity, StatusDTO.class);
    }
}
