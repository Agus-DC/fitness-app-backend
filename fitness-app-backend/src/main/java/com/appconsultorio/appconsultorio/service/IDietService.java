package com.appconsultorio.appconsultorio.service;

import com.appconsultorio.appconsultorio.dtos.request.DietDTO;
import java.util.Date;
import java.util.List;

public interface IDietService {
  Object addMeal(DietDTO dietDTO);

  Object addMealList(List<DietDTO> dietDTOList);

  Object updateMeal(DietDTO dietDTO);

  Object deleteMeal(String number, Date date);

  Object deleteMealList(Date date);
}
