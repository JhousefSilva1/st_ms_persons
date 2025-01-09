package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StGenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StGenderRepository extends JpaRepository<StGenderEntity, Long> {
    @Query("select b from StGenderEntity b where b.status = 1 order by b.idGender asc")
    List<StGenderEntity> findAllByStatus();

    @Query("select b from StGenderEntity b where b.idGender=?1 and b.status=?2")
    StGenderEntity findByIdAndByStatus(Long id, long status);
}
