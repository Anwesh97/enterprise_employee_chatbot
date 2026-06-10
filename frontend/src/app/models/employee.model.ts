export interface Employee {
  id: string;
  name: string;
  manager: string;
  project: string;
  location: string;
  email: string;
}

export interface Attendance {
  id: number;
  employeeId: string;
  date: string;
  status: string;
  checkIn: string | null;
  checkOut: string | null;
}

export interface LeaveBalance {
  id: number;
  employeeId: string;
  annualLeaves: number;
  sickLeaves: number;
  casualLeaves: number;
}

export interface LearningSummary {
  id: number;
  employeeId: string;
  courseName: string;
  status: string;
  dueDate: string;
}

export interface Holiday {
  id: number;
  holidayName: string;
  date: string;
}
