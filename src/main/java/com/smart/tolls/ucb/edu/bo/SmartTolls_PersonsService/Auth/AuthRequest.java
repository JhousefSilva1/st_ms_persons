package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Auth;

public record AuthRequest(

        String personEmail,
        String personPassword
) {
}
