import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class DashboardService {
  private api = 'http://localhost:8081/api';

  constructor(private http: HttpClient) {}

  getStats() {
    return this.http.get(`${this.api}/dashboard/stats`);
  }
}
