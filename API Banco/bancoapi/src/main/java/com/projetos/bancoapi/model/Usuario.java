package com.projetos.bancoapi.model;

import com.projetos.bancoapi.dto.usuario.UsuarioRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuario")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @Column (name = "nome_usuario")
    private String nomeUsuario;

    private String email;

    private String senha;

    private String celular;

    private int codigo;

    private boolean master;

    public Usuario(UsuarioRequestDTO data) {
        this.nomeUsuario = data.nomeUsuario();
        this.celular = data.celular();
        this.email = data.email();
        this.senha = data.senha();
    }

}
