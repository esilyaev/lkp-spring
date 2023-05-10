package eos.lkpspring.web.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eos.lkpspring.domain.models.Company;
import eos.lkpspring.repositories.CompaniesRepository;
import eos.lkpspring.web.dto.CreateCompanyDto;
import eos.lkpspring.web.exception.CompanyNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("companies")
@AllArgsConstructor
@Slf4j
public class CompaniesController {
  private CompaniesRepository companiesRepository;

  @GetMapping
  List<Company> getAll() {
    log.info("Requested all companies");
    return companiesRepository.findAll();
  }

  @GetMapping("{id}")
  Company getOne(@PathVariable UUID id) {
    log.info("Requested one company with id: " + id);
    return companiesRepository.findById(id)
        .orElseThrow(() -> new CompanyNotFoundException(id));
  }

  @PostMapping
  Company createCompany(@RequestBody CreateCompanyDto createCompanyDto) {
    Company company = Company.builder()
        .name(createCompanyDto.getName())
        .build();

    log.info("Try to create company with name: " + createCompanyDto.getName());

    return companiesRepository.save(company);

  }

}
