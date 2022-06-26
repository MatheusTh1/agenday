package com.projeto.sistema.agendamento.service;

import com.projeto.sistema.agendamento.exception.ResourceNoContentException;
import com.projeto.sistema.agendamento.mapper.AgendaMapper;
import com.projeto.sistema.agendamento.mapper.AgendamentoMapper;
import com.projeto.sistema.agendamento.model.dto.AgendamentoDTO;
import com.projeto.sistema.agendamento.model.entity.*;
import com.projeto.sistema.agendamento.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
public class AgendamentoService {
    private final static Integer STATUS_INDISPONIVEL = 2;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private AgendaRepository agendaRepository;

    private final AgendamentoMapper mapperAgendamento;

    private final AgendaMapper mapeprAgenda;

    public void atualizar(AgendamentoDTO agendamentoDTO) {
        if(!isNull(agendamentoDTO)) {
            AgendamentoEntity agendamento = new AgendamentoEntity();
            AgendaEntity agendaEntity = new AgendaEntity();

            Optional<AgendaEntity> agendaEntityRepository = agendaRepository.findById(agendamentoDTO.getIdAgenda());
            AgendaEntity agenda = agendaEntityRepository.orElseThrow(()
                    -> new ResourceNoContentException("Agenda do barbeiro não encontrada: [ " + agendamentoDTO.getIdAgenda() + " ]"));

            Optional<ClienteEntity> clienteEntity = clienteRepository.findById(agendamentoDTO.getIdCliente());
            agendaEntity.setClienteEntity(clienteEntity.orElseThrow(()
                    -> new ResourceNoContentException("Cliente não encontrado: [ " + agendamentoDTO.getIdCliente() + " ]")));

            Optional<BarbeiroEntity> barbeiroEntity = barbeiroRepository.findById(agendamentoDTO.getIdBarbeiro());
            agendaEntity.setBarbeiroEntity(barbeiroEntity.orElseThrow(()
                    -> new ResourceNoContentException("Barbeiro não encontrado: [ " + agendamentoDTO.getIdBarbeiro() + " ]")));

            Optional<StatusEntity> statusEntity = statusRepository.findById(STATUS_INDISPONIVEL);
            agendaEntity.setStatusEntity(statusEntity.orElseThrow(()
                    -> new ResourceNoContentException("Status não encontrado: [ " + STATUS_INDISPONIVEL + " ]")));

            Optional<ServicoEntity> servicoEntity = servicoRepository.findById(agendamentoDTO.getIdServico());
            agendaEntity.setServicoEntity(servicoEntity.orElseThrow(()
                    -> new ResourceNoContentException("Serviço não encontrado: [ " + agendamentoDTO.getIdServico() + " ]")));

            agenda.setClienteEntity(agendaEntity.getClienteEntity());
            agenda.setServicoEntity(agendaEntity.getServicoEntity());
            agenda.setStatusEntity(agendaEntity.getStatusEntity());

            agendamento.setAgendaEntity(agenda);

            agendaRepository.save(agenda);
            agendamentoRepository.save(agendamento);
        }
    }
}
