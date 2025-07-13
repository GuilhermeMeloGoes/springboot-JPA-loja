package com.guilherme.curso.repositories;

import com.guilherme.curso.entities.PedidoItem;
import com.guilherme.curso.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {


}
