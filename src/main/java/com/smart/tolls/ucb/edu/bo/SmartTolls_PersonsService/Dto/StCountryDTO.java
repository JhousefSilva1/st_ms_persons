package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StCountryDTO {

    private Long idCountry;
    private String countryName;
    private String cities;

}
