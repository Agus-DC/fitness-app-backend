package com.fitnessapp.repository;
import com.fitnessapp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IClientRepository extends JpaRepository<Client,Integer> {

    //Listar todos los pacientes de un día de todos los professionalas.
    @Query("select p from Client p " +
            "join p.turnSet t " +
            "join t.professionalset ds " +
            "where t.startTime = :date ")
    List<Client> getClientByDateForProfessionals(@Param("date") LocalDateTime date);

}
