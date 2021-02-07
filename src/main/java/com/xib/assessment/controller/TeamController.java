package com.xib.assessment.controller;

import com.xib.assessment.model.Team;
import com.xib.assessment.service.AgentService;
import com.xib.assessment.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeamController {

  @Autowired private TeamService teamService;
  @Autowired private AgentService agentService;

  @GetMapping("teams")
  public ResponseEntity<?> getAllTeams() {
    return ResponseEntity.ok(teamService.findAll());
  }

  @GetMapping("team/{id}")
  public ResponseEntity<?> findAgentById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(teamService.findById(id));
  }

  @PostMapping("team")
  public ResponseEntity<?> saveTeam(@RequestBody Team team) {
    return ResponseEntity.ok(teamService.save(team));
  }

  // PUT /team/{{id}}/agent - Assigns an agent to the specified team
  @PutMapping("team/{id}/agent")
  public ResponseEntity<?> assignAgentToATeam(@PathVariable Long id, @RequestBody Team team) {
    team.setAgent(agentService.findAgentById(id).orElse(null));
    return ResponseEntity.ok(teamService.save(team));
  }
}
