package com.projeto.sistema.agendamento.service;

import com.projeto.sistema.agendamento.exception.ResourceNoContentException;
import com.projeto.sistema.agendamento.mapper.BarbeiroMapper;
import com.projeto.sistema.agendamento.model.dto.BarbeiroDTO;
import com.projeto.sistema.agendamento.model.entity.BarbeiroEntity;
import com.projeto.sistema.agendamento.repository.BarbeiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
public class BarbeiroService {

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    private final BarbeiroMapper mapper;

    public List<BarbeiroDTO> listar() {
        List<BarbeiroEntity> lstBarbeiroEntity = barbeiroRepository.findAll();

        return mapper.toBarbeiroResponseList(lstBarbeiroEntity);
    }

    public BarbeiroDTO salvar(BarbeiroDTO barbeiroDTO) {
        if(!isNull(barbeiroDTO)) {
            barbeiroRepository.save(mapper.toBarbeiroEntity(barbeiroDTO));
        }

        return barbeiroDTO;
    }

    public BarbeiroDTO atualizar(BarbeiroDTO barbeiroDTO, Integer id) {
        verificarSeExisteBarbeiro(barbeiroDTO.getId());

        barbeiroDTO.setId(id);
        barbeiroRepository.save(mapper.toBarbeiroEntity(barbeiroDTO));

        return barbeiroDTO;
    }

    public void excluir (Integer id) {
        verificarSeExisteBarbeiro(id);

        barbeiroRepository.deleteById(id);
    }

    private void verificarSeExisteBarbeiro(Integer id) {
        Optional<BarbeiroEntity> status = barbeiroRepository.findById(id);

        if(!status.isPresent()) {
            throw new ResourceNoContentException("Barbeiro não encontrado: [ " + id + " ]");
        }
    }
}
