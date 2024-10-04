package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StGenderEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository.StGenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StGenderService {

    @Autowired
    private StGenderRepository stGenderRepository;

    public List<StGenderEntity> getAllGenders() {
        return stGenderRepository.findAll();
    }

    public StGenderEntity getGenderById(Long id) {
        return stGenderRepository.findById(id).get();
    }

    public StGenderEntity createGender(StGenderEntity stGenderEntity) {
        return stGenderRepository.save(stGenderEntity);
    }

    public StGenderEntity updateGender(Long id, StGenderEntity stGenderEntity) {
        StGenderEntity gender = stGenderRepository.findById(id).orElseThrow(() -> new RuntimeException("Gender not found"));
        gender.setGenderName(stGenderEntity.getGenderName());
        return stGenderRepository.save(gender);
    }

    public void deleteGender(Long id) {
        stGenderRepository.deleteById(id);
    }

}
