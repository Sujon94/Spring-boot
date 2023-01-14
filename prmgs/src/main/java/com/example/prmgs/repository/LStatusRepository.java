package com.example.prmgs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.prmgs.model.LStatus;

import java.util.List;

public interface LStatusRepository extends JpaRepository<LStatus, Long> {

    List<LStatus> findAllByIdIn(List<Long> ids);
}
