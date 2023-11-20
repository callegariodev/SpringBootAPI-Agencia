package com.projetos.bancoapi.service;

import com.projetos.bancoapi.model.Conta;
import com.projetos.bancoapi.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    @Autowired
    public ContaService(ContaRepository contaRepository){
        this.contaRepository = contaRepository;
    }

    public void saveConta(Conta conta){
        contaRepository.save(conta);
    }

    public List<Conta> findAll(){
        return contaRepository.findAll();
    }
}
