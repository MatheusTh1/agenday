package com.projeto.sistema.agendamento.repository;

import com.projeto.sistema.agendamento.model.entity.AgendamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Integer>  {
}
