package com.enterprise.copilot.controller;

import com.enterprise.copilot.model.*;
import com.enterprise.copilot.repository.*;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final EmployeeRepository employeeRepository;
    private final AttendanceRepository attendanceRepository;
    private final LeaveBalanceRepository leaveBalanceRepository;
    private final LearningSummaryRepository learningSummaryRepository;
    private final HolidayRepository holidayRepository;

    @Autowired
    public ApiController(
            EmployeeRepository employeeRepository,
            AttendanceRepository attendanceRepository,
            LeaveBalanceRepository leaveBalanceRepository,
            LearningSummaryRepository learningSummaryRepository,
            HolidayRepository holidayRepository) {
        this.employeeRepository = employeeRepository;
        this.attendanceRepository = attendanceRepository;
        this.leaveBalanceRepository = leaveBalanceRepository;
        this.learningSummaryRepository = learningSummaryRepository;
        this.holidayRepository = holidayRepository;
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, String>> getStatus() {
        return ResponseEntity.ok(Map.of(
            "status", "UP",
            "message", "Enterprise Employee Copilot Backend is running successfully."
        ));
    }

    @GetMapping("/api/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/api/employees/{empId}")
    public ResponseEntity<Employee> getEmployeeProfile(@PathVariable String empId) {
        return employeeRepository.findById(empId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/api/employees/{empId}/attendance")
    public List<Attendance> getAttendance(@PathVariable String empId) {
        return attendanceRepository.findByEmployeeId(empId);
    }

    @GetMapping("/api/employees/{empId}/leave-balance")
    public ResponseEntity<LeaveBalance> getLeaveBalance(@PathVariable String empId) {
        return leaveBalanceRepository.findByEmployeeId(empId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/api/employees/{empId}/learning")
    public List<LearningSummary> getLearning(@PathVariable String empId) {
        return learningSummaryRepository.findByEmployeeId(empId);
    }

    @GetMapping("/api/holidays")
    public List<Holiday> getHolidays() {
        return holidayRepository.findAll();
    }
}
