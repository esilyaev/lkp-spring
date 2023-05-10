package eos.lkpspring.web.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eos.lkpspring.domain.models.Call;
import eos.lkpspring.domain.services.ICallService;
import eos.lkpspring.web.dto.CallCreateDto;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("calls")
@AllArgsConstructor
public class CallController {
  private ICallService callService;

  @PostMapping // (consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  Call createCall(@RequestBody CallCreateDto dto// , @RequestParam MultipartFile[] files
  ) {
    return callService.createCall(dto);
  }
}
