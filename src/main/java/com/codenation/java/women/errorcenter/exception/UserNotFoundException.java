package com.codenation.java.women.errorcenter.exception;

public class UserNotFoundException extends RuntimeException{

    private Long id;

    public  UserNotFoundException(Long id) {
        this.id = id;
    }

    public  Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "O usuário com o id="+ id + "não foi encontrado";
    }
}
