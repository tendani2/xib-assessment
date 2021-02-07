package com.xib.assessment.service;

import com.xib.assessment.model.TeamManager;
import com.xib.assessment.repository.TeamManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class TeamManagerServiceImpl implements TeamManagerService {
  @Autowired private TeamManagerRepository teamManagerRepository;
  @Autowired private AgentService agentService;
  @Autowired private TeamService teamService;


  @Override
  public TeamManager createManager(@RequestBody TeamManager teamManager) {
    if (teamManager.getTeam() != null && teamManager.getTeam().getAgent() != null) {
      teamManager.getTeam().setAgent(agentService.save(teamManager.getTeam().getAgent()));
      teamManager.setTeam(teamService.save(teamManager.getTeam()));
    }

    return teamManagerRepository.save(teamManager);
  }

  @Override
  public TeamManager findByTeamAndManager(Long teamId, Long managerId) {
    return teamManagerRepository.findByTeamIdAndManagerId(teamId, managerId);
  }

  @Override
  public List<TeamManager> findAll() {
    return teamManagerRepository.findAll();
  }
}
