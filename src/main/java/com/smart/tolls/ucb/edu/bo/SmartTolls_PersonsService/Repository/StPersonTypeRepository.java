package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StPersonTypeRepository extends JpaRepository<StPersonTypeEntity, Long> {
    @Query("select b from StPersonTypeEntity b where b.status = 1 order by b.idPersonType asc")
    List<StPersonTypeEntity> findAllByStatus();

    @Query("select b from StPersonTypeEntity b where b.idPersonType=?1 and b.status=?2")
    StPersonTypeEntity findByIdAndByStatus(Long id, long status);
}
