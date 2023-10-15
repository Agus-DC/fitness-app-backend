package com.fitnessapp.repository;
import com.fitnessapp.model.Turn;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITurnRepository extends JpaRepository<Turn,Integer> {

    //listar todos los turnos finalizados
    @Query("SELECT t FROM Turn t where t.status = '%Finalizado%' ")
    List<Turn> findTurnosLikeFinalizado();

    @Query("SELECT t FROM Turn t where t.status = '%Reprogramado%' ")
    List<Turn> findTurnosLikeReprogramed();

    @Query("SELECT t FROM Turn t")
    List<Turn> getAll();

    @Query("SELECT t FROM Turn t where t.calendar.professional.id =: id")
    List<Turn> getAllFromCalendar(Integer id);
    //@Query("SELECT t FROM Turn t WHERE t.startTime < :startTime")
    //Turn findFirstByStartTimeEquals(@Param("startTime") LocalDateTime startTime);

    @Query("SELECT t FROM Turn t WHERE (t.startTime >= :startTimeLimit) AND (t.startTime <= :endTimeLimit)")
    List<Turn> findTurnsWithinMargin(@Param("startTimeLimit") Timestamp startTimeLimit, @Param("endTimeLimit") Timestamp endTimeLimit);

}

