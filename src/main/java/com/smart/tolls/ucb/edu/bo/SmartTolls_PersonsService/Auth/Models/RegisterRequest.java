package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Auth.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
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