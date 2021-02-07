package com.xib.assessment.service;

import com.xib.assessment.model.Agent;
import com.xib.assessment.model.Team;
import com.xib.assessment.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class TeamServiceImpl implements TeamService {
  @Autowired private TeamRepository teamRepository;

  @Override
  public List<Team> findAll() {
    return teamRepository.findAll();
  }

  @Override
  public Optional<Team> findById(Long id) {
    return teamRepository.findById(id);
  }

  @Override
  public Team save(Team team) {
    return teamRepository.save(team);
  }

  @Override
  public Agent findByAgentId(Long agentId) {
    return teamRepository.findByAgentId(agentId).map(Team::getAgent).orElse(null);
  }

  @Override
  public Team findByAgentIdNumber(String agentIdNumber) {
    return teamRepository.findByAgentIdNumber(agentIdNumber);
  }
}
