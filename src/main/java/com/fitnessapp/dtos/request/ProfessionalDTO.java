package com.fitnessapp.dtos.request;

import com.fitnessapp.model.Turn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@AllArgsConstructor
@Setter
@Getter
public class ProfessionalDTO {

    private int id;
    private String name;
    private String surname;
    private Integer idCalendar;
    Set<Turn> turnSet;

}
