package eos.lkpspring.web.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WebAppException {
  private String message;
  private int code;
}
