package com.appconsultorio.appconsultorio.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDTO {
    private String name;
    private String surname;
    private String adress;
    private Integer phone;
}
