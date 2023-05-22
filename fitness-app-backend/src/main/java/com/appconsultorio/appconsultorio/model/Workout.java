package com.appconsultorio.appconsultorio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Workout")
public class Workout {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "date")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
  private Date date;

  @Column(name = "muscular_group")
  private String muscularGroup;

  @Column(name = "reps")
  private Integer reps;

  @Column(name = "sets")
  private Integer sets;

  @Column(name = "pause")
  private BigDecimal pause;

  @Column(name = "weight")
  private Integer weight;

  @Column(name = "others")
  private String others;

  @JoinColumn(name = "workout_id")
  @OneToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  private Client client;
}
