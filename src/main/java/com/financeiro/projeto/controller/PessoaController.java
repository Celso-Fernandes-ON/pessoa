package com.financeiro.projeto.controller;

import com.financeiro.projeto.dto.DadosCadastroPessoa;
import com.financeiro.projeto.dto.DadosDetalhamentoPessoa;
import com.financeiro.projeto.dto.DadosListagemPessoa;
import com.financeiro.projeto.services.PessoaServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    private PessoaServices services;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid
                                    DadosCadastroPessoa dados,
                                    UriComponentsBuilder uriBuilder){
        var pessoa = services.cadastrar(dados);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new DadosDetalhamentoPessoa(pessoa));
        //return ResponseEntity.ok().build();

    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemPessoa>> Listar(@PageableDefault(
            size = 10, sort = {"nome"}) Pageable peginacao){
        Page<DadosListagemPessoa> page =
        services.listarPessoa(peginacao);
    return ResponseEntity.ok(page);
    }

}
