package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "country-city-microservice", url = "http://localhost:8002/api")
public interface CountryCityClient {

//    @GetMapping("/country/{id}")
//    CountryDTO getCountryById(@PathVariable("id") Long id);
//
//    @GetMapping("/city/{id}")
//    CityDTO getCityById(@PathVariable("id") Long id);
}
