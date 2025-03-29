package com.Clinicia.Clinica.infra.exceptions;

public class ParametroVazioException extends RuntimeException{
    public ParametroVazioException(String message){
        super((message));
    }
}
