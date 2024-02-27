import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddTaskComponent } from './pages/admin/add-task/add-task.component';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { UpdateTaskComponent } from './pages/admin/update-task/update-task.component';
import { ViewTasksComponent } from './pages/admin/view-tasks/view-tasks.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';
import { Error404Component } from './pages/errorpage/error404/error404.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { SignupComponent } from './pages/signup/signup.component';
import { AdminGuard } from './services/admin.guard';
import { UserGuard } from './services/user.guard';

const routes: Routes = [

  // For Home Page
  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full'
  },

  // For Signup Page
  {
    path: 'signup',
    component: SignupComponent,
    pathMatch: 'full',
  },

  // For Login Page
  {
    path: 'login',
    component: LoginComponent,
    pathMatch: 'full',
  },

  // For Admin Dashboard
  {
    path: 'admin',
    component: DashboardComponent,
    // pathMatch: 'full',
    // Admin Gaurd
    canActivate: [AdminGuard],

    // for profile content dashboard content
    children: [
      {
        path: '',
        component: WelcomeComponent,
      },

      {
        path: 'profile',
        component: ProfileComponent,
      },

      {
        path: 'error404',
        component: Error404Component,
      },

      {
        path: 'tasks',
        component: ViewTasksComponent,
      },

      {
        path: 'add-task',
        component: AddTaskComponent,
      },

      {
        path: 'task/:cid',
        component: UpdateTaskComponent,
      },

    ],
  },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
