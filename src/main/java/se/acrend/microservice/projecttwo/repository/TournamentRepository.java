package se.acrend.microservice.projecttwo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.acrend.microservice.projecttwo.domain.Match;
import se.acrend.microservice.projecttwo.domain.Tournament;

/**
 *
 */
@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {



}
