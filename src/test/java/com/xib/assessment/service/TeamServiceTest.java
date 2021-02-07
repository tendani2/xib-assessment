package com.xib.assessment.service;

import com.xib.assessment.model.Agent;
import com.xib.assessment.model.Team;
import com.xib.assessment.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TeamServiceTest {
  public static final String TEAM_1 = "Team#1";
  public static final String TEAM_1_NAME = "Marvel";
  public static final String TEAM_2_NAME = "DC";
  public static final String AGENT_ID_1 = "1011125190081";
  public static final String AGENT_ID_4 = "6511185190085";
  public static final String AGENT_NAME_1 = "Bruce";
  public static final String AGENT_NAME_4 = "Bruce";
  public static final String AGENT_LASTNAME_1 = "Banner";
  public static final String AGENT_LASTNAME_4 = "Wayne";

  @Autowired private TeamService teamService;
  @Autowired private TeamRepository teamRepository;

  @Test
  public void shouldAssetCreatingTeamWithoutAgent() {
    final Team team = new Team();
    team.setName(TEAM_1);

    final Team team1 = teamService.save(team);

    assertNotNull(team1);
    assertEquals(team1.getName(), TEAM_1);
    assertTrue(team1.getAgent() == null);
  }

  @Test
  public void shouldAssetFindByAgentId() {
    Team team1 = createTeam(TEAM_1_NAME);
    Team team2 = createTeam(TEAM_2_NAME);

    team1.setAgent(createAgent(AGENT_NAME_1, AGENT_LASTNAME_1, AGENT_ID_1));
    team2.setAgent(createAgent(AGENT_NAME_4, AGENT_LASTNAME_4, AGENT_ID_4));

    final Team savedTeam1 = teamRepository.save(team1);
    final Team savedTeam2 = teamRepository.save(team2);

    assertNotNull(savedTeam1);
    assertNotNull(savedTeam2);

    Team foundTeam1 = teamService.findByAgentIdNumber(AGENT_ID_1);
    assertNotNull(foundTeam1);

    Team foundTeam2 = teamService.findByAgentIdNumber(AGENT_ID_4);
    assertNotNull(foundTeam2);

    List<Team> teamList = teamService.findAll();

    Team foundTeam1ById = teamService.findById(foundTeam1.getId()).get();
    assertEquals(foundTeam1ById.getId(), foundTeam1.getId());
  }

  private Team createTeam(String name) {
    Team team = new Team();
    team.setName(name);
    return teamRepository.save(team);
  }

  private Agent createAgent(String firstName, String lastName, String idNumber) {
    Agent agent = new Agent();
    agent.setFirstName(firstName);
    agent.setLastName(lastName);
    agent.setIdNumber(idNumber);
    return agent;
  }
}
