package com.Clinicia.Clinica.controllAdvice;

import com.Clinicia.Clinica.infra.exceptions.*;
import com.Clinicia.Clinica.infra.security.ExceptionValidarDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdviceClinica {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity erroValidar(MethodArgumentNotValidException ex){
       List<ExceptionValidarDTO> listaErro = ex.getFieldErrors()
               .stream()
               .map(e->new ExceptionValidarDTO(e.getField(),e.getDefaultMessage()))
               .collect(Collectors.toList());
       return ResponseEntity.badRequest().body(listaErro);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity erroValidarEnum(IllegalArgumentException ex){
        return ResponseEntity.badRequest().body(new ExceptionValidarDTO("especialidae",ex.getMessage()));
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity erro404(EntityNotFoundException ex){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(ParametroVazioException.class)
    public ResponseEntity errorParametroVazio(ParametroVazioException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    @ExceptionHandler(ValidacaoMedicoConsultaNoDiaException.class)
    public ResponseEntity erroMarcaConsulta(ValidacaoMedicoConsultaNoDiaException ex){
        return ResponseEntity.badRequest().body((ex.getMessage()));
    }
    @ExceptionHandler(ValidacaoPacienteConsultaNoDiaException.class)
    public ResponseEntity erroMarcaConsulta(ValidacaoPacienteConsultaNoDiaException ex){
        return ResponseEntity.badRequest().body((ex.getMessage()));
    }
    @ExceptionHandler(ValidarMedicoAtivoException.class)
    public ResponseEntity erroMarcaConsulta(ValidarMedicoAtivoException ex){
        return ResponseEntity.badRequest().body((ex.getMessage()));
    }
    @ExceptionHandler(ValidarPacienteAtivoException.class)
    public ResponseEntity erroMarcaConsulta(ValidarPacienteAtivoException ex){
        return ResponseEntity.badRequest().body((ex.getMessage()));
    }




}
