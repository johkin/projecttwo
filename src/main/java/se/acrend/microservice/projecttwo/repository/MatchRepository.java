package se.acrend.microservice.projecttwo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.acrend.microservice.projecttwo.domain.Match;
import se.acrend.microservice.projecttwo.domain.Team;

/**
 *
 */
@Repository
public interface MatchRepository extends CrudRepository<Match, Long> {
}
