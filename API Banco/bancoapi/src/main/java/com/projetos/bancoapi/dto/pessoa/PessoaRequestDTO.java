package com.projetos.bancoapi.dto.pessoa;

import java.util.Date;

public record PessoaRequestDTO(String nome, String documento, Date dataNascimento) {

}
