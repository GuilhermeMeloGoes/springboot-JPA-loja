package com.guilherme.curso.config;

import com.guilherme.curso.entities.Pedido;
import com.guilherme.curso.entities.Usuario;
import com.guilherme.curso.repositories.PedidoRepository;
import com.guilherme.curso.repositories.UsuarioRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void run(String... args) throws Exception {
        Usuario usu1 = new Usuario(null, "Guilherm Silva", "guilherme@gmail.com", "98888888", "123456");
        Usuario usu2 = new Usuario(null, "Sandra Alves", "sandra@gmail.com", "97777777", "123456");

        Pedido ped1 = new Pedido(null, Instant.parse("2025-06-11T16:53:07Z"), usu1);
        Pedido ped2 = new Pedido(null, Instant.parse("2025-07-12T17:17:00Z"), usu2);
        Pedido ped3 = new Pedido(null, Instant.parse("2025-07-13T05:42:10Z"), usu1);

        usuarioRepository.saveAll(Arrays.asList(usu1, usu2));

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3));

    }
}
