package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StPersonRepository extends JpaRepository<StPersonEntity, Long> {
    @Query("select b from StPersonEntity b where b.status = 1 order by b.idPerson asc")
    List<StPersonEntity> findAllByStatus();

    @Query("select b from StPersonEntity b where b.idPerson=?1 and b.status=?2")
    StPersonEntity findByIdAndByStatus(Long id, long status);

}
