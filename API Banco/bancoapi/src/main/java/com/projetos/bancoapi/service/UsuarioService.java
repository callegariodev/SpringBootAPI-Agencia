package com.projetos.bancoapi.service;

import com.projetos.bancoapi.model.Usuario;
import com.projetos.bancoapi.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @PersistenceContext
    private EntityManager em;

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> findUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario saveUser(Usuario usuario) {
        usuario.setCodigo(gerarCodigo());
        return usuarioRepository.save(usuario);
    }

    public Usuario recuperaUsuarioPorNomeAcesso(String nomeAcesso){
        return usuarioRepository.findByNomeUsuario(nomeAcesso).
                orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado para o nome : " + nomeAcesso));
    }

    public void deleteUserById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public void deleteAll(){
        usuarioRepository.deleteAll();
    }
    private int gerarCodigo(){
        String sql = "select coalesce(max(codigo),0) from usuario ";

        Query query = em.createNativeQuery(sql);
        int codigo = (int) query.getSingleResult();

        return codigo + 1;
    }

}
