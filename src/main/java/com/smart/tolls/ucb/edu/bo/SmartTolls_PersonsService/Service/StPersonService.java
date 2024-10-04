package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository.StPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StPersonService {

    @Autowired
    private StPersonRepository stPersonRepository;

    public List<StPersonEntity> getAllPersons() {
        return stPersonRepository.findAll();
    }

    public StPersonEntity getPersonById(Long id) {
        return stPersonRepository.findById(id).get();
    }

    public StPersonEntity createPerson(StPersonEntity stPersonEntity) {
        return stPersonRepository.save(stPersonEntity);
    }

    public StPersonEntity updatePerson(Long id, StPersonEntity stPersonEntity) {
        StPersonEntity person = stPersonRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
        person.setPersonName(stPersonEntity.getPersonName());
        return stPersonRepository.save(person);
    }

    public void deletePerson(Long id) {
        stPersonRepository.deleteById(id);
    }

//    public List<StPersonEntity> findByCountryId(Long countryId) {
//        return stPersonRepository.findByCountryId(countryId);
//    }

}
