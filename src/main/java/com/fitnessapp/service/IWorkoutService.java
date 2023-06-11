package com.fitnessapp.service;

import com.fitnessapp.dtos.request.WorkoutDTO;
import com.fitnessapp.model.Workout;
import java.util.Date;
import java.util.List;

public interface IWorkoutService {
  void addWorkout(WorkoutDTO workoutDTO);

  void updateWorkout(WorkoutDTO workoutDTO);

  void deleteWorkout(String name, Date date);

  void deleteWorkoutsByDate(Date date);

  void addWorkoutList(List<WorkoutDTO> workoutDTOList);

  List<Workout> getWorkoutByDate(Date date);

  Workout getWorkoutByMuscularGroup(Date date, String muscularGroup);
}
