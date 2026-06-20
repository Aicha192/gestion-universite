import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class StudentService {
  private api = 'http://localhost:8081/api/students';

  constructor(private http: HttpClient) {}

  getAllStudents() {
    return this.http.get(this.api);
  }

  addStudent(student: any) {
    return this.http.post(this.api, student);
  }

  deleteStudent(id: number) {
    return this.http.delete(`${this.api}/${id}`);
  }
  updateStudent(id: number, data: any) {
    return this.http.put(`${this.api}/${id}`, data);
  }
}
