package com.appconsultorio.appconsultorio.controller;

import com.appconsultorio.appconsultorio.dtos.request.DietDTO;
import com.appconsultorio.appconsultorio.service.IDietService;
import java.net.http.HttpRequest;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

  @PostMapping("/add_meal")
  public ResponseEntity addDiet(@RequestBody DietDTO dietDTO) {
    return new ResponseEntity<>(dietService.addMeal(dietDTO), HttpStatus.OK);
  }

  @PostMapping("/add_meal_list")
  public ResponseEntity addMealList(@RequestBody List<DietDTO> dietDTOList) {
    return new ResponseEntity<>(dietService.addMealList(dietDTOList), HttpStatus.OK);
  }

  @PutMapping("/update_meal")
  public ResponseEntity updateMeal(@RequestBody DietDTO dietDTO) {
    return new ResponseEntity<>(dietService.updateMeal(dietDTO), HttpStatus.OK);
  }

  @PostMapping("/delete_meal")
  public ResponseEntity deleteMeal(@RequestBody String number, Date date) {
    return new ResponseEntity(dietService.deleteMeal(number, date), HttpStatus.OK);
  }

  @PostMapping("/delete_meal_list")
  public ResponseEntity deleteMeal(@RequestBody Date date) {
    return new ResponseEntity(dietService.deleteMealList(date), HttpStatus.OK);
  }
}
