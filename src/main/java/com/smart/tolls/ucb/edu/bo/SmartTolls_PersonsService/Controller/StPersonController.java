package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Controller;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class StPersonController {

    @Autowired
    private StPersonService stPersonService;

    @GetMapping
    public List<StPersonEntity> getAllPersons(){
        return stPersonService.getAllPersons();
    }

    @GetMapping("/{id}")
    public StPersonEntity getPersonById(@PathVariable Long id){
        return stPersonService.getPersonById(id);
    }

    @PostMapping
    public StPersonEntity createPerson(@RequestBody StPersonEntity stPersonEntity){
        return stPersonService.createPerson(stPersonEntity);
    }

    @PutMapping("/{id}")
    public StPersonEntity updatePerson(@PathVariable Long id, @RequestBody StPersonEntity stPersonEntity){
        return stPersonService.updatePerson(id, stPersonEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <String> deletePerson(@PathVariable Long id){
        stPersonService.deletePerson(id);
        return ResponseEntity.ok("Persona eliminada correctamente");
    }

//    @GetMapping("/country/{countryId}")
//    public List<StPersonEntity> findByCountryId(@PathVariable Long countryId){
//        return stPersonService.findByCountryId(countryId);
//    }

//    @GetMapping("/country/{countryId}")
//    public ResponseEntity<?> findByCountryId(@PathVariable Long countryId){
//        List<StPersonEntity> persons = stPersonService.findByCountryId(countryId);
//        if(persons.isEmpty()){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(persons);
//    }

//    @GetMapping("/country/{countryId}")
//    public ResponseEntity<?> findByCountryId(@PathVariable Long countryId){
//       return ResponseEntity.ok(stPersonService.findByCountryId(countryId));
//    }

//    Microservice Country_City


}
