package com.fitnessapp.service;
import com.fitnessapp.dtos.request.ProfessionalDTO;
import com.fitnessapp.model.Professional;

import java.time.LocalDateTime;
import java.util.List;

public interface IProfessionalService {
    void createProfessional(ProfessionalDTO professionalDTO);
    void updateProfessional(ProfessionalDTO professionalDTO);
    void removeProfessional(int id);
    List<Professional> getProfessional() ;
    //List<Professional> findProfessionalWithMoreOf2Turns(LocalDateTime date);
}
