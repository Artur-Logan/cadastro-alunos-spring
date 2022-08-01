package com.artur.cadastroalunosspring.exceptions;

public class AlunoNotFoundException extends RuntimeException{

    public AlunoNotFoundException(String msg){
        super(msg);
    }
}