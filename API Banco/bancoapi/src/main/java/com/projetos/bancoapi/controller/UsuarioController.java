package com.projetos.bancoapi.controller;

import com.projetos.bancoapi.dto.usuario.UsuarioRequestDTO;
import com.projetos.bancoapi.dto.usuario.UsuarioResponseDTO;
import com.projetos.bancoapi.model.Pessoa;
import com.projetos.bancoapi.model.Usuario;
import com.projetos.bancoapi.service.PessoaService;
import com.projetos.bancoapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private UsuarioService usuarioService;
    private PessoaService pessoaService;
    @Autowired
    public UsuarioController(UsuarioService usuarioService, PessoaService pessoaService) {
        this.usuarioService = usuarioService;
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public String saveUser(@RequestBody UsuarioRequestDTO data){
        try{
            Pessoa pessoa = pessoaService.recuperaPessoaPorDocumento(data.documento());
            Usuario usuario = new Usuario(data);
            usuario.setPessoa(pessoa);
            usuarioService.saveUser(usuario);
            return "Salvou Usuário";
        }catch (Exception e){
            return "Erro: " + e.getMessage();
        }
    }

    @GetMapping
    private List<UsuarioResponseDTO> getAll(){

        List<UsuarioResponseDTO>  listUser = usuarioService.findAll().stream().map(UsuarioResponseDTO::new).toList();

        return listUser;
    }

    @DeleteMapping
    private String deleteAll(){
        usuarioService.deleteAll();
        return "Usuários Deletados";
    }

}
