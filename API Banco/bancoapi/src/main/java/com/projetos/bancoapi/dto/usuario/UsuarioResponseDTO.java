package com.projetos.bancoapi.dto.usuario;

import com.projetos.bancoapi.model.Usuario;

public record UsuarioResponseDTO(int codigo, String nomePessoa, String nomeUsuario, String email, String celular, boolean master) {
    public UsuarioResponseDTO(Usuario user) {
        this(user.getCodigo(), user.getPessoa().getNome(), user.getNomeUsuario(), user.getEmail(), user.getCelular(), user.isMaster());
    }

}