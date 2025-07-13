package com.guilherme.curso.entities.enums;

public enum StatusPedido {
    ESPERANDO_PAGAMENTO(1),
    PAGO(2),
    ENVIADO(3),
    ENTREGUE(4),
    CANCELADO(5);

    private int code;

    private StatusPedido(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static StatusPedido valueOf(int code) {
        for (StatusPedido s : StatusPedido.values()) {
            if (s.getCode() == code) {
                return s;
            }
        }
        throw new IllegalArgumentException("Código informado inválido!");
    }
}
