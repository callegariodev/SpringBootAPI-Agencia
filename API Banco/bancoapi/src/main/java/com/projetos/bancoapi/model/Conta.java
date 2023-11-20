package com.projetos.bancoapi.model;

import com.projetos.bancoapi.dto.conta.ContaRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Table(name = "conta")
@Entity(name = "conta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column (name = "numero_conta")
    private int numeroConta;

    @ColumnDefault(value = "0.00")
    private double saldo;

    public Conta(ContaRequestDTO data){
        this.numeroConta = data.numConta();
    }

}
