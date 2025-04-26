package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Auth.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    private String personEmail;
    private String personPassword;
}