package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service;


import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Dto.StCityDTO;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Dto.StCountryDTO;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Dto.StResponseDTO;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository.StPersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@AllArgsConstructor
@Service
public class StPersonService {

    @Autowired
    private StPersonRepository stPersonRepository;

    private final RestTemplate restTemplate;

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

//    public StResponseDTO getPersonWithCountry(Long id) {
//        StResponseDTO responseDTO = new StResponseDTO();
//        StPersonEntity person = new StPersonEntity();
//        person = stPersonRepository.findById(id).get();
//        ResponseEntity<StCountryDTO> responseEntity = restTemplate.getForEntity("http://localhost:8002/api/country/**" + person.getIdCountry(), StCountryDTO.class);
//        ResponseEntity<StCityDTO> responseEntity1 = restTemplate.getForEntity("http://localhost:8002/api/city/**" + person.getIdCity(), StCityDTO.class);
//        StCountryDTO countryDto = responseEntity.getBody();
//        StCityDTO cityDto = responseEntity1.getBody();
//        responseDTO.setPerson(person);
//        responseDTO.setCountryDto(countryDto);
//        responseDTO.setCityDto(cityDto);
//        return responseDTO;
//    }

}
