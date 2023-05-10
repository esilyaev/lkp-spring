package eos.lkpspring.domain.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import eos.lkpspring.domain.models.Company;
import eos.lkpspring.domain.models.Contractor;
import eos.lkpspring.domain.services.IContractorService;
import eos.lkpspring.repositories.CompaniesRepository;
import eos.lkpspring.repositories.ContractorRepository;
import eos.lkpspring.web.dto.CreateUserDto;
import eos.lkpspring.web.exception.CompanyNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ContractorServiceImpl implements IContractorService {
  private ContractorRepository usersRepository;
  private CompaniesRepository companiesRepository;

  @Override
  public Contractor createUser(CreateUserDto dto) {
    Company company = companiesRepository.findById(dto.getCompanyId())
        .orElseThrow(() -> new CompanyNotFoundException(dto.getCompanyId()));

    Contractor user = Contractor.builder()
        .name(dto.getName())
        .phone(dto.getPhone())
        .company(company)
        .build();

    log.info("Create user witch params: " + dto.toString());

    return this.usersRepository.save(user);
  }

  @Override
  public Contractor deactivateUser(UUID id) {
    Contractor user = usersRepository.findById(id)
        .orElseThrow(() -> new ContractorNotFoundException(id));

    user.setBanned(true);
    return usersRepository.save(user);
  }

  @Override
  public List<Contractor> getAll() {
    log.info("Requested all users");
    return this.usersRepository.findAll();
  }

  @Override
  public Contractor getOne(UUID id) {
    log.info("Requested user with id: " + id);
    return this.usersRepository.findById(id)
        .orElseThrow(() -> new ContractorNotFoundException(id));
  }

}
