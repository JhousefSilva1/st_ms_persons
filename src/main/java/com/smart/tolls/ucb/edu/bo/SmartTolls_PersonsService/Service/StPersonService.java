package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service;



import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StGenderEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonTypeEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Request.StPersonRequest;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Response.StPersonResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository.StGenderRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository.StPersonRepository;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository.StPersonTypeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class StPersonService {

    @Autowired
    private StPersonRepository stPersonRepository;

    @Autowired
    private StGenderRepository stGenderRepository;

    @Autowired
    private StPersonTypeRepository stPersonTypeRepository;


    //Get All Persons
    public List<StPersonResponse> getAllPersonsByStatus(){
        List<StPersonEntity> persons = stPersonRepository.findAllByStatus();
        return persons.stream().map(personEntity -> new StPersonResponse(
                personEntity.getIdPerson(),
                personEntity.getPersonSurname(),
                personEntity.getPersonDni(),
                personEntity.getPersonAddress(),
                personEntity.getPersonBirthdate(),
                personEntity.getPersonAge(),
                personEntity.getPersonEmail(),
                personEntity.getPersonPassword(),
                new StPersonResponse.GenderDTO(
                        personEntity.getGender().getIdGender(),
                        personEntity.getGender().getGenderName()),
                new StPersonResponse.PersonTypeDTO(
                        personEntity.getPersonType().getIdPersonType(),
                        personEntity.getPersonType().getPersonType())
        )).collect(Collectors.toList());
    }

    //Get Persons by Id
    public StPersonResponse getPersonById(Long id){
        StPersonEntity personEntity = stPersonRepository.findByIdAndStatus(id,1)
                .orElseThrow(() -> new RuntimeException("Person was not found"));

        return new StPersonResponse(
                personEntity.getIdPerson(),
                personEntity.getPersonSurname(),
                personEntity.getPersonDni(),
                personEntity.getPersonAddress(),
                personEntity.getPersonBirthdate(),
                personEntity.getPersonAge(),
                personEntity.getPersonEmail(),
                personEntity.getPersonPassword(),
                new StPersonResponse.GenderDTO(
                        personEntity.getGender().getIdGender(),
                        personEntity.getGender().getGenderName()),
                new StPersonResponse.PersonTypeDTO(
                        personEntity.getPersonType().getIdPersonType(),
                        personEntity.getPersonType().getPersonType())
        );
    }

    public StPersonEntity createPerson(StPersonRequest personRequest){
        //validate gender
        StGenderEntity gender = stGenderRepository.findById(personRequest.getIdGender())
                .orElseThrow(() -> new RuntimeException("Gender was not found"));

        StPersonTypeEntity personType = stPersonTypeRepository.findById(personRequest.getIdPersonType())
                .orElseThrow(() -> new RuntimeException("Person Type was not found"));

        //Create Person
        StPersonEntity personEntity = new StPersonEntity();
        personEntity.setPersonName(personRequest.getPersonName());
        personEntity.setPersonSurname(personRequest.getPersonSurname());
        personEntity.setPersonDni(personRequest.getPersonDni());
        personEntity.setPersonAddress(personRequest.getPersonAddress());
        personEntity.setPersonAge(personRequest.getPersonAge());
        personEntity.setPersonWhatsappNumber(personRequest.getPersonWhatsappNumber());
        personEntity.setPersonBirthdate(personRequest.getPersonBirthdate());
        personEntity.setPersonEmail(personRequest.getPersonEmail());
        personEntity.setPersonPassword(personRequest.getPersonPassword());
        personEntity.setGender(gender);
        personEntity.setPersonType(personType);

        return stPersonRepository.save(personEntity);
    }




    public boolean isServiceAvailable(){
        try {
            stPersonRepository.count();
            return true;
        } catch (Exception e) {
            LoggerFactory.getLogger(StPersonService.class).error("Database is not available", e);
            return false;
        }
    }




}