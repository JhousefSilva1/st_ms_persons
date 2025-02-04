package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service;


import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository.StPersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StPersonService {

    @Autowired
    private StPersonRepository stPersonRepository;

//    @Autowired
//    private final RestTemplate restTemplate;

    public List<StPersonEntity> getAllPersons() {
        return stPersonRepository.findAll();
    }

    public List<StPersonEntity> getAllPersonsByStatus() {
        return stPersonRepository.findAllByStatus();
    }

    public Optional<StPersonEntity> getPersonById(Long id) {
        return Optional.of(stPersonRepository.findByIdAndByStatus(id, 1L));
    }

    public Optional<StPersonEntity> createPerson(StPersonEntity stPersonEntity) {
        return Optional.of(stPersonRepository.save(stPersonEntity));
    }
    public Optional<StPersonEntity> updatePerson(Long id, StPersonEntity stPersonEntity) {
        StPersonEntity person = stPersonRepository.findByIdAndByStatus(id, 1L);
        person.setPersonName(stPersonEntity.getPersonName());
        person.setPersonSurname(stPersonEntity.getPersonSurname());
        person.setPersonAddress(stPersonEntity.getPersonAddress());
        person.setPersonEmail(stPersonEntity.getPersonEmail());
        person.setPersonAddress(stPersonEntity.getPersonAddress());
        person.setPersonAge(stPersonEntity.getPersonAge());
        person.setPersonBirthdate(stPersonEntity.getPersonBirthdate());
        person.setPersonDni(stPersonEntity.getPersonDni());
        person.setPersonPassword(stPersonEntity.getPersonPassword());
        person.setPersonWhatsappNumber(stPersonEntity.getPersonWhatsappNumber());
        return Optional.of(stPersonRepository.save(person));
    }

    public Optional<StPersonEntity> deletePerson(Long id) {
        StPersonEntity person = stPersonRepository.findByIdAndByStatus(id, 1L);
        person.setStatus(0);
        return Optional.of(stPersonRepository.save(person));
    }



}
