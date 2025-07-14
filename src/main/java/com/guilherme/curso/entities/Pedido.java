package com.guilherme.curso.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.guilherme.curso.entities.enums.StatusPedido;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-HH-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant momentoPedido;

    private Integer status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    @OneToMany(mappedBy = "id.pedido")
    private Set<PedidoItem> items = new HashSet<>();

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    // Construtores
    public Pedido() {
    }

    public Pedido(Long id, Instant momentoPedido, StatusPedido status, Usuario cliente) {
        this.id = id;
        this.momentoPedido = momentoPedido;
        setStatus(status);
        this.cliente = cliente;
    }

    // Gets e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomentoPedido() {
        return momentoPedido;
    }

    public void setMomentoPedido(Instant momentoPedido) {
        this.momentoPedido = momentoPedido;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public StatusPedido getStatus() {
        return StatusPedido.valueOf(status);
    }

    public void setStatus(StatusPedido status) {
        if (status != null) {
            this.status = status.getCode();
        }
    }

    public Set<PedidoItem> getItems() {
        return items;
    }

    // Métodos

    public Double getValorTotal() {
        double total = 0.0;
        for (PedidoItem p : items) {
            total += p.getSubTotal();
        }
        return total;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", momentoPedido=" + momentoPedido +
                ", cliente=" + cliente +
                '}';
    }
}
