package eos.lkpspring.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import eos.lkpspring.domain.models.Contractor;

public interface ContractorRepository extends JpaRepository<Contractor, UUID> {

}
