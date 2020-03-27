package com.codenation.java.women.errorcenter.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LogTypeNotFoundException extends RuntimeException {

    private Long id;

    public  LogTypeNotFoundException(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "O LogTYpe com o id="+ id + "não foi encontrado";
    }
}

