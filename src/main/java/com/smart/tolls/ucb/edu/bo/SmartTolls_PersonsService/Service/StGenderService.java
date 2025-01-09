package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StGenderEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository.StGenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StGenderService {

    @Autowired
    private StGenderRepository stGenderRepository;

    public List<StGenderEntity> getAllGenders() {
        return stGenderRepository.findAll();
    }

    public List<StGenderEntity> getAllGendersByStatus() {
        return stGenderRepository.findAllByStatus();
    }

    public Optional<StGenderEntity> getGenderById(Long id) {
        return Optional.of(stGenderRepository.findByIdAndByStatus(id, 1L));
    }

    public Optional<StGenderEntity> createGender(StGenderEntity stGenderEntity) {
        return Optional.of(stGenderRepository.save(stGenderEntity));
    }

    public Optional<StGenderEntity> updateGender(Long id, StGenderEntity stGenderEntity) {
        StGenderEntity gender = stGenderRepository.findByIdAndByStatus(id, 1L);
        gender.setGenderName(stGenderEntity.getGenderName());
        return Optional.of(stGenderRepository.save(gender));
    }

    public Optional<StGenderEntity> deleteGender(Long id) {
        StGenderEntity gender = stGenderRepository.findByIdAndByStatus(id, 1L);
        gender.setStatus(0);
        return Optional.of(stGenderRepository.save(gender));
    }

}
