package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StPersonRepository extends JpaRepository<StPersonEntity, Long> {

//    List<StPersonEntity> findByCountryId(Long countryId);

}
