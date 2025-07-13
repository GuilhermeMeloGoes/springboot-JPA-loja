package com.guilherme.curso.repositories;

import com.guilherme.curso.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {


}
