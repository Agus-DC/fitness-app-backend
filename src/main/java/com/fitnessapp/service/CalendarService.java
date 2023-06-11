package com.fitnessapp.service;
import com.fitnessapp.dtos.request.CalendarsDTO;
import com.fitnessapp.model.Calendars;
import com.fitnessapp.repository.ICalendarRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CalendarService implements ICalendarService {

    ModelMapper mapper;
    ICalendarRepository iCalendarRepository;

    @Override
    public void createCalendar(CalendarsDTO calendarsDTO) {
        Calendars calendars = mapper.map(calendarsDTO, Calendars.class);
        iCalendarRepository.save(calendars);
    }

    @Override
    public void updateCalendar(CalendarsDTO calendarsDTO) {
        Calendars calendars = mapper.map(calendarsDTO, Calendars.class);
        iCalendarRepository.save(calendars);
    }

    @Override
    public void removeCalendar(int id) {
        iCalendarRepository.deleteById(id);
    }

    @Override
    public List<Calendars> getCalendar() {
        return iCalendarRepository.findAll();
    }

    @Override
    public Calendars getCalendarFromProfessional(Integer professional_id){
        return iCalendarRepository.getCalendarFromProfessional(professional_id);
    }
}
