package com.projetos.bancoapi.service;


import com.projetos.bancoapi.dto.pessoa.PessoaResponseDTO;
import com.projetos.bancoapi.model.Pessoa;
import com.projetos.bancoapi.repository.PessoaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @PersistenceContext
    private EntityManager em;
    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Optional<Pessoa> obterPessoaPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    public void salvarPessoa(Pessoa pessoa) {
        pessoa.setCodigo(gerarCodigo());
        pessoaRepository.save(pessoa);
    }

    public void excluirPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa recuperaPessoaPorDocumento(String documento) {
        return pessoaRepository.findByDocumento(documento)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada para o documento: " + documento));
    }

    public Integer gerarCodigo(){
        String sql = "select max(codigo) from pessoa";

        Query query = em.createNativeQuery(sql);
        Integer codigo = (Integer) query.getSingleResult();

        return codigo + 1;
    }
}
