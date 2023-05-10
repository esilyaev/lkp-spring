package eos.lkpspring.domain.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import eos.lkpspring.domain.models.Employee;
import eos.lkpspring.domain.services.IEmployeeService;
import eos.lkpspring.domain.services.exception.EmployeeNotFoundException;
import eos.lkpspring.repositories.EmployeeRepository;
import eos.lkpspring.web.dto.EmployeeCreateDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService {
  private EmployeeRepository employeeRepository;

  @Override
  public Employee getOne(UUID id) {
    return employeeRepository.findById(id)
        .orElseThrow(() -> new EmployeeNotFoundException(id));

  }

  @Override
  public Employee createEmployee(EmployeeCreateDto dto) {
    Employee employee = Employee.builder()
        .name(dto.getName())
        .build();

    log.info("Create employee with name: " + dto.getName());
    return employeeRepository.save(employee);
  }

  @Override
  public List<Employee> getAll() {
    return this.employeeRepository.findAll();
  }

}
