package com.guilherme.curso.config;

import com.guilherme.curso.entities.Categoria;
import com.guilherme.curso.entities.Pedido;
import com.guilherme.curso.entities.Produto;
import com.guilherme.curso.entities.Usuario;
import com.guilherme.curso.entities.enums.StatusPedido;
import com.guilherme.curso.repositories.CategoriaRepository;
import com.guilherme.curso.repositories.PedidoRepository;
import com.guilherme.curso.repositories.ProdutoRepository;
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

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {

        Categoria ca1 = new Categoria(null, "Eletronicos");
        Categoria ca2 = new Categoria(null, "Livros");
        Categoria ca3 = new Categoria(null, "Computadores");

        Produto prod1 = new Produto(null, "O senhor dos aneis", "Dor, mas não muito", 90.5, " ");
        Produto prod2 = new Produto(null, "Smart TV", "Não existe imperdieta pura. Mecenas antes", 2190.0, " ");
        Produto prod3 = new Produto(null, "Macbook Pro", "Não existe ninguém que ama a própria dor, que procura por ela e quer senti-la, simplesmente porque ela é dor", 1250.0, " ");
        Produto prod4 = new Produto(null, "Pc Gamer", "Portanto, não se preocupe com o ódio, com o curso da doença", 1200.0, " ");
        Produto prod5 = new Produto(null, "Ruby on Rails for Dummies", "Amanhã, o vale estará verde ou verde.", 100.99, " ");

        categoriaRepository.saveAll(Arrays.asList(ca1, ca2, ca3));
        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5));

        prod1.getCategorias().add(ca2);
        prod2.getCategorias().add(ca3);
        prod2.getCategorias().add(ca1);
        prod3.getCategorias().add(ca3);
        prod4.getCategorias().add(ca3);
        prod5.getCategorias().add(ca2);

        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5));

        Usuario usu1 = new Usuario(null, "Guilherm Silva", "guilherme@gmail.com", "98888888", "123456");
        Usuario usu2 = new Usuario(null, "Sandra Alves", "sandra@gmail.com", "97777777", "123456");

        Pedido ped1 = new Pedido(null, Instant.parse("2025-06-11T16:53:07Z"), StatusPedido.PAGO, usu1);
        Pedido ped2 = new Pedido(null, Instant.parse("2025-07-12T17:17:00Z"), StatusPedido.ESPERANDO_PAGAMENTO, usu2);
        Pedido ped3 = new Pedido(null, Instant.parse("2025-07-13T05:42:10Z"), StatusPedido.ESPERANDO_PAGAMENTO, usu1);


        usuarioRepository.saveAll(Arrays.asList(usu1, usu2));

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3));


    }
}
