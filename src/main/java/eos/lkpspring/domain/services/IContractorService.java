package eos.lkpspring.domain.services;

import java.util.List;
import java.util.UUID;

import eos.lkpspring.domain.models.Contractor;
import eos.lkpspring.domain.services.impl.ContractorNotFoundException;
import eos.lkpspring.web.dto.CreateUserDto;
import eos.lkpspring.web.exception.CompanyNotFoundException;

public interface IContractorService {
  /**
   * Return list of all entity
   * 
   * @return list of entity
   */
  List<Contractor> getAll();

  /**
   * Return User entity by id
   * 
   * @param id present in column id in database
   * @return return founded entity
   * @throws ContractorNotFoundException when in database not have entity with
   *                                     this id
   */

  Contractor getOne(UUID id) throws ContractorNotFoundException;

  /**
   * Create and save user
   * 
   * @param dto must contain info about user and id of company
   * @return saved entity
   * @throws CompanyNotFoundException when company id not presented in database
   */
  Contractor createUser(CreateUserDto dto) throws CompanyNotFoundException;

  /**
   * Set isBanned prop to true for user with given id
   * 
   * @param id unique identifier for user entity
   * @return updated state of User entity
   * @throws ContractorNotFoundException when user with given id not found
   */
  Contractor deactivateUser(UUID id) throws ContractorNotFoundException;

}
