package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Controller;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StGenderEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StGenderService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gender")
public class StGenderController extends ApiController {

    @Autowired
    private StGenderService stGenderService;

    @GetMapping("/all")
    public ApiResponse<List<StGenderEntity>> getAllGenders(){
        ApiResponse<List<StGenderEntity>> response = new ApiResponse<>();
        List<StGenderEntity> genders = stGenderService.getAllGenders();
        response.setData(genders);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        return logApiResponse(response);
    }

    @GetMapping
    public ApiResponse<List<StGenderEntity>> getAllGendersByStatus(){
        ApiResponse<List<StGenderEntity>> response = new ApiResponse<>();
        List<StGenderEntity> genders = stGenderService.getAllGendersByStatus();
        response.setData(genders);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        return logApiResponse(response);
    }

    @GetMapping("/{id}")
    public ApiResponse<StGenderEntity> getGenderById(@PathVariable Long id){
        ApiResponse<StGenderEntity> response = new ApiResponse<>();
        try {
            Optional<StGenderEntity> brand = stGenderService.getGenderById(id);
            if (brand.isPresent()) {
                response.setData(brand.get());
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
    public ApiResponse<Optional<StGenderEntity>> createGender(@RequestBody StGenderEntity stGenderEntity){
        ApiResponse<Optional<StGenderEntity>> response = new ApiResponse<>();
        try {
            Optional<StGenderEntity> brand = stGenderService.createGender(stGenderEntity);
            response.setData(brand);
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
    public ApiResponse<Optional<StGenderEntity>> updateGender(@PathVariable Long id, @RequestBody StGenderEntity stGenderEntity){
        ApiResponse<Optional<StGenderEntity>> response = new ApiResponse<>();
        try {
            Optional<StGenderEntity> brand = stGenderService.updateGender(id, stGenderEntity);
            response.setData(brand);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return logApiResponse(response);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Optional<StGenderEntity>> deleteGender(@PathVariable Long id){
        ApiResponse<Optional<StGenderEntity>> response = new ApiResponse<>();
        try {
            Optional<StGenderEntity> brand = stGenderService.deleteGender(id);
            response.setData(brand);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return logApiResponse(response);
    }

}
