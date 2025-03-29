package com.Clinicia.Clinica.model;

import com.Clinicia.Clinica.dto.AdressDTO;
import jakarta.persistence.Embeddable;

import java.util.Objects;
@Embeddable
public class Adress {
    private String cidade;
    private String bairro;
    private String estado;

    public Adress(){}
    public Adress(AdressDTO adressDTO){
        this.cidade = adressDTO.cidade();
        this.bairro = adressDTO.bairro();
        this.estado =adressDTO.estado();

    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adress adress = (Adress) o;
        return Objects.equals(cidade, adress.cidade) && Objects.equals(bairro, adress.bairro) && Objects.equals(estado, adress.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cidade, bairro, estado);
    }




}
