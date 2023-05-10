package eos.lkpspring.web.dto;

import java.util.UUID;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CreateUserDto {
  private String name;
  private String phone;
  private UUID companyId;
}
