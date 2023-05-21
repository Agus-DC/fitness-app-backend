package com.appconsultorio.appconsultorio.controller;

import com.appconsultorio.appconsultorio.dtos.request.DietDTO;
import com.appconsultorio.appconsultorio.model.Diet;
import com.appconsultorio.appconsultorio.service.IDietService;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("diet")
@AllArgsConstructor
public class DietController {

  IDietService dietService;

  @PostMapping("/add-meal")
  public ResponseEntity<HttpStatus> addDiet(@RequestBody DietDTO dietDTO) {
    dietService.addMeal(dietDTO);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/add-meal-list")
  public ResponseEntity<HttpStatus> addMealList(@RequestBody List<DietDTO> dietDTOList) {
    dietService.addMealList(dietDTOList);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping("/update-meal")
  public ResponseEntity<HttpStatus> updateMeal(@RequestBody DietDTO dietDTO) {
    dietService.updateMeal(dietDTO);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/delete-meal")
  public ResponseEntity<HttpStatus> deleteMeal(@RequestBody long number, Date date) {
    dietService.deleteMeal(date, number);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/delete-meal-list")
  public ResponseEntity<HttpStatus> deleteMeal(@RequestBody Date date) {
    dietService.deleteMealList(date);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/get-meal")
  public ResponseEntity<Diet> getMealById(@RequestBody Date date, @RequestBody long number) {
    return new ResponseEntity<>(dietService.getMealById(date, number), HttpStatus.OK);
  }

  @GetMapping("/get-meal-list")
  public ResponseEntity<List<Diet>> getMealByDate(@RequestBody Date date) {
    return new ResponseEntity<>(dietService.getMealListByDate(date), HttpStatus.OK);
  }
}
