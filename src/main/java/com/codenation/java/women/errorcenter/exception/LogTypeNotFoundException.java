package com.codenation.java.women.errorcenter.exception;

public class LogTypeNotFoundException extends RuntimeException{

    private Long id;

    public LogTypeNotFoundException(Long id) {
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "O logType com id="+ id + " não foi encontrado";
    }

}
