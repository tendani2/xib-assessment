package com.xib.assessment.repository;

import com.xib.assessment.model.TeamManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamManagerRepository extends JpaRepository<TeamManager, Long> {
  TeamManager findByTeamIdAndManagerId(Long teamId, Long managerId);
}
