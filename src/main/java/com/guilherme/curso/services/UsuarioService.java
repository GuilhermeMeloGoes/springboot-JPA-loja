package com.guilherme.curso.services;

import com.guilherme.curso.entities.Usuario;
import com.guilherme.curso.repositories.UsuarioRepository;
import com.guilherme.curso.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario insert(Usuario usuario) {
        return repository.save(usuario);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Usuario update(Long id, Usuario usuario) {
        Usuario entidade = repository.getReferenceById(id);
        updateData(entidade, usuario);
        return repository.save(entidade);
    }

    private void updateData(Usuario entidade, Usuario usuario) {
        entidade.setNome(usuario.getNome());
        entidade.setEmail(usuario.getEmail());
        entidade.setTelefone(usuario.getTelefone());
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
