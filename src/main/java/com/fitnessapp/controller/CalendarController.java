package com.fitnessapp.controller;

import com.fitnessapp.dtos.request.CalendarsDTO;
import com.fitnessapp.model.Calendars;
import com.fitnessapp.service.ICalendarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("calendar")
@AllArgsConstructor
public class CalendarController {

    ICalendarService iCalendarService;

    @PostMapping("/create")
    public String loadCalendar(@RequestBody CalendarsDTO calendarDTO){
        iCalendarService.createCalendar(calendarDTO);
        return "Calendario creado correctamente";
    }

    @PostMapping("/edit")
    public String editProfessional(@RequestBody CalendarsDTO calendarsDTO){
        iCalendarService.updateCalendar(calendarsDTO);
        return "Professional editado correctamente";
    }

    @PostMapping("/remove")
    public String removeProfessional(@RequestParam int id){
        iCalendarService.removeCalendar(id);
        return "Professional eliminado correctamente";
    }

    @GetMapping("/getall")
    public List<Calendars> getCalendar(){
        return iCalendarService.getCalendar();
    }

    @GetMapping("/getcalendarfromprofessional")
    public ResponseEntity<Calendars> getCalendarFromProfessional(@RequestParam Integer professional_id){
        return new ResponseEntity<>(iCalendarService.getCalendarFromProfessional(professional_id), HttpStatus.OK);
    }
}
