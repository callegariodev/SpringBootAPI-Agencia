package com.projetos.bancoapi.model;

import com.projetos.bancoapi.dto.pessoa.PessoaRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Table(name = "pessoa")
@Entity(name = "pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(unique = true, nullable = false)
    private int codigo;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String documento;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    public Pessoa(PessoaRequestDTO data) {
        this.nome = data.nome();
        this.documento = data.documento();
        this.dataNascimento = data.dataNascimento();
    }

}
