package com.guilherme.curso.repositories;

import com.guilherme.curso.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsarioRepository extends JpaRepository<Usuario, Long> {


}
