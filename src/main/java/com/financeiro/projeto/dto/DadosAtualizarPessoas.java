package com.financeiro.projeto.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizarPessoas(
        @NotBlank
        Long id,
        String nome,
        DadosEndereco endereco
) {


}
