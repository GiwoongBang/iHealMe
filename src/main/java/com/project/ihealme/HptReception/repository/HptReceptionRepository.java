package com.project.ihealme.HptReception.repository;

import com.project.ihealme.HptReception.domain.HptReception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HptReceptionRepository extends JpaRepository<HptReception, Long> {
}
