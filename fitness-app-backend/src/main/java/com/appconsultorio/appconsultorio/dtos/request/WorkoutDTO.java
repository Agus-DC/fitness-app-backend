package com.appconsultorio.appconsultorio.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
public class WorkoutDTO {
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
  private Date date;

  @JsonProperty("muscular_group")
  private String muscularGroup;

  @JsonProperty("name")
  private String name;

  @JsonProperty
  private Integer reps;

  @JsonProperty
  private Integer sets;

  @JsonProperty
  private float pause;

  @JsonProperty
  private String weight;

  @JsonProperty
  private String others;
}
