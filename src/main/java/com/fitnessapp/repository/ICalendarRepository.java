package com.fitnessapp.repository;
import com.fitnessapp.model.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICalendarRepository extends JpaRepository<Calendar,Integer> {

    @Query("select c from Calendar c " +
            "where c.professional.id = :professional_id ")
    Calendar getCalendarFromProfessional(Integer professional_id);

}
