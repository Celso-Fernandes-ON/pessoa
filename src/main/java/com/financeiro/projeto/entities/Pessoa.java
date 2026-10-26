package com.financeiro.projeto.entities;

import com.financeiro.projeto.dto.DadosCadastroPessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pessoa")
@Entity(name = "Pessoa")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;


    public Pessoa(DadosCadastroPessoa dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.endereco = new Endereco(dados.endereco());
    }
}
