package com.projetos.bancoapi.controller;

import com.projetos.bancoapi.dto.conta.ContaRequestDTO;
import com.projetos.bancoapi.dto.conta.ContaResponseDTO;
import com.projetos.bancoapi.model.Conta;
import com.projetos.bancoapi.service.ContaService;
import com.projetos.bancoapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("conta")
public class ContaController {

    private ContaService contaService;
    private UsuarioService usuarioService;

    @Autowired
    public ContaController(ContaService contaService, UsuarioService usuarioService){
        this.contaService = contaService;
        this.usuarioService = usuarioService;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public String saveConta(@RequestBody ContaRequestDTO data){
        try{
            Conta conta = new Conta(data);
            conta.setUsuario(usuarioService.recuperaUsuarioPorNomeAcesso(data.nomeUsuario()));
            contaService.saveConta(conta);
            return "Conta Salva";
        }catch (Exception e){
            return "Erro: " + e.getMessage();
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ContaResponseDTO> getAll(){
        List<ContaResponseDTO> contaList = contaService.findAll().stream().map(ContaResponseDTO::new).toList();
        return contaList;
    }
}
