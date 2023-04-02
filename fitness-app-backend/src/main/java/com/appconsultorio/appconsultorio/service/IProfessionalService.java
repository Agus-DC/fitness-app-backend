package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.dtos.request.ProfessionalDTO;
import com.appconsultorio.appconsultorio.model.Professional;

import java.time.LocalDateTime;
import java.util.List;

public interface IProfessionalService {
    void createProfessional(ProfessionalDTO professionalDTO);
    void updateProfessional(ProfessionalDTO professionalDTO);
    void removeProfessional(int id);
    List<Professional> getProfessional() ;
    List<Professional> findProfessionalWithMoreOf2Turns(LocalDateTime date);
}
