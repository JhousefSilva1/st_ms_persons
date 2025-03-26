package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service;



import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository.StPersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class StPersonService {

    @Autowired
    private StPersonRepository stPersonRepository;


    public List<StPersonEntity> getAllPersons(){
        return stPersonRepository.findAll();
    }

    public List<StPersonEntity> getAllPersonsByStatus(){
        return stPersonRepository.findAllByStatus();
    }

    public Optional<StPersonEntity> getPersonById(Long id){
        return Optional.of(stPersonRepository.findByIdAndByStatus(id, 1));
    }

    public Optional<StPersonEntity> createPerson(StPersonEntity stPersonEntity){
        return Optional.of(stPersonRepository.save(stPersonEntity));
    }

//    public Optional<StPersonEntity> updatePerson(Long id, StPersonEntity stPersonEntity){
//        StPersonEntity person = stPersonRepository.findByIdAndStatus(id, 1);
//
//        person.setPersonName(stPersonEntity.getPersonName());
//        person.setPersonSurname(stPersonEntity.getPersonSurname());
//        person.setPersonEmail(stPersonEntity.getPersonEmail());
//        person.setPersonWhatsappNumber(stPersonEntity.getPersonWhatsappNumber());
//        person.setPersonAddress(stPersonEntity.getPersonAddress());
//        person.setPersonStatus(stPersonEntity.getPersonStatus());
//        person.setGender(stPersonEntity.getGender());
//        person.setPersonType(stPersonEntity.getPersonType());
//        return Optional.of(stPersonRepository.save(person));
//    }
//
//    public Optional<StPersonEntity> deletePerson(Long id){
//        StPersonEntity person = stPersonRepository.findByIdAndStatus(id, 1);
//        person.setPersonStatus(0);
//        return Optional.of(stPersonRepository.save(person));
//    }




}