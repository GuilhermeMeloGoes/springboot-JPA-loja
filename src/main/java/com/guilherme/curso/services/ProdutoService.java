package com.guilherme.curso.services;

import com.guilherme.curso.entities.Categoria;
import com.guilherme.curso.entities.Produto;
import com.guilherme.curso.repositories.CategoriaRepository;
import com.guilherme.curso.repositories.PedidoRepository;
import com.guilherme.curso.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto findById(Long id) {
        Optional<Produto> obj = repository.findById(id);
        return obj.get();
    }
}
