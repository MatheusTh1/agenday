package com.projeto.sistema.agendamento.service;

import com.projeto.sistema.agendamento.exception.ResourceNoContentException;
import com.projeto.sistema.agendamento.mapper.StatusMapper;
import com.projeto.sistema.agendamento.model.dto.StatusDTO;
import com.projeto.sistema.agendamento.model.entity.StatusEntity;
import com.projeto.sistema.agendamento.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    private final StatusMapper mapper;

    public List<StatusDTO> listar() {
        List<StatusEntity> lstStatusEntity = statusRepository.findAll();
        return mapper.toStatusResponseList(lstStatusEntity);
    }

    public StatusDTO salvar(StatusDTO statusDTO) {
        if(isNull(statusRepository.findByDescricao(statusDTO.getDescricao()))) {
            StatusEntity statusEntity = mapper.toStatusEntity(statusDTO);

            statusRepository.save(statusEntity);
            return mapper.toStatusResponse(statusEntity);
        };

        throw new ResourceNoContentException("Status ["+ statusDTO.getDescricao() + "] Já existente!");
    }

    public StatusDTO atualizar(StatusDTO statusDTO, Integer id) {
        verificarSeExisteStatus(id);

        statusRepository.save(new StatusEntity(id, statusDTO.getDescricao()));
        return mapper.toStatusResponse(new StatusEntity(id, statusDTO.getDescricao()));
    }

    public void excluir(Integer id) {
        verificarSeExisteStatus(id);

        statusRepository.deleteById(id);
    }

    private void verificarSeExisteStatus(Integer id) {
        Optional<StatusEntity> status = statusRepository.findById(id);

        if(!status.isPresent()) {
            throw new ResourceNoContentException("Status não encontrado: [ " + id + " ]");
        }
    }
}
