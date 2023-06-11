package com.fitnessapp.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.*;

@Entity
@Getter @Setter
@Table(name = "Professionals")
public class Professional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professional")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(mappedBy = "professionalset", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Turn> turnSet;

    //orphanRemoval= true especifica que la entidad hijo debe ser eliminada automáticamente por el propio ORM si ha
    //dejado de ser referenciada por una entidad padre
    @OneToOne(mappedBy = "professional", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Calendars calendars;

}
