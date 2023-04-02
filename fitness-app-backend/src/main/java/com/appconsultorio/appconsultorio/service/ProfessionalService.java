package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.dtos.request.ProfessionalDTO;
import com.appconsultorio.appconsultorio.model.Calendars;
import com.appconsultorio.appconsultorio.model.Professional;
import com.appconsultorio.appconsultorio.repository.ICalendarRepository;
import com.appconsultorio.appconsultorio.repository.IProfessionalRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ProfessionalService implements IProfessionalService {

    ModelMapper mapper;
    IProfessionalRepository iProfessionalRepository;
    ICalendarRepository iCalendarRepository;

    @Override
    public List<Professional> findProfessionalWithMoreOf2Turns(LocalDateTime date){
        return iProfessionalRepository.findProfessionalWithMoreOf2Turns(date);
    }

    @Override
    public void createProfessional(ProfessionalDTO professionalDTO) {
        Professional professional = mapper.map(professionalDTO, Professional.class);
        professional.setCalendars(new Calendars(professional));
        iProfessionalRepository.save(professional);
    }

    @Override
    public void updateProfessional(ProfessionalDTO professionalDTO) {
        Professional professional = mapper.map(professionalDTO, Professional.class);
        iProfessionalRepository.save(professional);
    }

    @Override
    public void removeProfessional(int id) {
        iProfessionalRepository.deleteById(id);
    }

    @Override
    public List<Professional> getProfessional() {
        return iProfessionalRepository.findAll();
    }
}
