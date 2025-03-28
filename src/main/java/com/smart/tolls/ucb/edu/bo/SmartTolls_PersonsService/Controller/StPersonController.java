package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Controller;


import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Client.CountryCityClient;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Dto.CityDto;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Dto.CountryDto;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StGenderEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonTypeEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Request.StPersonRequest;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Response.StPersonResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StGenderService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StPersonService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StPersonTypeService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/persons")
public class StPersonController extends ApiController {

    @Autowired
    public StGenderService stGenderService;

    @Autowired
    public StPersonTypeService stPersonTypeService;

    @Autowired
    public StPersonService stPersonService;

    @Autowired
    public CountryCityClient countryCityClient;

    @GetMapping("/all")
    public ApiResponse<List<StPersonEntity>> getAllPerons(){
        ApiResponse<List<StPersonEntity>> response = new ApiResponse<>();
        List<StPersonEntity> persons = stPersonService.getAllPersons();
        response.setData(persons);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        return logApiResponse(response);
    }

    @GetMapping
    public ApiResponse<List<StPersonEntity>> getAllPersonsByStatus(){
        ApiResponse<List<StPersonEntity>> response = new ApiResponse<>();
        List<StPersonEntity> persons = stPersonService.getAllPersonsByStatus();
        response.setData(persons);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        return logApiResponse(response);
    }

    @GetMapping("/{id}")
    public ApiResponse<StPersonResponse> getPersonById(@PathVariable Long id){
        ApiResponse<StPersonResponse> response = new ApiResponse<>();
        try {
            Optional<StPersonEntity> optionalPerson = stPersonService.getPersonById(id);
            if(optionalPerson.isEmpty()){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
                response.setMessage("Person not found");
                return logApiResponse(response);
            }

            StPersonEntity person = optionalPerson.get();
            ApiResponse<CityDto> cityResponse = countryCityClient.getCityById(person.getIdCity());
            if(cityResponse.getStatus() != HttpStatus.OK.value()){
                response.setStatus(cityResponse.getStatus());
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage(cityResponse.getMessage());
                response.setMessage("City not found");
                return logApiResponse(response);
            }

            ApiResponse<CountryDto> countryResponse = countryCityClient.getCountryById(person.getIdCountry());
            if(countryResponse.getStatus() != HttpStatus.OK.value()){
                response.setStatus(countryResponse.getStatus());
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage(countryResponse.getMessage());
                response.setMessage("Country not found");
                return logApiResponse(response);
            }

            StPersonResponse personResponse = new StPersonResponse();
            personResponse.setIdPerson(person.getIdPerson());
            personResponse.setPersonName(person.getPersonName());
            personResponse.setPersonSurname(person.getPersonSurname());
            personResponse.setPersonWhatsappNumber(person.getPersonWhatsappNumber());
            personResponse.setPersonPassword(person.getPersonPassword());
            personResponse.setPersonDni(person.getPersonDni());
            personResponse.setPersonBirthdate(person.getPersonBirthdate());
            personResponse.setPersonEmail(person.getPersonEmail());
            personResponse.setPersonAddress(person.getPersonAddress());
            personResponse.setPersonAge(person.getPersonAge());
            personResponse.setPersonStatus(person.getPersonStatus());
            personResponse.setGender(person.getGender());
            personResponse.setPersonType(person.getPersonType());
            personResponse.setCountry(countryResponse.getData());
            personResponse.setCity(cityResponse.getData());

            response.setData(personResponse);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());

        }catch (Exception e){
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return logApiResponse(response);
    }

    @PostMapping
    public ApiResponse<Optional<StPersonEntity>> createPerson(@RequestBody StPersonRequest stPersonRequest) {
        ApiResponse<Optional<StPersonEntity>> response = new ApiResponse<>();
        try {

            Optional<StGenderEntity> gender = stGenderService.getGenderById(stPersonRequest.getIdGender());
            if (gender.isEmpty()) {
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
                response.setMessage("Gender was not found");
                return logApiResponse(response);
            }
            Optional<StPersonTypeEntity> personType = stPersonTypeService.getPersonTypeById(stPersonRequest.getIdPersonType());
            if (personType.isEmpty()) {
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
                response.setMessage("Person Type was not found");
                return logApiResponse(response);
            }

            ApiResponse<CountryDto> country = countryCityClient.getCountryById(stPersonRequest.getIdCountry());
            if (country.getStatus() != HttpStatus.OK.value()) {
                response.setStatus(country.getStatus());
                response.setMessage(country.getMessage());
                response.setMessage("Country was not found");
                return logApiResponse(response);
            }

            ApiResponse<CityDto> city = countryCityClient.getCityById(stPersonRequest.getIdCity());
            if (city.getStatus() != HttpStatus.OK.value()) {
                response.setStatus(city.getStatus());
                response.setMessage(city.getMessage());
                response.setMessage("City was not found");
                return logApiResponse(response);
            }

            StPersonEntity person = new StPersonEntity();
            person.setPersonName(stPersonRequest.getPersonName());
            person.setPersonSurname(stPersonRequest.getPersonSurname());
            person.setPersonWhatsappNumber(stPersonRequest.getPersonWhatsappNumber());
            person.setPersonPassword(stPersonRequest.getPersonPassword());
            person.setPersonDni(stPersonRequest.getPersonDni());
            person.setPersonBirthdate(stPersonRequest.getPersonBirthdate());
            person.setPersonEmail(stPersonRequest.getPersonEmail());
            person.setPersonAddress(stPersonRequest.getPersonAddress());
            person.setPersonAge(stPersonRequest.getPersonAge());
            person.setPersonStatus(stPersonRequest.getPersonStatus());
            person.setGender(gender.get());
            person.setPersonType(personType.get());
            person.setIdCountry(stPersonRequest.getIdCountry());
            person.setIdCity(stPersonRequest.getIdCity());

            Optional<StPersonEntity> persons = stPersonService.createPerson(person);
            response.setData(persons);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (ConstraintViolationException e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return logApiResponse(response);
    }

    @PutMapping("/{id}")
    public ApiResponse<Optional<StPersonEntity>> updatePerson(@PathVariable Long id, @RequestBody StPersonRequest stPersonRequest) {
        ApiResponse<Optional<StPersonEntity>> response = new ApiResponse<>();
        try {
            Optional<StPersonEntity> existingPerson = stPersonService.getPersonById(id);
            if (existingPerson.isEmpty()) {
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Person not found");
                return logApiResponse(response);
            }

            // Validar si el género y el tipo de persona existen
            Optional<StGenderEntity> gender = stGenderService.getGenderById(stPersonRequest.getIdGender());
            if (gender.isEmpty()) {
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Gender not found");
                return logApiResponse(response);
            }

            Optional<StPersonTypeEntity> personType = stPersonTypeService.getPersonTypeById(stPersonRequest.getIdPersonType());
            if (personType.isEmpty()) {
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Person Type not found");
                return logApiResponse(response);
            }

            // Validar ciudad y país llamando al microservicio
            ApiResponse<CountryDto> country = countryCityClient.getCountryById(stPersonRequest.getIdCountry());
            if (country.getStatus() != HttpStatus.OK.value()) {
                response.setStatus(country.getStatus());
                response.setMessage("Country not found");
                return logApiResponse(response);
            }

            ApiResponse<CityDto> city = countryCityClient.getCityById(stPersonRequest.getIdCity());
            if (city.getStatus() != HttpStatus.OK.value()) {
                response.setStatus(city.getStatus());
                response.setMessage("City not found");
                return logApiResponse(response);
            }

            StPersonEntity updatedPerson = new StPersonEntity();
            updatedPerson.setPersonName(stPersonRequest.getPersonName());
            updatedPerson.setPersonSurname(stPersonRequest.getPersonSurname());
            updatedPerson.setPersonWhatsappNumber(stPersonRequest.getPersonWhatsappNumber());
            updatedPerson.setPersonDni(stPersonRequest.getPersonDni());
            updatedPerson.setPersonBirthdate(stPersonRequest.getPersonBirthdate());
            updatedPerson.setPersonEmail(stPersonRequest.getPersonEmail());
            updatedPerson.setPersonAddress(stPersonRequest.getPersonAddress());
            updatedPerson.setPersonAge(stPersonRequest.getPersonAge());
            updatedPerson.setPersonStatus(stPersonRequest.getPersonStatus());
            updatedPerson.setGender(gender.get());
            updatedPerson.setPersonType(personType.get());
            updatedPerson.setIdCountry(stPersonRequest.getIdCountry());
            updatedPerson.setIdCity(stPersonRequest.getIdCity());

            Optional<StPersonEntity> updatedEntity = stPersonService.updatePerson(id, updatedPerson);
            response.setData(updatedEntity);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage("Error updating person");
        }
        return logApiResponse(response);
    }






}