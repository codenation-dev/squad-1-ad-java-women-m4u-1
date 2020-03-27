package com.codenation.java.women.errorcenter.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserNotFoundException extends RuntimeException{

    private Long id;

    public  UserNotFoundException(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "O usuário com o id="+ id + "não foi encontrado";
    }
}