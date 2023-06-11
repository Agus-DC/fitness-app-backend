package com.fitnessapp.repository;
import com.fitnessapp.model.Calendars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICalendarRepository extends JpaRepository<Calendars,Integer> {

    @Query("select c from Calendars c " +
            "where c.professional.id = :professional_id ")
    Calendars getCalendarFromProfessional(Integer professional_id);

}
