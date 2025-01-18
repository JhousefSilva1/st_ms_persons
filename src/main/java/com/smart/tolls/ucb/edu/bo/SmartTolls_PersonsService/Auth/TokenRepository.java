package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query(value = """
      select t from Token t inner join StPersonEntity u\s
      on t.user.idPerson = u.idPerson\s
      where u.idPerson = :id and (t.isExpired = false or t.isRevoked = false)\s
      """)
    List<Token> findAllValidTokenByUser(Long id);

    Optional<Token> findByToken(String token);
}
