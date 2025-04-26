package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository.StPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class StPersonService {
    @Autowired
    private StPersonRepository stPersonRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
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
        String encryptedPassword = passwordEncoder.encode(stPersonEntity.getPersonPassword());
        stPersonEntity.setPersonPassword(encryptedPassword);
        return Optional.of(stPersonRepository.save(stPersonEntity));
    }
    public Optional<StPersonEntity> updatePerson(Long id, StPersonEntity updatedPerson) {
        Optional<StPersonEntity> existingPerson = stPersonRepository.findById(id);
        if (existingPerson.isEmpty()) {
            return Optional.empty();
        }
        StPersonEntity person = existingPerson.get();
        person.setPersonName(updatedPerson.getPersonName());
        person.setPersonSurname(updatedPerson.getPersonSurname());
        person.setPersonWhatsappNumber(updatedPerson.getPersonWhatsappNumber());
        person.setPersonDni(updatedPerson.getPersonDni());
        person.setPersonBirthdate(updatedPerson.getPersonBirthdate());
        person.setPersonEmail(updatedPerson.getPersonEmail());
        person.setPersonAddress(updatedPerson.getPersonAddress());
        person.setPersonAge(updatedPerson.getPersonAge());
        person.setPersonStatus(updatedPerson.getPersonStatus());
        person.setGender(updatedPerson.getGender());
        person.setPersonType(updatedPerson.getPersonType());
        person.setIdCountry(updatedPerson.getIdCountry());
        person.setIdCity(updatedPerson.getIdCity());

        return Optional.of(stPersonRepository.save(person));
    }
    public Optional<StPersonEntity> deletePerson(Long id) {
        Optional<StPersonEntity> existingPerson = stPersonRepository.findById(id);
        if (existingPerson.isEmpty()) {
            return Optional.empty();
        }
        StPersonEntity person = existingPerson.get();
        person.setPersonStatus(0);
        return Optional.of(stPersonRepository.save(person));
    }
    public boolean existsByEmail(String email) {
        return stPersonRepository.findByPersonEmail(email).isPresent();
    }

    public Optional<StPersonEntity> findByEmail(String email) {
        return stPersonRepository.findByPersonEmail(email);
    }
}