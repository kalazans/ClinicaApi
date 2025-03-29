package com.Clinicia.Clinica.service;

import com.Clinicia.Clinica.dto.AtualizarInfoMedicoDTO;
import com.Clinicia.Clinica.model.ESPECIALIDADE;
import com.Clinicia.Clinica.model.Medico;
import com.Clinicia.Clinica.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {
    @Autowired
    MedicoRepository medicoRepository;

    public void salvarDB(Medico medico){
        medicoRepository.save(medico);

    }

    public Medico atualizarDB(Long id, AtualizarInfoMedicoDTO atualizarInfoMedicoDTO){
        Medico medico = medicoRepository.getReferenceById(id);
        medico.atualizarInfo(atualizarInfoMedicoDTO);
        return medico;
    }

    public Medico acharPorIdDB(Long id){
        return medicoRepository.findById(id).get();
    }

    public List<Medico> listaDB(){
       return  medicoRepository.findAll();
    }

    public List<Medico> listaPorEspecialidadeDB(ESPECIALIDADE especialidade){
       return medicoRepository.findByEspecialidade(especialidade);
    }

    public boolean idExiste(Long id){
        return medicoRepository.existsById(id);
    }


}
