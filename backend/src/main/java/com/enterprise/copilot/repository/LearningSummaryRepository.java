package com.enterprise.copilot.repository;

import com.enterprise.copilot.model.LearningSummary;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningSummaryRepository extends JpaRepository<LearningSummary, Long> {
    List<LearningSummary> findByEmployeeId(String employeeId);
}
