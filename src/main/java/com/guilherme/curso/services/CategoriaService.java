package com.guilherme.curso.services;

import com.guilherme.curso.entities.Categoria;
import com.guilherme.curso.entities.Usuario;
import com.guilherme.curso.repositories.CategoriaRepository;
import com.guilherme.curso.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria findById(Long id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.get();
    }
}
