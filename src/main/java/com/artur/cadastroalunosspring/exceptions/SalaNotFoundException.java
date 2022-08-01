package com.artur.cadastroalunosspring.exceptions;

public class SalaNotFoundException extends RuntimeException {
    public SalaNotFoundException(String message) {
        super(message);
    }
}
