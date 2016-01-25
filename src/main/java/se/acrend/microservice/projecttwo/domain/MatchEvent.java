package se.acrend.microservice.projecttwo.domain;

import javax.persistence.*;

/**
 *
 */
@Entity
public class MatchEvent {


    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Team team;

    private String eventType;
    @ManyToOne
    private Match ownerMatch;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Match getOwnerMatch() {
        return ownerMatch;
    }

    public void setOwnerMatch(Match ownerMatch) {
        this.ownerMatch = ownerMatch;
    }
}
