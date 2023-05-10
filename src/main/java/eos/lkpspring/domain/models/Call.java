package eos.lkpspring.domain.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Call {
  @Id
  @GeneratedValue
  private UUID id;
  private long number;

  @CreationTimestamp
  private LocalDateTime createdAt;

  private LocalDate date;

  private LocalTime time;

  @ManyToOne
  private WorkType workType;

  @ManyToOne
  private Project project;

  @ManyToOne
  private Employee employee;

}
