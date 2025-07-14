package com.guilherme.curso.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Conteudo não encontrado! Id: " + id);
    }

}
