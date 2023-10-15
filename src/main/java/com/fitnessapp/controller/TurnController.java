package com.fitnessapp.controller;

import com.fitnessapp.dtos.request.TurnDTO;
import com.fitnessapp.model.Turn;
import com.fitnessapp.service.ITurnService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("turn")
@AllArgsConstructor
public class TurnController {

    ITurnService iTurnService;


    /**
     * @return turnos reprogramados
     */
    @GetMapping("/findreprogramedturns")
    public ResponseEntity<List<Turn>> findTurnosLikeReprogramed(){
        return new ResponseEntity<>(iTurnService.findTurnosLikeReprogramed(), HttpStatus.OK);
    }

    /**
     * @return turnos finalizados
     */
    @GetMapping("/findfinalizedturns")
    public ResponseEntity<List<Turn>> findTurnosLikeFinalizado(){
        return new ResponseEntity<>(iTurnService.findTurnosLikeFinalizado(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> loadTurn(@RequestBody TurnDTO turnDTO) throws Exception {
        return ResponseEntity.ok("Turno " + iTurnService.createTurn(turnDTO) + " creado correctamente.");
    }


    @PutMapping("/edit")
    public ResponseEntity<String> editTurn(@RequestBody TurnDTO turnDTO){
        return ResponseEntity.ok("Turno editado correctamente, nuevo id: " + iTurnService.updateTurn(turnDTO));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeTurn(@RequestParam int id){
        iTurnService.removeTurn(id);
        return ResponseEntity.ok("Turno " + id + "eliminado correctamente" );
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Turn>> getTurns(){
        return new ResponseEntity<>(iTurnService.getTurn(), HttpStatus.OK);
    }
}
