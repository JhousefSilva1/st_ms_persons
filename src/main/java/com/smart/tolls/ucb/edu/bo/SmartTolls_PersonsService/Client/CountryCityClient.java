package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Client;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Dto.City;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Dto.Country;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "country-city-microservice", url = "http://localhost:8002/api")
public interface CountryCityClient {

    @GetMapping("/country/{id}")
    Country getCountryById(@PathVariable("id") Long id);

    @GetMapping("/city/{id}")
    City getCityById(@PathVariable("id") Long id);
}
