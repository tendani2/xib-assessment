package com.xib.assessment.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "agent")
public class Agent {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "firstname")
  private String firstName;

  @Column(name = "lastname")
  private String lastName;

  @Column(name = "idnumber")
  private String idNumber;

 /* // An agent can only be assigned to a team that is managed by the same manager he reports to.
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "team_id", referencedColumnName = "id")
  private Team team;*/
}
