package com.fitnessapp.service;
import com.fitnessapp.dtos.request.CalendarDTO;
import com.fitnessapp.model.Calendar;
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
    public void createCalendar(CalendarDTO calendarDTO) {
        Calendar calendar = mapper.map(calendarDTO, Calendar.class);
        iCalendarRepository.save(calendar);
    }

    @Override
    public void updateCalendar(CalendarDTO calendarDTO) {
        Calendar calendar = mapper.map(calendarDTO, Calendar.class);
        iCalendarRepository.save(calendar);
    }

    @Override
    public void removeCalendar(int id) {
        iCalendarRepository.deleteById(id);
    }

    @Override
    public List<Calendar> getCalendar() {
        return iCalendarRepository.findAll();
    }

    @Override
    public Calendar getCalendarFromProfessional(Integer professional_id){
        return iCalendarRepository.getCalendarFromProfessional(professional_id);
    }
}
