package com.projeto.sistema.agendamento.mapper;

import com.projeto.sistema.agendamento.model.dto.ServicoDTO;
import com.projeto.sistema.agendamento.model.entity.ServicoEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ServicoMapper {

    private final ModelMapper mapper;

    public List<ServicoDTO> toServicoResponseList(List<ServicoEntity> servicoEntityList) {
        return servicoEntityList.stream()
                .map(this::toServicoResponse)
                .collect(Collectors.toList());
    }

    public ServicoEntity toServicoEntity(ServicoDTO servicoDTO) {
        return mapper.map(servicoDTO, ServicoEntity.class);
    }

    public ServicoDTO toServicoResponse(ServicoEntity servicoEntity) {
        return mapper.map(servicoEntity, ServicoDTO.class);
    }
}
