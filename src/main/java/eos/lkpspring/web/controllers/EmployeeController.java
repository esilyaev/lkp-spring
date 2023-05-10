package eos.lkpspring.web.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eos.lkpspring.domain.models.Employee;
import eos.lkpspring.domain.services.IEmployeeService;
import eos.lkpspring.web.dto.EmployeeCreateDto;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("employee")
@AllArgsConstructor
public class EmployeeController {
  private IEmployeeService employeeService;

  @GetMapping
  List<Employee> getAll() {
    return employeeService.getAll();
  }

  @GetMapping("{id}")
  Employee getOne(@PathVariable UUID id) {
    return employeeService.getOne(id);
  }

  @PostMapping
  Employee createEmployee(@RequestBody EmployeeCreateDto dto) {
    return employeeService.createEmployee(dto);
  }
}
