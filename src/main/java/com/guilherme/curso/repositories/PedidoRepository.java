package com.guilherme.curso.repositories;

import com.guilherme.curso.entities.Pedido;
import com.guilherme.curso.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {


}
