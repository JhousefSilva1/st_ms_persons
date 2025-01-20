package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Controller;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonTypeEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StPersonTypeService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personsType")
public class StPersonTypeController extends ApiController{

    @Autowired
    private StPersonTypeService stPersonTypeService;

    @GetMapping("/all")
    public ApiResponse<List<StPersonTypeEntity>> getAllPersonsType(){
        ApiResponse<List<StPersonTypeEntity>> response = new ApiResponse<>();
        List<StPersonTypeEntity> personType = stPersonTypeService.getAllPersonsType();
        response.setData(personType);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        return logApiResponse(response);
    }

    @GetMapping
    public ApiResponse<List<StPersonTypeEntity>> getAllPersonsTypeByStatus(){
        ApiResponse<List<StPersonTypeEntity>> response = new ApiResponse<>();
        List<StPersonTypeEntity> personType = stPersonTypeService.getAllPersonsTypeByStatus();
        response.setData(personType);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        return logApiResponse(response);
    }

    @GetMapping("/{id}")
    public ApiResponse<StPersonTypeEntity> getPersonTypeById(@PathVariable Long id){
        ApiResponse<StPersonTypeEntity> response = new ApiResponse<>();
        try {
            Optional<StPersonTypeEntity> personType = stPersonTypeService.getPersonTypeById(id);
            if (personType.isPresent()) {
                response.setData(personType.get());
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
    public ApiResponse<Optional<StPersonTypeEntity>> createPersonType(@RequestBody StPersonTypeEntity stPersonTypeEntity){
        ApiResponse<Optional<StPersonTypeEntity>> response = new ApiResponse<>();
        try {
            Optional<StPersonTypeEntity> personType = stPersonTypeService.createPersonType(stPersonTypeEntity);
            response.setData(personType);
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
    public ApiResponse<Optional<StPersonTypeEntity>> updatePersonType(@PathVariable Long id, @RequestBody StPersonTypeEntity stPersonTypeEntity){
        ApiResponse<Optional<StPersonTypeEntity>> response = new ApiResponse<>();
        try {
            Optional<StPersonTypeEntity> personType = stPersonTypeService.updatePersonType(id, stPersonTypeEntity);
            response.setData(personType);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return logApiResponse(response);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Optional<StPersonTypeEntity>> deletePersonType(@PathVariable Long id){
        ApiResponse<Optional<StPersonTypeEntity>> response = new ApiResponse<>();
        try {
            Optional<StPersonTypeEntity> personType = stPersonTypeService.deletePersonType(id);
            response.setData(personType);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return logApiResponse(response);
    }
}
