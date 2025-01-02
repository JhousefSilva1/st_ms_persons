package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonTypeEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository.StPersonTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@AllArgsConstructor
@Service
public class StPersonTypeService {

    @Autowired
    private StPersonTypeRepository stPersonTypeRepository;

    private final RestTemplate restTemplate;

    public List<StPersonTypeEntity> getAllPersonsType() {
        return stPersonTypeRepository.findAll();
    }

    public StPersonTypeEntity getPersonTypeById(Long id) {
        return stPersonTypeRepository.findById(id).get();
    }

    public StPersonTypeEntity createPersonType(StPersonTypeEntity stPersonTypeEntity) {
        return stPersonTypeRepository.save(stPersonTypeEntity);
    }

    public StPersonTypeEntity updatePersonType(Long id, StPersonTypeEntity stPersonTypeEntity) {
        StPersonTypeEntity personType = stPersonTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Person Type not found"));
        personType.setIdPersonType(stPersonTypeEntity.getIdPersonType());
        return stPersonTypeRepository.save(personType);
    }

    public void deletePersonType(Long id) {
        stPersonTypeRepository.deleteById(id);
    }
}
