package com.artur.cadastroalunosspring.exceptions;

public class ResponsavelNotFoundException extends RuntimeException{

    public ResponsavelNotFoundException(String msg){
        super(msg);
    }
}
