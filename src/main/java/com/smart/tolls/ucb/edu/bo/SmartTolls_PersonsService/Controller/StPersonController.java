package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Controller;


import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StGenderEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonTypeEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Request.StPersonRequest;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Response.StPersonResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository.StGenderRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository.StPersonRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository.StPersonTypeRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api/persons")
public class StPersonController extends ApiController {

    @Autowired
    private StPersonService stPersonService;
    @Autowired
    private StPersonRepository stPersonRepository;
    @Autowired
    private StGenderRepository stGenderRepository;
    @Autowired
    private StPersonTypeRepository stPersonTypeRepository;

    @GetMapping
    public ApiResponse<List<StPersonResponse>> getAllPersonsByStatus(){
        ApiResponse<List<StPersonResponse>> response = new ApiResponse<>();
        try{
            if(!stPersonService.isServiceAvailable()){
                response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
                response.setMessage("The persons service is currently unavailable");
                return logApiResponse(response);
            }
//            get list of responses with Dto
            List<StPersonResponse> personResponse = stPersonService.getAllPersonsByStatus();
            response.setData(personResponse);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
            return logApiResponse(response);
        }catch (Exception e){
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("An unexpected error occurred: " + e.getMessage());
        }
        return logApiResponse(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<StPersonResponse>> getPersonById(@PathVariable Long id){
        StPersonResponse stPersonResponse = stPersonService.getPersonById(id);
        return ResponseEntity.ok(Collections.singletonList(stPersonResponse));
    }

    @PostMapping
    public ResponseEntity<StPersonEntity> createPerson(@RequestBody StPersonRequest personRequest){
        StPersonEntity personEntity = stPersonService.createPerson(personRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(personEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StPersonEntity> updatePerson(@PathVariable Long id, @RequestBody StPersonRequest personRequest){
        StPersonEntity personEntity = stPersonRepository.findByIdAndStatus(id,1)
                .orElseThrow(() -> new RuntimeException("Person not found"));
//        update person data
        personEntity.setPersonName(personRequest.getPersonName());
        personEntity.setPersonSurname(personRequest.getPersonSurname());
        personEntity.setPersonDni(personRequest.getPersonDni());
        personEntity.setPersonAddress(personRequest.getPersonAddress());
        personEntity.setPersonAge(personRequest.getPersonAge());
        personEntity.setPersonWhatsappNumber(personRequest.getPersonWhatsappNumber());
        personEntity.setPersonBirthdate(personRequest.getPersonBirthdate());
        personEntity.setPersonEmail(personRequest.getPersonEmail());
        personEntity.setPersonPassword(personRequest.getPersonPassword());

//        update gender
        StGenderEntity gender = stGenderRepository.findById(personRequest.getIdGender())
                .orElseThrow(() -> new RuntimeException("Gender was not found"));

//        update personType
        StPersonTypeEntity personType = stPersonTypeRepository.findById(personRequest.getIdPersonType())
                .orElseThrow(() -> new RuntimeException("PersonType was not found"));

        personEntity.setGender(gender);
        personEntity.setPersonType(personType);

//        Save new data

        StPersonEntity updatedPerson = stPersonRepository.save(personEntity);

        return ResponseEntity.status(HttpStatus.OK).body(updatedPerson);
    }

//    Delete Person (logic)

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson (@PathVariable Long id){

//        Search person by id

        StPersonEntity personEntity = stPersonRepository.findByIdAndStatus(id,1)
                .orElseThrow(() -> new RuntimeException("Person not found"));

//        Mark as deleted (status = 0)

        personEntity.setPersonStatus(0);
        stPersonRepository.save(personEntity);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}