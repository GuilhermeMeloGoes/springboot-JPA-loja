package com.guilherme.curso.services;

import com.guilherme.curso.entities.Pedido;
import com.guilherme.curso.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public List<Pedido> findAll() {
        return repository.findAll();
    }

    public Pedido findById(Long id) {
        Optional<Pedido> obj = repository.findById(id);
        return obj.get();
    }
}
