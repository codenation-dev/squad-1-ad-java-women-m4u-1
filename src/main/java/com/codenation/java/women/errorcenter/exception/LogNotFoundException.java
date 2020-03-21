package com.codenation.java.women.errorcenter.exception;

public class LogNotFoundException extends RuntimeException{

    private Long id;

    public LogNotFoundException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "O log com id="+ id + " não foi encontrado";
    }
}
