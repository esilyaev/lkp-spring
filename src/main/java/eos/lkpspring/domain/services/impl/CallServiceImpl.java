package eos.lkpspring.domain.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import eos.lkpspring.domain.models.Call;
import eos.lkpspring.domain.models.Employee;
import eos.lkpspring.domain.models.Project;
import eos.lkpspring.domain.models.WorkType;
import eos.lkpspring.domain.services.ICallService;
import eos.lkpspring.domain.services.IEmployeeService;
import eos.lkpspring.domain.services.IProjectService;
import eos.lkpspring.domain.services.IWorkTypeService;
import eos.lkpspring.repositories.CallRepository;
import eos.lkpspring.web.dto.CallCreateDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CallServiceImpl implements ICallService {
  private CallRepository callRepository;
  private IProjectService projectService;
  private IWorkTypeService workTypeService;
  private IEmployeeService employeeService;

  @Override
  public List<Call> getAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }

  @Override
  public Call createCall(CallCreateDto dto) {
    WorkType workType = workTypeService.getOne(dto.getWorkTypeId());
    Employee employee = employeeService.getOne(dto.getEmployeeId());
    Project project = projectService.getOne(dto.getProjectId());

    Call call = Call.builder()
        .project(project)
        .workType(workType)
        .employee(employee)
        .date(dto.getDate())
        .time(dto.getTime())
        .build();

    return callRepository.save(call);
  }

}
