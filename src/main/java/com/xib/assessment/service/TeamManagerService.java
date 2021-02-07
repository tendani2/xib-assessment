package com.xib.assessment.service;

import com.xib.assessment.model.TeamManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface TeamManagerService {
  ResponseEntity<?> createManager(@RequestBody TeamManager teamManager);

  ResponseEntity<?> findByTeamAndManager(Long teamId, Long managerId);
}
