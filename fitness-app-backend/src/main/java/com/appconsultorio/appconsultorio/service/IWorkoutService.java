package com.appconsultorio.appconsultorio.service;

import com.appconsultorio.appconsultorio.dtos.request.WorkoutDTO;
import java.util.Date;
import java.util.List;

public interface IWorkoutService {
  Object addWorkout(WorkoutDTO workoutDTO);

  Object updateWorkout(WorkoutDTO workoutDTO);

  Object deleteWorkout(String name);

  Object deleteWorkoutList(Date date);

  Object addWorkoutList(List<WorkoutDTO> workoutDTOList);
}
