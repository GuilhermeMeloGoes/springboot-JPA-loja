package com.guilherme.curso.repositories;

import com.guilherme.curso.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


}
