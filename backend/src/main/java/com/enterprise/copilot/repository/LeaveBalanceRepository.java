package com.enterprise.copilot.repository;

import com.enterprise.copilot.model.LeaveBalance;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Long> {
    Optional<LeaveBalance> findByEmployeeId(String employeeId);
}
