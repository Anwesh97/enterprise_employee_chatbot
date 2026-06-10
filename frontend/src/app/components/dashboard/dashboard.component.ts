import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../services/api.service';
import { Employee, Attendance, LeaveBalance, LearningSummary, Holiday } from '../../models/employee.model';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  employees: Employee[] = [];
  selectedEmployee: Employee | null = null;
  attendance: Attendance[] = [];
  leaveBalance: LeaveBalance | null = null;
  learning: LearningSummary[] = [];
  holidays: Holiday[] = [];
  loading = false;

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.apiService.getAllEmployees().subscribe(data => {
      this.employees = data;
      if (data.length > 0) {
        this.selectEmployee(data[0]);
      }
    });

    this.apiService.getHolidays().subscribe(data => {
      this.holidays = data;
    });
  }

  selectEmployee(emp: Employee): void {
    this.selectedEmployee = emp;
    this.loading = true;

    this.apiService.getAttendance(emp.id).subscribe(data => {
      this.attendance = data;
    });

    this.apiService.getLeaveBalance(emp.id).subscribe(data => {
      this.leaveBalance = data;
    });

    this.apiService.getLearning(emp.id).subscribe(data => {
      this.learning = data;
      this.loading = false;
    });
  }

  get totalLeaves(): number {
    if (!this.leaveBalance) return 0;
    return this.leaveBalance.annualLeaves + this.leaveBalance.sickLeaves + this.leaveBalance.casualLeaves;
  }

  get presentDays(): number {
    return this.attendance.filter(a => a.status === 'Present').length;
  }

  get completedCourses(): number {
    return this.learning.filter(l => l.status === 'Completed').length;
  }

  get pendingCourses(): number {
    return this.learning.filter(l => l.status === 'Pending').length;
  }

  get nextHoliday(): Holiday | null {
    const today = new Date();
    const upcoming = this.holidays
      .filter(h => new Date(h.date) >= today)
      .sort((a, b) => new Date(a.date).getTime() - new Date(b.date).getTime());
    return upcoming.length > 0 ? upcoming[0] : null;
  }

  getStatusClass(status: string): string {
    switch (status.toLowerCase()) {
      case 'present': return 'status-present';
      case 'absent': return 'status-absent';
      case 'leave': return 'status-leave';
      case 'completed': return 'status-completed';
      case 'pending': return 'status-pending';
      default: return '';
    }
  }

  formatDate(dateStr: string): string {
    const date = new Date(dateStr);
    return date.toLocaleDateString('en-IN', { day: '2-digit', month: 'short', year: 'numeric' });
  }

  formatTime(timeStr: string | null): string {
    if (!timeStr) return '—';
    const parts = timeStr.split(':');
    const hours = parseInt(parts[0]);
    const minutes = parts[1];
    const amPm = hours >= 12 ? 'PM' : 'AM';
    const displayHours = hours % 12 || 12;
    return `${displayHours}:${minutes} ${amPm}`;
  }

  daysUntil(dateStr: string): number {
    const today = new Date();
    today.setHours(0, 0, 0, 0);
    const target = new Date(dateStr);
    target.setHours(0, 0, 0, 0);
    return Math.ceil((target.getTime() - today.getTime()) / (1000 * 60 * 60 * 24));
  }
}
