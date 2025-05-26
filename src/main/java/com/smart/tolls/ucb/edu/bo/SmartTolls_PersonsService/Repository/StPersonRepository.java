package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;
public interface StPersonRepository extends JpaRepository<StPersonEntity, Long> {
    @Query("select b from StPersonEntity b where b.personStatus = 1 order by b.idPerson asc")
    List<StPersonEntity> findAllByStatus();

    @Query("select b from StPersonEntity b where b.idPerson=?1 and b.personStatus=?2")
    StPersonEntity findByIdAndByStatus(Long id, int status);
    Optional<StPersonEntity> findByPersonEmail(String email);
}
