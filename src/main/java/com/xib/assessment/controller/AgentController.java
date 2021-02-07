package com.xib.assessment.controller;

import com.xib.assessment.model.Agent;
import com.xib.assessment.model.dto.AgentDto;
import com.xib.assessment.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AgentController {

  @Autowired private AgentService agentService;

  @GetMapping("agent/{id}")
  public ResponseEntity<?> findAgent(@PathVariable("id") Long id) {
    return new ResponseEntity<>(agentService.findAgentById(id), HttpStatus.OK);
  }

  // GET /agents/ - Implement pagination and query parameters on this request.
  // The agents identity number should no longer be returned in this request.
  @GetMapping("agents")
  public ResponseEntity<?> findAll(Pageable pageable) {
    List<AgentDto> agentList =
        agentService.findAll(pageable).stream()
            .map(this::buildAgentDto)
            .collect(Collectors.toList());
    return new ResponseEntity<>(agentList, HttpStatus.OK);
  }

  private AgentDto buildAgentDto(Agent agent) {
    return AgentDto.builder()
        .firstName(agent.getFirstName())
        .lastName(agent.getLastName())
        .team(agent.getTeam())
        .build();
  }

  @PostMapping("agent")
  public ResponseEntity<?> saveAgent(@RequestBody Agent agent) {
    return new ResponseEntity<>(agentService.save(agent), HttpStatus.OK);
  }
}
