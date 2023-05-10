package eos.lkpspring.domain.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import eos.lkpspring.domain.models.WorkType;
import eos.lkpspring.domain.services.IWorkTypeService;
import eos.lkpspring.domain.services.exception.WorkTypeNotFoundException;
import eos.lkpspring.repositories.WorkTypeRepository;
import eos.lkpspring.web.dto.WorkTypeCreateDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class WorkTypeServiceImpl implements IWorkTypeService {
  private WorkTypeRepository workTypeRepository;

  @Override
  public WorkType getOne(UUID id) throws WorkTypeNotFoundException {
    return workTypeRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Work type not found with id: " + id));
  }

  @Override
  public List<WorkType> getAll() {
    return workTypeRepository.findAll();
  }

  @Override
  public WorkType createWorkType(WorkTypeCreateDto dto) {
    WorkType workType = WorkType.builder()
        .name(dto.getName())
        .build();

    log.info("Created new worktype with name: " + dto.getName());

    return workTypeRepository.save(workType);

  }

}
