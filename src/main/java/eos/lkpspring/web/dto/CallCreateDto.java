package eos.lkpspring.web.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CallCreateDto {
  private UUID workTypeId;
  private UUID projectId;
  private UUID employeeId;

  private LocalDate date;
  private LocalTime time;

  private MultipartFile[] files;

}
