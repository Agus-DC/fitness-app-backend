package com.appconsultorio.appconsultorio.controller;

import com.appconsultorio.appconsultorio.dtos.request.WorkoutDTO;
import com.appconsultorio.appconsultorio.service.IWorkoutService;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("workout")
@AllArgsConstructor
public class WorkoutController {

  IWorkoutService workoutService;

  @PostMapping("/add")
  public ResponseEntity addWorkout(@RequestBody WorkoutDTO workoutDTO) {
    return new ResponseEntity<>(workoutService.addWorkout(workoutDTO), HttpStatus.OK);
  }

  @PutMapping("/update")
  public ResponseEntity updateWorkout(@RequestBody WorkoutDTO workoutDTO) {
    return new ResponseEntity<>(workoutService.updateWorkout(workoutDTO), HttpStatus.OK);
  }

  @PostMapping("/delete")
  public ResponseEntity deleteWorkout(@RequestBody String name) {
    return new ResponseEntity(workoutService.deleteWorkout(name), HttpStatus.OK);
  }

  @PostMapping("/delete_list")
  public ResponseEntity deleteWorkout(@RequestBody Date date) {
    return new ResponseEntity(workoutService.deleteWorkoutList(date), HttpStatus.OK);
  }

  @PostMapping("/add_list")
  public ResponseEntity addWorkoutList(@RequestBody List<WorkoutDTO> workoutDTOList) {
    return new ResponseEntity<>(workoutService.addWorkoutList(workoutDTOList), HttpStatus.OK);
  }
}
