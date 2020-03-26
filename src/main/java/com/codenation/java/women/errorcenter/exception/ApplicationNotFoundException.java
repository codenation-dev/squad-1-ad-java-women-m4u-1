package com.codenation.java.women.errorcenter.exception;

public class ApplicationNotFoundException extends RuntimeException {

    private Long id;

    public ApplicationNotFoundException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "A aplicação com id="+ id + " não foi encontrada";
    }
}
