package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Controller;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StPersonService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class StPersonController extends ApiController {

    @Autowired
    private StPersonService stPersonService;

    @GetMapping("/all")
    public ApiResponse<List<StPersonEntity>> getAllPersons(){
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
        List<StPersonEntity> persons = stPersonService.getAllPersons();
        response.setData(persons);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        return logApiResponse(response);
    }

    @GetMapping("/{id}")
    public ApiResponse<StPersonEntity> getPersonById(@PathVariable Long id){
        ApiResponse<StPersonEntity> response = new ApiResponse<>();
        try {
            Optional<StPersonEntity> person = stPersonService.getPersonById(id);
            if (person.isPresent()) {
                response.setData(person.get());
                response.setStatus(HttpStatus.OK.value());
                response.setMessage(HttpStatus.OK.getReasonPhrase());
            } else {
                response.setStatus(HttpStatus.NOT_FOUND.value());
                response.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
        } catch (NullPointerException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return logApiResponse(response);
    }

    @PostMapping
    public ApiResponse<Optional<StPersonEntity>> createPerson(@RequestBody StPersonEntity stPersonEntity){
        ApiResponse<Optional<StPersonEntity>> response = new ApiResponse<>();
        try {
            Optional<StPersonEntity> person = stPersonService.createPerson(stPersonEntity);
            response.setData(person);
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
    public ApiResponse<Optional<StPersonEntity>> updatePerson(@PathVariable Long id, @RequestBody StPersonEntity stPersonEntity){
        ApiResponse<Optional<StPersonEntity>> response = new ApiResponse<>();
        try {
            Optional<StPersonEntity> person = stPersonService.updatePerson(id, stPersonEntity);
            response.setData(person);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return logApiResponse(response);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Optional<StPersonEntity>> deletePerson(@PathVariable Long id){
        ApiResponse<Optional<StPersonEntity>> response = new ApiResponse<>();
        try {
            Optional<StPersonEntity> person = stPersonService.deletePerson(id);
            response.setData(person);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return logApiResponse(response);
    }


}
