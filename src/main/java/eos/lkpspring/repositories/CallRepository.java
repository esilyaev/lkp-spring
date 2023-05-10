package eos.lkpspring.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import eos.lkpspring.domain.models.Call;

public interface CallRepository extends JpaRepository<Call, UUID> {

}
