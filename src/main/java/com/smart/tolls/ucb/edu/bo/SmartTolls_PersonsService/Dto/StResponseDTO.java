package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Dto;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StResponseDTO {

    private StPersonEntity person;

    private StCountryDTO countryDto;

}
