package com.Clinicia.Clinica.model;

import com.Clinicia.Clinica.dto.AtualizarInfoMedicoDTO;
import com.Clinicia.Clinica.dto.MedicoDTO;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private ESPECIALIDADE especialidade;
    @Embedded
    private Adress adress;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private Integer crm;
    private boolean ativo = false;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ESPECIALIDADE getEspecialidade() {
        return especialidade;
    }

    public Adress getAdress() {
        return adress;
    }

    public String getEmail() {
        return email;
    }

    public Integer getCrm() {
        return crm;
    }
    public Long getId() {
        return id;
    }

    public boolean isAtivo() {
        return ativo;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", especialidade=" + especialidade +
                ", adress=" + adress +
                ", email='" + email + '\'' +
                ", crm='" + crm + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return Objects.equals(crm, medico.crm);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(crm);
    }

    public Medico(){}

    public Medico(MedicoDTO medicoDTO){
        this.firstName = medicoDTO.firstName();
        this.lastName = medicoDTO.lastName();
        this.adress =  new Adress(medicoDTO.adress());
        this.email = medicoDTO.email();
        this.crm = Integer.valueOf(medicoDTO.crm());
        this.especialidade = ESPECIALIDADE.valueOf(medicoDTO.especialidade().toUpperCase());
        this.ativo = true;
    }

    public void atualizarInfo(AtualizarInfoMedicoDTO atualizarInfoMedicoDTO){
        this.email = atualizarInfoMedicoDTO.email();
        this.adress = new Adress(atualizarInfoMedicoDTO.adressDTO());
    }
}
