package com.appconsultorio.appconsultorio.repository;

import com.appconsultorio.appconsultorio.model.Diet;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IDietRepository extends JpaRepository<Diet, Long> {

  // Encontrar el las dietas de la fecha seleccionada
  @Query("SELECT d FROM Diet d " +
      "WHERE d.date = :date " +
      "AND d.number = :number " +
      "GROUP BY d.number")
  Diet findDietById(@Param("date") Date date, @Param("number") Long number);

  @Query("SELECT d FROM Diet d " +
      "WHERE d.date = :date " +
      "GROUP BY d.number")
  List<Diet> findDietListByDate(@Param("date") Date date);

}
