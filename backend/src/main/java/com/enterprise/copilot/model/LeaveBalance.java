package com.enterprise.copilot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leave_balances")
public class LeaveBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeId;
    private int annualLeaves;
    private int sickLeaves;
    private int casualLeaves;

    // Constructors
    public LeaveBalance() {}

    public LeaveBalance(String employeeId, int annualLeaves, int sickLeaves, int casualLeaves) {
        this.employeeId = employeeId;
        this.annualLeaves = annualLeaves;
        this.sickLeaves = sickLeaves;
        this.casualLeaves = casualLeaves;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public int getAnnualLeaves() {
        return annualLeaves;
    }

    public void setAnnualLeaves(int annualLeaves) {
        this.annualLeaves = annualLeaves;
    }

    public int getSickLeaves() {
        return sickLeaves;
    }

    public void setSickLeaves(int sickLeaves) {
        this.sickLeaves = sickLeaves;
    }

    public int getCasualLeaves() {
        return casualLeaves;
    }

    public void setCasualLeaves(int casualLeaves) {
        this.casualLeaves = casualLeaves;
    }
}
