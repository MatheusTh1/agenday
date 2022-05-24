package com.projeto.sistema.agendamento.service;

import com.projeto.sistema.agendamento.model.dto.Status;
import com.projeto.sistema.agendamento.model.dto.StatusDTO;
import com.projeto.sistema.agendamento.model.entity.StatusEntity;
import com.projeto.sistema.agendamento.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public List<Status> listarTodos() {
        List<StatusEntity> lstStatusEntity = statusRepository.findAll();
        List<Status> lststatusDTO = new ArrayList<>();

        for(StatusEntity status : lstStatusEntity) {
            Status response = new Status();

            response.setId(status.getIdStatus());
            response.setDescricao(status.getDescricao());

            lststatusDTO.add(response);
        }

        return lststatusDTO;

    }

    public StatusDTO salvar(StatusDTO statusDTO) {
                StatusEntity statusEntity = new StatusEntity();

        statusEntity.setDescricao(statusDTO.getDescricao());

        statusRepository.save(statusEntity);

        return statusDTO;
    }
}
