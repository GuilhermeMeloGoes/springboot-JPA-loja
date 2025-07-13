package com.guilherme.curso.config;

import com.guilherme.curso.entities.Usuario;
import com.guilherme.curso.repositories.UsarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private UsarioRepository usuarioRepository;


    @Override
    public void run(String... args) throws Exception {
        Usuario usu1 = new Usuario(null, "Guilherm Silva", "guilherme@gmail.com", "98888888", "123456");
        Usuario usu2 = new Usuario(null, "Sandra Alves", "sandra@gmail.com", "97777777", "123456");

        usuarioRepository.saveAll(Arrays.asList(usu1, usu2));

    }
}
