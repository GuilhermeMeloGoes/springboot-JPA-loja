package com.guilherme.curso.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @JsonIgnore
    @ManyToMany(mappedBy = "categorias")
    private Set<Produto> produtos = new HashSet<>();

    // Construtor
    public Categoria() {
    }

    public Categoria(Long id, String descricao) {

        this.id = id;
        this.descricao = descricao;
    }

    // Gets e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    // Métodos
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }


}
