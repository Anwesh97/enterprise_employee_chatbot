package com.enterprise.copilot.config;

import com.enterprise.copilot.model.*;
import com.enterprise.copilot.repository.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final AttendanceRepository attendanceRepository;
    private final LeaveBalanceRepository leaveBalanceRepository;
    private final LearningSummaryRepository learningSummaryRepository;
    private final HolidayRepository holidayRepository;

    @Autowired
    public DatabaseSeeder(
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

    @Override
    public void run(String... args) throws Exception {
        if (employeeRepository.count() == 0) {
            seedEmployees();
            seedAttendance();
            seedLeaveBalances();
            seedLearningSummaries();
            seedHolidays();
            System.out.println(">>> Database Seeded Successfully with Mock HR Data. <<<");
        }
    }

    private void seedEmployees() {
        Employee emp1 = new Employee("EMP001", "John Doe", "Rahul Sharma", "McKesson RAG", "Pune", "john.doe@enterprise.com");
        Employee emp2 = new Employee("EMP002", "Rahul Sharma", "Amit Patel", "McKesson Delivery", "Pune", "rahul.sharma@enterprise.com");
        Employee emp3 = new Employee("EMP003", "Alice Smith", "Rahul Sharma", "McKesson RAG", "Bangalore", "alice.smith@enterprise.com");
        Employee emp4 = new Employee("EMP004", "Bob Johnson", "Rahul Sharma", "McKesson RAG", "Pune", "bob.johnson@enterprise.com");
        Employee emp5 = new Employee("EMP005", "Charlie Brown", "Amit Patel", "McKesson Delivery", "Hyderabad", "charlie.brown@enterprise.com");
        Employee emp6 = new Employee("EMP006", "Diana Prince", "Amit Patel", "AWS Cloud Migration", "Bangalore", "diana.prince@enterprise.com");
        Employee emp7 = new Employee("EMP007", "Evan Wright", "Diana Prince", "AWS Cloud Migration", "Bangalore", "evan.wright@enterprise.com");
        Employee emp8 = new Employee("EMP008", "Fiona Gallagher", "Rahul Sharma", "McKesson Delivery", "Pune", "fiona.gallagher@enterprise.com");
        Employee emp9 = new Employee("EMP009", "George Green", "Fiona Gallagher", "McKesson Delivery", "Pune", "george.green@enterprise.com");
        Employee emp10 = new Employee("EMP010", "Hannah Abbott", "Diana Prince", "AWS Cloud Migration", "Hyderabad", "hannah.abbott@enterprise.com");
        employeeRepository.saveAll(List.of(emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8, emp9, emp10));
    }

    private void seedAttendance() {
        // Attendance for EMP001 (John Doe)
        attendanceRepository.saveAll(List.of(
            new Attendance("EMP001", LocalDate.of(2026, 6, 8), "Present", LocalTime.of(9, 0), LocalTime.of(18, 0)),
            new Attendance("EMP001", LocalDate.of(2026, 6, 9), "Present", LocalTime.of(9, 15), LocalTime.of(18, 30)),
            new Attendance("EMP001", LocalDate.of(2026, 6, 10), "Present", LocalTime.of(9, 0), LocalTime.of(17, 45)),
            new Attendance("EMP001", LocalDate.of(2026, 6, 11), "Present", LocalTime.of(8, 55), LocalTime.of(18, 10)),
            new Attendance("EMP001", LocalDate.of(2026, 6, 5), "Present", LocalTime.of(9, 0), LocalTime.of(18, 0))
        ));

        // Attendance for EMP003 (Alice Smith)
        attendanceRepository.saveAll(List.of(
            new Attendance("EMP003", LocalDate.of(2026, 6, 8), "Present", LocalTime.of(9, 30), LocalTime.of(18, 30)),
            new Attendance("EMP003", LocalDate.of(2026, 6, 9), "Leave", null, null),
            new Attendance("EMP003", LocalDate.of(2026, 6, 10), "Present", LocalTime.of(9, 0), LocalTime.of(18, 0))
        ));

        // Attendance for EMP004 (Bob Johnson)
        attendanceRepository.saveAll(List.of(
            new Attendance("EMP004", LocalDate.of(2026, 6, 8), "Present", LocalTime.of(9, 0), LocalTime.of(17, 30)),
            new Attendance("EMP004", LocalDate.of(2026, 6, 9), "Absent", null, null),
            new Attendance("EMP004", LocalDate.of(2026, 6, 10), "Present", LocalTime.of(9, 10), LocalTime.of(18, 0)),
            new Attendance("EMP004", LocalDate.of(2026, 6, 11), "Present", LocalTime.of(8, 50), LocalTime.of(18, 15))
        ));

        // Attendance for EMP005 (Charlie Brown)
        attendanceRepository.saveAll(List.of(
            new Attendance("EMP005", LocalDate.of(2026, 6, 8), "Present", LocalTime.of(9, 0), LocalTime.of(18, 0)),
            new Attendance("EMP005", LocalDate.of(2026, 6, 9), "Present", LocalTime.of(9, 0), LocalTime.of(18, 0)),
            new Attendance("EMP005", LocalDate.of(2026, 6, 10), "Leave", null, null),
            new Attendance("EMP005", LocalDate.of(2026, 6, 11), "Present", LocalTime.of(9, 30), LocalTime.of(19, 0))
        ));

        // Attendance for EMP006 (Diana Prince)
        attendanceRepository.saveAll(List.of(
            new Attendance("EMP006", LocalDate.of(2026, 6, 8), "Present", LocalTime.of(8, 45), LocalTime.of(18, 0)),
            new Attendance("EMP006", LocalDate.of(2026, 6, 9), "Present", LocalTime.of(9, 0), LocalTime.of(18, 30)),
            new Attendance("EMP006", LocalDate.of(2026, 6, 10), "Present", LocalTime.of(9, 0), LocalTime.of(18, 0))
        ));

        // Attendance for EMP007 (Evan Wright)
        attendanceRepository.saveAll(List.of(
            new Attendance("EMP007", LocalDate.of(2026, 6, 8), "Present", LocalTime.of(9, 10), LocalTime.of(18, 10)),
            new Attendance("EMP007", LocalDate.of(2026, 6, 9), "Leave", null, null),
            new Attendance("EMP007", LocalDate.of(2026, 6, 10), "Leave", null, null),
            new Attendance("EMP007", LocalDate.of(2026, 6, 11), "Present", LocalTime.of(9, 0), LocalTime.of(18, 0))
        ));

        // Attendance for EMP008 (Fiona Gallagher)
        attendanceRepository.saveAll(List.of(
            new Attendance("EMP008", LocalDate.of(2026, 6, 8), "Present", LocalTime.of(9, 0), LocalTime.of(18, 0)),
            new Attendance("EMP008", LocalDate.of(2026, 6, 9), "Present", LocalTime.of(9, 0), LocalTime.of(18, 0)),
            new Attendance("EMP008", LocalDate.of(2026, 6, 10), "Absent", null, null),
            new Attendance("EMP008", LocalDate.of(2026, 6, 11), "Present", LocalTime.of(9, 0), LocalTime.of(18, 0))
        ));

        // Attendance for EMP009 (George Green)
        attendanceRepository.saveAll(List.of(
            new Attendance("EMP009", LocalDate.of(2026, 6, 8), "Present", LocalTime.of(8, 30), LocalTime.of(17, 30)),
            new Attendance("EMP009", LocalDate.of(2026, 6, 9), "Present", LocalTime.of(9, 0), LocalTime.of(18, 0)),
            new Attendance("EMP009", LocalDate.of(2026, 6, 10), "Present", LocalTime.of(9, 0), LocalTime.of(18, 0))
        ));

        // Attendance for EMP010 (Hannah Abbott)
        attendanceRepository.saveAll(List.of(
            new Attendance("EMP010", LocalDate.of(2026, 6, 8), "Present", LocalTime.of(9, 30), LocalTime.of(18, 0)),
            new Attendance("EMP010", LocalDate.of(2026, 6, 9), "Leave", null, null),
            new Attendance("EMP010", LocalDate.of(2026, 6, 10), "Absent", null, null),
            new Attendance("EMP010", LocalDate.of(2026, 6, 11), "Present", LocalTime.of(9, 0), LocalTime.of(18, 0))
        ));
    }

    private void seedLeaveBalances() {
        leaveBalanceRepository.saveAll(List.of(
            new LeaveBalance("EMP001", 12, 5, 8),
            new LeaveBalance("EMP002", 15, 6, 10),
            new LeaveBalance("EMP003", 8, 4, 6),
            new LeaveBalance("EMP004", 10, 3, 5),
            new LeaveBalance("EMP005", 14, 6, 7),
            new LeaveBalance("EMP006", 18, 8, 10),
            new LeaveBalance("EMP007", 9, 4, 6),
            new LeaveBalance("EMP008", 11, 5, 4),
            new LeaveBalance("EMP009", 13, 6, 8),
            new LeaveBalance("EMP010", 7, 2, 5)
        ));
    }

    private void seedLearningSummaries() {
        // EMP001 Courses
        learningSummaryRepository.saveAll(List.of(
            new LearningSummary("EMP001", "Code of Conduct Training", "Completed", LocalDate.of(2026, 6, 30)),
            new LearningSummary("EMP001", "Information Security Guidelines", "Pending", LocalDate.of(2026, 6, 15)),
            new LearningSummary("EMP001", "Diversity and Inclusion", "Completed", LocalDate.of(2026, 7, 15))
        ));

        // EMP003 Courses
        learningSummaryRepository.saveAll(List.of(
            new LearningSummary("EMP003", "Information Security Guidelines", "Completed", LocalDate.of(2026, 6, 15)),
            new LearningSummary("EMP003", "Anti-Bribery and Corruption", "Pending", LocalDate.of(2026, 6, 25))
        ));

        // EMP004 Courses
        learningSummaryRepository.saveAll(List.of(
            new LearningSummary("EMP004", "Code of Conduct Training", "Pending", LocalDate.of(2026, 6, 30))
        ));

        // EMP005 Courses
        learningSummaryRepository.saveAll(List.of(
            new LearningSummary("EMP005", "AWS Cloud Basics", "Completed", LocalDate.of(2026, 5, 20)),
            new LearningSummary("EMP005", "Information Security Guidelines", "Completed", LocalDate.of(2026, 6, 15))
        ));

        // EMP006 Courses
        learningSummaryRepository.saveAll(List.of(
            new LearningSummary("EMP006", "Manager Essentials Training", "Completed", LocalDate.of(2026, 4, 30)),
            new LearningSummary("EMP006", "Information Security Guidelines", "Completed", LocalDate.of(2026, 6, 15))
        ));

        // EMP007 Courses
        learningSummaryRepository.saveAll(List.of(
            new LearningSummary("EMP007", "AWS Advanced Infrastructure", "Pending", LocalDate.of(2026, 7, 10)),
            new LearningSummary("EMP007", "Information Security Guidelines", "Completed", LocalDate.of(2026, 6, 15))
        ));

        // EMP008 Courses
        learningSummaryRepository.saveAll(List.of(
            new LearningSummary("EMP008", "Code of Conduct Training", "Completed", LocalDate.of(2026, 6, 30))
        ));

        // EMP009 Courses
        learningSummaryRepository.saveAll(List.of(
            new LearningSummary("EMP009", "Information Security Guidelines", "Pending", LocalDate.of(2026, 6, 15))
        ));

        // EMP010 Courses
        learningSummaryRepository.saveAll(List.of(
            new LearningSummary("EMP010", "Diversity and Inclusion", "Completed", LocalDate.of(2026, 7, 15)),
            new LearningSummary("EMP010", "Anti-Bribery and Corruption", "Pending", LocalDate.of(2026, 6, 25))
        ));
    }

    private void seedHolidays() {
        holidayRepository.saveAll(List.of(
            new Holiday("Independence Day", LocalDate.of(2026, 8, 15)),
            new Holiday("Gandhi Jayanti", LocalDate.of(2026, 10, 2)),
            new Holiday("Diwali", LocalDate.of(2026, 11, 8)),
            new Holiday("Christmas Day", LocalDate.of(2026, 12, 25))
        ));
    }
}
