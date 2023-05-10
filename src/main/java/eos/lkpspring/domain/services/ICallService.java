package eos.lkpspring.domain.services;

import java.util.List;

import eos.lkpspring.domain.models.Call;
import eos.lkpspring.web.dto.CallCreateDto;

public interface ICallService {
  List<Call> getAll();

  Call createCall(CallCreateDto dto);
}
