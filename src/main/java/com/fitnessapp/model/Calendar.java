package com.fitnessapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Calendar")
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calendar")
    private int id;

    @Column(name = "day")
    private Date day;

    //jornada de 8hs, 16 turnos de media hora
  /*
    @Column(name = "turn1")
    private boolean turn1;
    @Column(name = "turn2")
    private boolean turn2;
    @Column(name = "turn3")
    private boolean turn3;
    @Column(name = "turn4")
    private boolean turn4;
    @Column(name = "turn5")
    private boolean turn5;
    @Column(name = "turn6")
    private boolean turn6;
    @Column(name = "turn7")
    private boolean turn7;
    @Column(name = "turn8")
    private boolean turn8;
    @Column(name = "turn9")
    private boolean turn9;
    @Column(name = "turn10")
    private boolean turn10;
    @Column(name = "turn11")
    private boolean turn11;
    @Column(name = "turn12")
    private boolean turn12;
    @Column(name = "turn13")
    private boolean turn13;
    @Column(name = "turn14")
    private boolean turn14;
    @Column(name = "turn15")
    private boolean turn15;
    @Column(name = "turn16")
    private boolean turn16;
*/
    //La columna id_professional en la tabla Calendar tiene la FK

    //@JoinColumn(name = "")
    @OneToMany(mappedBy = "calendar")
    private List<Turn> turnList = new ArrayList<>();

    @JoinColumn(name = "id_professional")
    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Professional professional;

    public Calendar(Professional professional) {
        this.professional = professional;
    }
/*
    public boolean createTurn(Integer turnNumber) {
      if (turnNumber == 1) {
        if (this.isTurn1()) return false;
        this.setTurn1(true);
      }
    }

    public Integer getTurnNumber(LocalDateTime date){
       if(date.getHour() == 8 && date.getMinute() > 0 && date.getMinute() < 30) {return 1;}
       if(date.getHour() == 8 && date.getMinute() >= 30) {this.setTurn2(true); return 2;}
       if(date.getHour() == 9 && date.getMinute() > 0 && date.getMinute() < 30) {this.setTurn3(true); return 3;}
       if(date.getHour() == 9 && date.getMinute() >= 30) {this.setTurn4(true); return 4;}
       if(date.getHour() == 10 && date.getMinute() > 0 && date.getMinute() < 30) {this.setTurn5(true); return 5;}
       if(date.getHour() == 10 && date.getMinute() >= 30) {this.setTurn6(true); return 6;}
       if(date.getHour() == 11 && date.getMinute() > 0 && date.getMinute() < 30) {this.setTurn7(true); return 7;}
       if(date.getHour() == 11 && date.getMinute() >= 30) {this.setTurn8(true); return 8;}
       if(date.getHour() == 12 && date.getMinute() > 0 && date.getMinute() < 30) {this.setTurn9(true); return 9;}
       if(date.getHour() == 12 && date.getMinute() >= 30) {this.setTurn10(true); return 10;}
       if(date.getHour() == 13 && date.getMinute() > 0 && date.getMinute() < 30) {this.setTurn11(true); return 11;}
       if(date.getHour() == 13 && date.getMinute() >= 30) {this.setTurn12(true); return 12;}
       if(date.getHour() == 14 && date.getMinute() > 0 && date.getMinute() < 30) {this.setTurn13(true); return 13;}
       if(date.getHour() == 14 && date.getMinute() >= 30) {this.setTurn14(true); return 14;}
       if(date.getHour() == 15 && date.getMinute() > 0 && date.getMinute() < 30) {this.setTurn15(true); return 15;}
       if(date.getHour() == 15 && date.getMinute() >= 30) {this.setTurn16(true); return 16;}
       return null;
    }*/
}
