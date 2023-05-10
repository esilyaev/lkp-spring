package eos.lkpspring.domain.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Contractor {

  @Id
  @GeneratedValue
  private UUID id;

  private String name;
  private String phone;

  @Column(columnDefinition = "boolean default false")
  private boolean isBanned;

  @ManyToOne
  private Company company;

}
