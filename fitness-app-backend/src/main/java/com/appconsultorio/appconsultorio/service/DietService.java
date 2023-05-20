package com.appconsultorio.appconsultorio.service;

import com.appconsultorio.appconsultorio.dtos.request.DietDTO;
import com.appconsultorio.appconsultorio.model.Diet;
import com.appconsultorio.appconsultorio.repository.IDietRepository;
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

  public void addMeal(DietDTO dietDTO) {
    Diet diet = mapper.map(dietDTO, Diet.class);
    iDietRepository.save(diet);
  }

  public void addMealList(List<DietDTO> dietDTOList) {
    dietDTOList.forEach(this::addMeal);
  }

  public void updateMeal(DietDTO dietDTO) {
    addMeal(dietDTO);
  }

  public void deleteMeal(Date date, long number) {
    Diet dietToDelete = iDietRepository.findDietById(date, number);
    iDietRepository.delete(dietToDelete);
  }

  public void deleteMealList(Date date) {
    List<Diet> dietListToDelete = iDietRepository.findDietListByDate(date);
    iDietRepository.deleteAll(dietListToDelete);
  }

  public List<Diet> getDietListByDate(Date date) {
    return iDietRepository.findDietListByDate(date);
  }

  public Diet getDietById(Date date, long number) {
    return iDietRepository.findDietById(date, number);
  }
}
