package com.fitnessapp.service;

import com.fitnessapp.dtos.request.CalendarsDTO;
import com.fitnessapp.model.Calendars;

import java.util.List;

public interface ICalendarService {

     void createCalendar(CalendarsDTO calendarsDTO);
     void updateCalendar(CalendarsDTO calendarsDTO);
     void removeCalendar(int id);
     List<Calendars> getCalendar() ;
     Calendars getCalendarFromProfessional(Integer professional_id);
}
