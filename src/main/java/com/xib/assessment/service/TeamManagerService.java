package com.xib.assessment.service;

import com.xib.assessment.model.TeamManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TeamManagerService {
  TeamManager createManager(@RequestBody TeamManager teamManager);

  TeamManager findByTeamAndManager(Long teamId, Long managerId);

  List<TeamManager> findAll();
}
