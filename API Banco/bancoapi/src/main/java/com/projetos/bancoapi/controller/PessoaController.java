package com.projetos.bancoapi.controller;

import com.projetos.bancoapi.dto.pessoa.PessoaRequestDTO;
import com.projetos.bancoapi.dto.pessoa.PessoaResponseDTO;
import com.projetos.bancoapi.model.Pessoa;
import com.projetos.bancoapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    private PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public String savePessoa(@RequestBody PessoaRequestDTO data){
        try{
            Pessoa pessoaData = new Pessoa(data);
            pessoaService.salvarPessoa(pessoaData);
        }catch(Exception e) {
            return "Erro: " + e.getCause();
        }

        return "Salvo";
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<PessoaResponseDTO> getAll(){

        List<PessoaResponseDTO> pessoaList = pessoaService.findAll().stream().map(PessoaResponseDTO::new).toList();
        return pessoaList;
    }
}
