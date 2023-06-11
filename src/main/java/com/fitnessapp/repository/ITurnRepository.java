package com.fitnessapp.repository;
import com.fitnessapp.model.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITurnRepository extends JpaRepository<Turn,Integer> {

    //listar todos los turnos finalizados
    @Query("SELECT t FROM Turn t where t.status LIKE '%Finalizado%' ")
    List<Turn> findTurnosLikeFinalizado();

    @Query("SELECT t FROM Turn t where t.status LIKE '%Reprogramado%' ")
    List<Turn> findTurnosLikeReprogramed();
}
