package com.projetos.bancoapi.dto.pessoa;

import com.projetos.bancoapi.model.Pessoa;
import jakarta.persistence.Column;

import java.util.Date;
import java.util.UUID;

public record PessoaResponseDTO(int codigo, String nome, String documento, Date dataNascimento) {

    public PessoaResponseDTO(Pessoa pessoa){
        this(pessoa.getCodigo(), pessoa.getNome(), pessoa.getDocumento(), pessoa.getDataNascimento());
    }
}
