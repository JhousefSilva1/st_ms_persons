package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonTypeEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository.StPersonTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StPersonTypeService {

    @Autowired
    private StPersonTypeRepository stPersonTypeRepository;

    public List<StPersonTypeEntity> getAllPersonsType() {
        return stPersonTypeRepository.findAll();
    }

    public List<StPersonTypeEntity> getAllPersonsTypeByStatus() {
        return stPersonTypeRepository.findAllByStatus();
    }

    public Optional<StPersonTypeEntity> getPersonTypeById(Long id) {
        return Optional.of(stPersonTypeRepository.findByIdAndByStatus(id, 1L));
    }

    public Optional<StPersonTypeEntity> createPersonType(StPersonTypeEntity stPersonTypeEntity) {
        return Optional.of(stPersonTypeRepository.save(stPersonTypeEntity));
    }

    public Optional<StPersonTypeEntity> updatePersonType(Long id, StPersonTypeEntity stPersonTypeEntity) {
        StPersonTypeEntity personType = stPersonTypeRepository.findByIdAndByStatus(id, 1L);
        personType.setPersonType(stPersonTypeEntity.getPersonType());
        return Optional.of(stPersonTypeRepository.save(personType));
    }

    public Optional<StPersonTypeEntity> deletePersonType(Long id) {
        StPersonTypeEntity personType = stPersonTypeRepository.findByIdAndByStatus(id, 1L);
        personType.setStatus(0);
        return Optional.of(stPersonTypeRepository.save(personType));
    }
}
