package com.xib.assessment.service;

import com.xib.assessment.model.Agent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface AgentService {
  Optional<Agent> findAgentById(Long id);

  Page<Agent> findAll(Pageable pageable);

 Agent save(Agent agent);
}
