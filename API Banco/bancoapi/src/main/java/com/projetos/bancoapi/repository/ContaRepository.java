package com.projetos.bancoapi.repository;

import com.projetos.bancoapi.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
