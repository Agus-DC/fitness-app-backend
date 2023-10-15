package com.fitnessapp.controller;

import com.fitnessapp.dtos.request.ClientDTO;
import com.fitnessapp.model.Client;
import com.fitnessapp.service.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("client")
@AllArgsConstructor
public class ClientController {

    IClientService iClientService;

    /**
     * Listar todos los professionalas que tengan más de dos turnos en una fecha
     */
 /*   @GetMapping("/findclientbydateforprofessionals")
    public ResponseEntity<List<Client>> getClientByDateForProfessionals(@RequestParam String date){
        LocalDateTime dt = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return new ResponseEntity<>(iClientService.getClientByDateForProfessionals(dt), HttpStatus.OK);
    }*/


    @PostMapping("/create")
    public String loadClient(@RequestBody ClientDTO clientDTO){
        iClientService.createClient(clientDTO);
        return "Paciente creado correctamente";
    }

    @PostMapping("/edit")
    public String editClient(@RequestBody ClientDTO clientDTO){
        iClientService.updateClient(clientDTO);
        return "Paciente editado correctamente";
    }

    @PostMapping("/remove")
    public String removeClient(@RequestParam int id){
        iClientService.removeClient(id);
        return "Paciente eliminado correctamente";
    }

    @GetMapping("/getall")
    public List<Client> getClients(){
        return iClientService.getClient();
    }
}

