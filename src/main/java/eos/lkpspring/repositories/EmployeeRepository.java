package eos.lkpspring.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import eos.lkpspring.domain.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

}
