import { Routes } from '@angular/router';
import { authGuard } from './guards/auth.guard';

import { SidebarComponent } from './layout/sidebar/sidebar';
import { Dashboard } from './dashboard/dashboard';
import { LoginComponent } from './auth/login/login';

import { Students } from './students/students';
import { Formations } from './formations/formations';
import { Formateurs } from './formateurs/formateurs';
import { Communications } from './communications/communications';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },

  {
    path: '',
    component: SidebarComponent,
    canActivate: [authGuard],
    children: [
      { path: 'dashboard', component: Dashboard },
      { path: 'students', component: Students },
      { path: 'formations', component: Formations },
      { path: 'formateurs', component: Formateurs },
      { path: 'communications', component: Communications }
    ]
  }
];
