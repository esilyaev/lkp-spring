package eos.lkpspring.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import eos.lkpspring.domain.models.WorkType;

public interface WorkTypeRepository extends JpaRepository<WorkType, UUID> {

}
