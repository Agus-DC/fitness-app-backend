package com.fitnessapp.controller;
import com.fitnessapp.dtos.request.ProfessionalDTO;
import com.fitnessapp.model.Professional;
import com.fitnessapp.service.IProfessionalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@RestController
@RequestMapping("professional")
@AllArgsConstructor
public class ProfessionalController {

    IProfessionalService iProfessionalService;

    /**
     * Listar todos los professionalas que tengan más de dos turnos en una fecha
     */
    @GetMapping("/findprofessionalwithmoreof2turns")
    public ResponseEntity<List<Professional>> findProfessionalWithMoreOf2Turns(@RequestParam String date){
        LocalDateTime dt = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return new ResponseEntity<>(iProfessionalService.findProfessionalWithMoreOf2Turns(dt), HttpStatus.OK);
    }


    @PostMapping("/create")
    public String loadProfessional(@RequestBody ProfessionalDTO professionalDTO){
        iProfessionalService.createProfessional(professionalDTO);
        return "Professional creado correctamente";
    }

    @PostMapping("/edit")
    public String editProfessional(@RequestBody ProfessionalDTO professionalDTO){
        iProfessionalService.updateProfessional(professionalDTO);
        return "Professional editado correctamente";
    }

    @PostMapping("/remove")
    public String removeProfessional(@RequestParam int id){
        iProfessionalService.removeProfessional(id);
        return "Professional eliminado correctamente";
    }

    @GetMapping("/getall")
    public List<Professional> getProfessionals(){
        return iProfessionalService.getProfessional();
    }
}
