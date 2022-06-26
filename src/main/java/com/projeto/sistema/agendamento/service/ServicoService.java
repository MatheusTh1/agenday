package com.projeto.sistema.agendamento.service;

import com.projeto.sistema.agendamento.exception.ResourceNoContentException;
import com.projeto.sistema.agendamento.mapper.ServicoMapper;
import com.projeto.sistema.agendamento.model.dto.ServicoDTO;
import com.projeto.sistema.agendamento.model.entity.ServicoEntity;
import com.projeto.sistema.agendamento.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    private final ServicoMapper mapper;

    public List<ServicoDTO> listar() {
        List<ServicoEntity> lstServicoEntity = servicoRepository.findAll();

        return mapper.toServicoResponseList(lstServicoEntity);
    }

    public ServicoDTO salvar(ServicoDTO servicoDTO) {
        if(!isNull(servicoDTO)) {
            servicoRepository.save(mapper.toServicoEntity(servicoDTO));
        }

        return servicoDTO;
    }

    public ServicoDTO atualizar(ServicoDTO servicoDTO, Integer id) {
        verificarSeExisteServico(id);

        servicoDTO.setId(id);
        servicoRepository.save(mapper.toServicoEntity(servicoDTO));

        return servicoDTO;
    }

    public void excluir (Integer id) {
        verificarSeExisteServico(id);

        servicoRepository.deleteById(id);
    }

    private Optional<ServicoEntity> verificarSeExisteServico(Integer id) {
        Optional<ServicoEntity> servico = servicoRepository.findById(id);

        if(servico.isEmpty()) {
            throw new ResourceNoContentException("Serviço não encontrado: [ " + id + " ]");
        }

        return servico;
    }
}
