package com.projeto.sistema.agendamento.mapper;

import com.projeto.sistema.agendamento.model.dto.BarbeiroDTO;
import com.projeto.sistema.agendamento.model.entity.BarbeiroEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BarbeiroMapper {

    private final ModelMapper mapper;

    public List<BarbeiroDTO> toBarbeiroResponseList(List<BarbeiroEntity> barbeiroEntityList) {
        return barbeiroEntityList.stream()
                .map(this::toBarbeiroResponse)
                .collect(Collectors.toList());
    }

    public BarbeiroEntity toBarbeiroEntity(BarbeiroDTO barbeiroDTO) {
        return mapper.map(barbeiroDTO, BarbeiroEntity.class);
    }

    public BarbeiroDTO toBarbeiroResponse(BarbeiroEntity barbeiroEntity) {
        return mapper.map(barbeiroEntity, BarbeiroDTO.class);
    }
}
