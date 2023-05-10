package eos.lkpspring.domain.services;

import java.util.List;
import java.util.UUID;

import eos.lkpspring.domain.models.WorkType;
import eos.lkpspring.domain.services.exception.WorkTypeNotFoundException;
import eos.lkpspring.web.dto.WorkTypeCreateDto;

public interface IWorkTypeService {
  WorkType getOne(UUID id) throws WorkTypeNotFoundException;

  List<WorkType> getAll();

  WorkType createWorkType(WorkTypeCreateDto dto);
}
