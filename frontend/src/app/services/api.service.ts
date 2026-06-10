import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee, Attendance, LeaveBalance, LearningSummary, Holiday } from '../models/employee.model';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getAllEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.baseUrl}/employees`);
  }

  getEmployee(empId: string): Observable<Employee> {
    return this.http.get<Employee>(`${this.baseUrl}/employees/${empId}`);
  }

  getAttendance(empId: string): Observable<Attendance[]> {
    return this.http.get<Attendance[]>(`${this.baseUrl}/employees/${empId}/attendance`);
  }

  getLeaveBalance(empId: string): Observable<LeaveBalance> {
    return this.http.get<LeaveBalance>(`${this.baseUrl}/employees/${empId}/leave-balance`);
  }

  getLearning(empId: string): Observable<LearningSummary[]> {
    return this.http.get<LearningSummary[]>(`${this.baseUrl}/employees/${empId}/learning`);
  }

  getHolidays(): Observable<Holiday[]> {
    return this.http.get<Holiday[]>(`${this.baseUrl}/holidays`);
  }
}
