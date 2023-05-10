package eos.lkpspring.domain.services;

import java.util.List;
import java.util.UUID;

import eos.lkpspring.domain.models.Employee;
import eos.lkpspring.web.dto.EmployeeCreateDto;

public interface IEmployeeService {
  Employee getOne(UUID id);

  List<Employee> getAll();

  Employee createEmployee(EmployeeCreateDto dto);

}
