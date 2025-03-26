package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StPersonRequest {

    private Long idPerson;
    private String personName;
    private String personSurname;
    private String personWhatsappNumber;
    private String personPassword;
    private String personDni;
    private LocalDate personBirthdate;
    private String personEmail;
    private String personAddress;
    private String personAge;
    private Integer personStatus;
    private Long idGender;
    private Long idPersonType;
    private Long idCity;
    private Long idCountry;
}
