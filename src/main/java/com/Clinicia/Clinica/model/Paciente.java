package com.Clinicia.Clinica.model;


import com.Clinicia.Clinica.dto.PacienteDTO;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String cpf;
    private boolean ativo = false;

    public Paciente(PacienteDTO pacienteDTO) {
        this.firstName = pacienteDTO.firstName();
        this.lastName = pacienteDTO.lastName();;
        this.email = pacienteDTO.email();
        this.cpf = pacienteDTO.cpf();
        this.ativo =true;
    }

    public Paciente(){}

    public Long getId() {
        return Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean isAtivo() {
        return ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(cpf, paciente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
