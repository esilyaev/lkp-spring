package eos.lkpspring.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import eos.lkpspring.domain.models.Company;

public interface CompaniesRepository extends JpaRepository<Company, UUID> {
}
