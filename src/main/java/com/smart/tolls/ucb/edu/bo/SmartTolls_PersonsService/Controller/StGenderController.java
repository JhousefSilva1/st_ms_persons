package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Controller;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StGenderEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gender")
public class StGenderController {

    @Autowired
    private StGenderService stGenderService;

    @GetMapping
    public List<StGenderEntity> getAllGenders(){
        return stGenderService.getAllGenders();
    }

    @GetMapping("/{id}")
    public StGenderEntity getGenderById(@PathVariable Long id){
        return stGenderService.getGenderById(id);
    }

    @PostMapping
    public StGenderEntity createGender(@RequestBody StGenderEntity stGenderEntity){
        return stGenderService.createGender(stGenderEntity);
    }

    @PutMapping("/{id}")
    public StGenderEntity updateGender(@PathVariable Long id, @RequestBody StGenderEntity stGenderEntity){
        return stGenderService.updateGender(id, stGenderEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <String> deleteGender(@PathVariable Long id){
        stGenderService.deleteGender(id);
        return ResponseEntity.ok("Genero eliminado correctamente");
    }

}
