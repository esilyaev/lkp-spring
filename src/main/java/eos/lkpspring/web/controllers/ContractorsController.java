package eos.lkpspring.web.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eos.lkpspring.domain.models.Contractor;
import eos.lkpspring.domain.services.IContractorService;
import eos.lkpspring.web.dto.CreateUserDto;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("contractors")
@AllArgsConstructor

public class ContractorsController {
  private IContractorService userService;

  @GetMapping("deactivate/{id}")
  Contractor banUser(@PathVariable UUID id) {
    return userService.deactivateUser(id);
  }

  @GetMapping
  List<Contractor> getAll() {
    return userService.getAll();
  }

  @GetMapping("{id}")
  Contractor getOne(@PathVariable UUID id) {
    return userService.getOne(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  Contractor createUser(@RequestBody CreateUserDto userDto) {
    return userService.createUser(userDto);

  }

}
