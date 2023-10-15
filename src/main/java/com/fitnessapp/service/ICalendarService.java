package com.fitnessapp.service;

import com.fitnessapp.dtos.request.CalendarDTO;
import com.fitnessapp.model.Calendar;

import java.util.List;

public interface ICalendarService {

     void createCalendar(CalendarDTO calendarDTO);
     void updateCalendar(CalendarDTO calendarDTO);
     void removeCalendar(int id);
     List<Calendar> getCalendar() ;
     Calendar getCalendarFromProfessional(Integer professional_id);
}
