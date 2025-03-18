package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenderDTO {

    private Long idGender;
    private String genderName;
}