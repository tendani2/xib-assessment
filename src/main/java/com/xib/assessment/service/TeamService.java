package com.xib.assessment.service;

import com.xib.assessment.model.Agent;
import com.xib.assessment.model.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {
  List<Team> findAll();

  Optional<Team> findById(Long id);

  Team save(Team team);

  Agent findByAgentId(Long agentId);

  Team findByAgentIdNumber(String agentIdNumber);
}
