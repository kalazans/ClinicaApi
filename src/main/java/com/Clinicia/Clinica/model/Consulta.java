package com.Clinicia.Clinica.model;

import com.Clinicia.Clinica.dto.RemaracarConsultaDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private Long idMedico;
    private Long idPaciente;
    private String nomeMedico;
    private String nomePaciente;
    @Enumerated(EnumType.STRING)
    private ESPECIALIDADE especialidade;
    private LocalDate dateConsulta;
    private Boolean concluida;

    public Consulta(){}
    public Consulta(Paciente paciente,Medico medico,String dataConsulta){
        this.idMedico = medico.getId();
        this.idPaciente = paciente.getId();
        this.nomeMedico = medico.getFirstName() +" "+ medico.getLastName();
        this.nomePaciente = paciente.getFirstName()+" "+paciente.getLastName();
        this.especialidade = medico.getEspecialidade();
        this.dateConsulta = LocalDate.parse(dataConsulta, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public Long getId() {
        return id;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public LocalDate getDateConsulta() {
        return dateConsulta;
    }
    public ESPECIALIDADE getEspecialidade() {
        return especialidade;
    }

    public Boolean getConcluida() {
        return concluida;
    }

    public void atualizarConsulta(RemaracarConsultaDTO remaracarConsultaDTO){
        this.dateConsulta = LocalDate.parse(remaracarConsultaDTO.novaData(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consulta consulta = (Consulta) o;
        return Objects.equals(idMedico, consulta.idMedico) && Objects.equals(idPaciente, consulta.idPaciente) && Objects.equals(dateConsulta, consulta.dateConsulta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMedico, idPaciente, dateConsulta);
    }
}
