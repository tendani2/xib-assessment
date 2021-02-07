package com.xib.assessment;

import com.xib.assessment.model.Agent;
import com.xib.assessment.model.Team;
import com.xib.assessment.model.TeamManager;
import com.xib.assessment.repository.AgentRepository;
import com.xib.assessment.repository.TeamRepository;
import com.xib.assessment.service.TeamManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Component
public class LoadTestData {
  @Autowired private AgentRepository agentRepository;

  @Autowired private TeamManagerService teamManagerService;

  @PostConstruct
  @Transactional
  public void execute() {
    Team team1 = createTeam("Marvel");
    Team team2 = createTeam("DC");

    createAgent("Bruce", "Banner", "1011125190081", team1);
    createAgent("Tony", "Stark", "6912115191083", team1);
    createAgent("Peter", "Parker", "7801115190084", team1);
    createAgent("Bruce", "Wayne", "6511185190085", team2);
    createAgent("Clark", "Kent", "5905115190086", team2);
  }

  private Team createTeam(String name) {
    Team t = new Team();
    t.setName(name);
    return t;
  }

  private void createAgent(String firstName, String lastName, String idNumber, Team team) {
    final Agent a = new Agent();
    a.setFirstName(firstName);
    a.setLastName(lastName);
    a.setIdNumber(idNumber);

    final TeamManager teamManager = new TeamManager();
    team.setAgent(a);
    teamManager.setTeam(team);

    teamManagerService.createManager(teamManager);
  }
}
