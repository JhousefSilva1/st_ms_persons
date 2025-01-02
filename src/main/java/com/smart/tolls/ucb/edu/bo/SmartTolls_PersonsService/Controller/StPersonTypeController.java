package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Controller;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonTypeEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StPersonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personsType")
public class StPersonTypeController {

    @Autowired
    private StPersonTypeService stPersonTypeService;

    @GetMapping
    public List<StPersonTypeEntity> getAllPersonsType(){
        return stPersonTypeService.getAllPersonsType();
    }

    @GetMapping("/{id}")
    public StPersonTypeEntity getPersonTypeById(Long id){
        return stPersonTypeService.getPersonTypeById(id);
    }

    @PostMapping
    public StPersonTypeEntity createPersonType(StPersonTypeEntity stPersonTypeEntity){
        return stPersonTypeService.createPersonType(stPersonTypeEntity);
    }

    @PutMapping("/{id}")
    public StPersonTypeEntity updatePersonType(Long id, StPersonTypeEntity stPersonTypeEntity){
        return stPersonTypeService.updatePersonType(id, stPersonTypeEntity);
    }

    @DeleteMapping("/{id}")
    public void deletePersonType(Long id){
        stPersonTypeService.deletePersonType(id);
    }
}
