package com.fitnessapp.service;

import com.fitnessapp.dtos.request.WorkoutDTO;
import com.fitnessapp.model.Workout;
import com.fitnessapp.repository.IWorkoutRepository;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WorkoutService implements IWorkoutService{

  ModelMapper mapper;

  IWorkoutRepository iWorkoutRepository;

  @Override
  public void addWorkout(WorkoutDTO workoutDTO) {
    Workout workout = mapper.map(workoutDTO, Workout.class);
    iWorkoutRepository.save(workout);
  }

  @Override
  public void addWorkoutList(List<WorkoutDTO> workoutDTOList) {
    workoutDTOList.forEach(this::addWorkout);
  }

  @Override
  public void updateWorkout(WorkoutDTO workoutDTO) {
    this.addWorkout(workoutDTO);
  }

  @Override
  public void deleteWorkout(String name, Date date) {
    Workout workout = iWorkoutRepository.findByName(name, date);
    iWorkoutRepository.delete(workout);
  }

  @Override
  public void deleteWorkoutsByDate(Date date) {
    List<Workout> workoutList = iWorkoutRepository.findWorkoutsByDate(date);
    iWorkoutRepository.deleteAll(workoutList);
  }

  @Override
  public List<Workout> getWorkoutByDate(Date date) {
    return iWorkoutRepository.findWorkoutsByDate(date);
  }

  @Override
  public Workout getWorkoutByMuscularGroup(Date date, String muscularGroup) {
    return iWorkoutRepository.findByName(muscularGroup, date);
  }

}
