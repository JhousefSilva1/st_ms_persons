package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Response;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Dto.CityDto;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Dto.CountryDto;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StGenderEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonTypeEntity;
import lombok.*;

import java.time.LocalDate;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StPersonResponse {
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
    private StGenderEntity gender;
    private StPersonTypeEntity personType;
    private CityDto city;
    private CountryDto country;



}
