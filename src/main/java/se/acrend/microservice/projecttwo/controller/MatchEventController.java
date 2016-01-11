package se.acrend.microservice.projecttwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se.acrend.microservice.projecttwo.domain.Match;
import se.acrend.microservice.projecttwo.domain.MatchEvent;
import se.acrend.microservice.projecttwo.domain.Team;
import se.acrend.microservice.projecttwo.domain.Tournament;
import se.acrend.microservice.projecttwo.repository.MatchEventRepository;
import se.acrend.microservice.projecttwo.repository.MatchRepository;
import se.acrend.microservice.projecttwo.repository.TeamRepository;
import se.acrend.microservice.projecttwo.repository.TournamentRepository;

import java.time.LocalDateTime;


/**
 *
 */
@Controller
public class MatchEventController {

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private MatchEventRepository matchEventRepository;
    @Autowired
    private TournamentRepository tournamentRepository;
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private SimpMessagingTemplate template;


    @MessageMapping("/greeting")
    public String handle(String greeting) {
        return "[" + LocalDateTime.now() + ": " + greeting;
    }

    @RequestMapping(path = "/createTestData", method = RequestMethod.POST)
    public @ResponseBody Long createTestData() {

        Tournament tournament = new Tournament();
        Team team1 = new Team();
        team1.setName("Lag 1");
        Team team2 = new Team();
        team2.setName("Lag 2");
        team1 = teamRepository.save(team1);
        team2 = teamRepository.save(team2);
        tournament.getContestants().add(team1);
        tournament.getContestants().add(team2);

        tournamentRepository.save(tournament);


        final Match match = new Match();
        match.setHomeTeam(team1);
        match.setVisitorTeam(team2);
        match.setTournament(tournament);

        matchRepository.save(match);

        return match.getId();
    }

    @RequestMapping(path = "/match/{matchId}/addEvent", method = RequestMethod.POST)
    public @ResponseBody Long addEvent(@PathVariable Long matchId, @RequestBody String eventType) {
        final Match match = matchRepository.findOne(matchId);
        final MatchEvent matchEvent = new MatchEvent();
        matchEvent.setEventType(eventType);
        matchEvent.setTeam(match.getHomeTeam());

        matchEventRepository.save(matchEvent);

        match.getEvents().add(matchEvent);

        matchRepository.save(match);

        template.convertAndSend("/topic/match/" + matchId + "/events", matchEvent);

        return matchEvent.getId();
    }

}
