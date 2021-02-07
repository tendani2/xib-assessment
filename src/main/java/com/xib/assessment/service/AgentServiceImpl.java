package com.xib.assessment.service;

import com.xib.assessment.model.Agent;
import com.xib.assessment.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class AgentServiceImpl implements AgentService {
  @Autowired private AgentRepository agentRepository;

  @Override
  public Optional<Agent> findAgentById(Long id) {
    return agentRepository.findById(id);
  }

  @Override
  public Page<Agent> findAll(Pageable pageable) {
    return agentRepository.findAll(pageable);
  }

  @Override
  public  Agent save(Agent agent) {
    return agentRepository.save(agent);
  }
}
