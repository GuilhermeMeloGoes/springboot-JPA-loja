package com.guilherme.curso.resource;

import com.guilherme.curso.entities.Usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @GetMapping
    public ResponseEntity<Usuario> findAll() {
        Usuario u = new Usuario(1L, "Maria", "maria@gmail.com", "(79) 99962-3478", "12345");
        return ResponseEntity.ok().body(u);
    }

}
