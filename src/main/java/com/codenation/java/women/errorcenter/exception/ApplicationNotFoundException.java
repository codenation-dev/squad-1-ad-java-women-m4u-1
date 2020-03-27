package com.codenation.java.women.errorcenter.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ApplicationNotFoundException extends RuntimeException {

    private Long id;

    public ApplicationNotFoundException(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "A aplicação com id="+ id + " não foi encontrada";
    }
}
