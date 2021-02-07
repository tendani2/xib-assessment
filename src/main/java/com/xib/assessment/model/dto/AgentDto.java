package com.xib.assessment.model.dto;

import com.xib.assessment.model.Team;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class AgentDto {
  private String firstName;
  private String lastName;
  private Team team;
}
