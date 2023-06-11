package com.fitnessapp.service;

import com.fitnessapp.dtos.request.DietDTO;
import com.fitnessapp.model.Diet;
import com.fitnessapp.repository.IDietRepository;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DietService implements IDietService{

  ModelMapper mapper;

  IDietRepository iDietRepository;

  @Override
  public void addMeal(DietDTO dietDTO) {
    Diet diet = mapper.map(dietDTO, Diet.class);
    iDietRepository.save(diet);
  }

  @Override
  public void addMealList(List<DietDTO> dietDTOList) {
    dietDTOList.forEach(this::addMeal);
  }

  @Override
  public void updateMeal(DietDTO dietDTO) {
    addMeal(dietDTO);
  }

  @Override
  public void deleteMeal(Date date, long number) {
    Diet dietToDelete = iDietRepository.findDietById(date, number);
    iDietRepository.delete(dietToDelete);
  }

  @Override
  public void deleteMealList(Date date) {
    List<Diet> dietListToDelete = iDietRepository.findDietListByDate(date);
    iDietRepository.deleteAll(dietListToDelete);
  }

  @Override
  public List<Diet> getMealListByDate(Date date) {
    return iDietRepository.findDietListByDate(date);
  }

  @Override
  public Diet getMealById(Date date, long number) {
    return iDietRepository.findDietById(date, number);
  }
}
