package se.acrend.microservice.projecttwo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@Entity
public class Tournament {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    private Set<Team> contestants = new HashSet<Team>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Team> getContestants() {
        return contestants;
    }

    public void setContestants(Set<Team> contestants) {
        this.contestants = contestants;
    }
}
