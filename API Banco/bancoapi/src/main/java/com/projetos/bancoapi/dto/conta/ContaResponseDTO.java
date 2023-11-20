package com.projetos.bancoapi.dto.conta;

import com.projetos.bancoapi.model.Conta;
import com.projetos.bancoapi.model.Usuario;

public record ContaResponseDTO(String nomeUsuario, int numConta, double saldo) {
    public ContaResponseDTO(Conta conta){
        this(conta.getUsuario().getNomeUsuario(), conta.getNumeroConta(), conta.getSaldo());
    }
}
