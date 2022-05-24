package com.projeto.sistema.agendamento.repository;

import com.projeto.sistema.agendamento.model.entity.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<AgendaEntity, Integer>  {
}
