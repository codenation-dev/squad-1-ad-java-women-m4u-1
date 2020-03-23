package com.codenation.java.women.errorcenter.exception;

public class LogTypeNotFoundException extends RuntimeException {

    private Long id;

    public  LogTypeNotFoundException(Long id) {
            this.id = id;
        }

    public  Long getId() {
            return id;
        }

        @Override
        public String toString() {
            return "O LogTYpe com o id="+ id + "não foi encontrado";
        }
    }
