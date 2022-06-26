package com.projeto.sistema.agendamento.repository;

import com.projeto.sistema.agendamento.model.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer>  {
}
