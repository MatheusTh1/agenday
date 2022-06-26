package com.projeto.sistema.agendamento.mapper;

import com.projeto.sistema.agendamento.model.dto.ClienteDTO;
import com.projeto.sistema.agendamento.model.entity.ClienteEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClienteMapper {

    private final ModelMapper mapper;

    public List<ClienteDTO> toClienteResponseList(List<ClienteEntity> clienteEntityList) {
        return clienteEntityList.stream()
                .map(this::toClienteResponse)
                .collect(Collectors.toList());
    }

    public ClienteEntity toClienteEntity(ClienteDTO clienteDTO) {
        return mapper.map(clienteDTO, ClienteEntity.class);
    }

    public ClienteDTO toClienteResponse(ClienteEntity clienteEntity) {
        return mapper.map(clienteEntity, ClienteDTO.class);
    }
}
