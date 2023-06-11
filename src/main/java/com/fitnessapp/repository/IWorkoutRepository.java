package com.fitnessapp.repository;

import com.fitnessapp.model.Workout;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IWorkoutRepository extends JpaRepository<Workout, String> {

  @Query("SELECT w FROM Workout w " +
      "WHERE w.date = :date " +
      "AND w.muscularGroup = :name " +
      "GROUP BY w.muscularGroup")
  Workout findByName(String name, Date date);

  @Query("SELECT w FROM Workout w " +
      "WHERE w.date = :date " +
      "GROUP BY w.muscularGroup")
  List<Workout> findWorkoutsByDate(Date date);

}
