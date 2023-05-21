package com.appconsultorio.appconsultorio.service;

import com.appconsultorio.appconsultorio.dtos.request.DietDTO;
import com.appconsultorio.appconsultorio.model.Diet;
import java.util.Date;
import java.util.List;

public interface IDietService {
  void addMeal(DietDTO dietDTO);

  void addMealList(List<DietDTO> dietDTOList);

  void updateMeal(DietDTO dietDTO);

  void deleteMeal(Date date, long number);

  void deleteMealList(Date date);

  List<Diet> getMealListByDate(Date date);

  Diet getMealById(Date date, long number);
}
