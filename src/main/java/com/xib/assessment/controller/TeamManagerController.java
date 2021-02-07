package com.xib.assessment.controller;

import com.xib.assessment.model.TeamManager;
import com.xib.assessment.service.TeamManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeamManagerController {
  @Autowired private TeamManagerService teamManagerService;

  // POST /manager/ - Creates a new manager with the specified details - Expects a JSON body
  @PostMapping("manager")
  public ResponseEntity<?> createManager(@RequestBody TeamManager teamManager) {
    return ResponseEntity.ok(teamManagerService.createManager(teamManager));
  }

  // create an api endpoint that will return a list of all empty teams (i.e teams with no agents or managers)
  @GetMapping("team/{teamId}/{managerId}")
  public ResponseEntity<?> findByTeamAndManager(@PathVariable Long teamId, @PathVariable Long managerId) {
    return ResponseEntity.ok(teamManagerService.findByTeamAndManager(teamId, managerId));
  }
}
