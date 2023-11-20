package com.projetos.bancoapi.repository;

import com.projetos.bancoapi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface
PessoaRepository extends JpaRepository<Pessoa, Long> {
    Optional<Pessoa> findByDocumento(String documento);
}
