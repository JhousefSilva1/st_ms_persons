package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Auth;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StGenderEntity;

import java.util.Date;

public record RegisterRequest(

        String personName,
        String personSurname,
        Date personBirthdate,
        String personWhatsappNumber,
        String personEmail,
        String personPassword,
        String personDni,
        String personAddress,
        String personAge,
        String idCountry,
        String idCity,
        StGenderEntity gender,
        String idPersonType


) {
}
