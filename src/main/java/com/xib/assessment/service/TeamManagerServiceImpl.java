package com.xib.assessment.service;

import com.xib.assessment.model.TeamManager;
import com.xib.assessment.repository.TeamManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@Transactional
@Service
public class TeamManagerServiceImpl implements TeamManagerService {
  @Autowired private TeamManagerRepository teamManagerRepository;

  @Override
  public ResponseEntity<?> createManager(@RequestBody TeamManager teamManager){
    return ResponseEntity.ok(teamManagerRepository.save(teamManager));
  }

  @Override
  public ResponseEntity<?> findByTeamAndManager(Long teamId, Long managerId) {
    return ResponseEntity.ok(teamManagerRepository.findByTeamIdAndManagerId(teamId, managerId));
  }

}
