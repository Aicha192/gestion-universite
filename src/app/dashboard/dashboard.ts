import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardService } from '../services/dashboard.service';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard.html',
  styleUrls: ['./dashboard.css'],
})
export class Dashboard {
  students = 0;
  formateurs = 0;
  formations = 0;
  communications = 0;

  constructor(
    private dashboardService: DashboardService,
    private cd: ChangeDetectorRef,
  ) {}
  email: string = '';

  role: string = '';

  ngOnInit() {
    this.email = localStorage.getItem('email') || '';
    this.role = localStorage.getItem('role') || '';
    this.loadStats();
  }

  loadStats() {
    this.dashboardService.getStats().subscribe((data: any) => {
      this.students = data.students;
      this.formateurs = data.formateurs;
      this.formations = data.formations;
      this.communications = data.communications;

      this.cd.detectChanges(); // force Angular refresh
    });
  }
}
