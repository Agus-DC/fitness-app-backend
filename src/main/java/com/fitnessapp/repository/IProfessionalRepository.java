package com.fitnessapp.repository;
import com.fitnessapp.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IProfessionalRepository extends JpaRepository<Professional,Integer> {

    //Listar todos los professionalas que tengan más de dos turnos en una fecha
   /* @Query("select d from Professional d " +
            "join d.turnSet t " +
            "where t.startTime = :date " +
            "group by d HAVING COUNT(t) > 2")
    List<Professional> findProfessionalWithMoreOf2Turns(@Param("date")LocalDateTime date);
*/
    //La query en sql la haria asi:
    /**
     SELECT professionals.name,COUNT(t.id_turn) AS trns
     FROM professionals
     JOIN turns_professionals td ON td.id_professional = professionals.id_professional
     JOIN turns t ON td.id_turn = t.id_turn
     GROUP BY professionals.name HAVING trns > 2;
     */

}

