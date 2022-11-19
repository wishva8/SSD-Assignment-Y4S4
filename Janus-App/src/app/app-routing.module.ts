import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './auth/auth-guard.guard';
import { LoginComponent } from './components/login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MainComponent } from './main/main.component';
import { Role } from './entity/role';
import { MessageComponent } from './components/message/message.component';
import { AttachmentComponent } from './components/attachment/attachment.component';
import { ProfileComponent } from './components/profile/profile.component';
import { MessageListComponent } from './components/message/message-list/message-list.component';



const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {
    path: '', component: MainComponent,
    children: [
   
      {
        path: 'dashboard',
        component: DashboardComponent,
        canActivate: [AuthGuard],
        data: { roles: [Role.ROLE_MANAGER, Role.ROLE_WORKER] }
      }, 

      {
        path: 'message',
        component: MessageComponent,
        canActivate: [AuthGuard],
        data: { roles: [Role.ROLE_MANAGER, Role.ROLE_WORKER] }
      }, 

      {
        path: 'attachments',
        component: AttachmentComponent,
        canActivate: [AuthGuard],
        data: { roles: [ Role.ROLE_MANAGER] }
      }, 

      {
        path: 'profile',
        component: ProfileComponent,
        canActivate: [AuthGuard],
        data: { roles: [ Role.ROLE_MANAGER, Role.ROLE_WORKER] }
      }, 

      {
        path: 'message-list',
        component: MessageListComponent,
        canActivate: [AuthGuard],
        data: { roles: [ Role.ROLE_MANAGER, Role.ROLE_WORKER ] }
      }, 


    ]
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

