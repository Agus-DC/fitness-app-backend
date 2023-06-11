package com.appconsultorio.appconsultorio.controller;

import com.appconsultorio.appconsultorio.dtos.request.WorkoutDTO;
import com.appconsultorio.appconsultorio.model.Workout;
import com.appconsultorio.appconsultorio.service.IWorkoutService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public ResponseEntity<HttpStatus> addWorkout(@RequestBody WorkoutDTO workoutDTO) {
    workoutService.addWorkout(workoutDTO);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping("/update")
  public ResponseEntity<HttpStatus> updateWorkout(@RequestBody WorkoutDTO workoutDTO) {
    workoutService.updateWorkout(workoutDTO);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/delete")
  public ResponseEntity<HttpStatus> deleteWorkout(@RequestBody String name, @RequestBody Date date) {
    workoutService.deleteWorkout(name, date);
    return new ResponseEntity(HttpStatus.OK);
  }

  @PostMapping("/delete-list")
  public ResponseEntity<HttpStatus> deleteWorkout(@RequestBody Date date) {
    workoutService.deleteWorkoutsByDate(date);
    return new ResponseEntity(HttpStatus.OK);
  }

  @PostMapping("/add-list")
  public ResponseEntity<HttpStatus> addWorkoutList(@RequestBody List<WorkoutDTO> workoutDTOList) {
    workoutService.addWorkoutList(workoutDTOList);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/get-list/{date}")
  public ResponseEntity<List<Workout>> getWorkoutList(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) throws ParseException {
    return new ResponseEntity<>(workoutService.getWorkoutByDate(date), HttpStatus.OK);
  }

  @PostMapping("/get")
  public ResponseEntity<Workout> getWorkout(@RequestBody Date date, @RequestBody String muscularGroup) {
    return new ResponseEntity<>(workoutService.getWorkoutByMuscularGroup(date, muscularGroup), HttpStatus.OK);
  }
}
