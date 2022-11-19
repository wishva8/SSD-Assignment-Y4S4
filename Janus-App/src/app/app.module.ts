import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { JwtInterceptor } from './auth/jwt.interceptor';
import { ErrorInterceptor } from './auth/error.interceptor';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { MainComponent } from './main/main.component';
import { LoginComponent } from './components/login/login.component';
import { HeaderComponent } from './components/shared/header/header.component';
import { FooterComponent } from './components/shared/footer/footer.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UserComponent } from './components/user/user.component';
import { SelectFilterPipe } from './pipes/select-filter.pipe';
import { DateTimeFormatPipe } from './pipes/date-time-format.pipe';

import { FormValidationCommonComponent } from './components/user/form-validation-common/form-validation-common.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSelectModule } from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';

import {
  MatButtonModule,
  MatIconModule,
  MatPaginatorModule,
} from '@angular/material';

import { RolePipe } from './pipes/role.pipe';

import {
  NbCardModule,
  NbDialogModule,
  NbLayoutModule,
  NbThemeModule,
  NbToastrModule,
} from '@nebular/theme';

import { NbEvaIconsModule } from '@nebular/eva-icons';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { MessageComponent } from './components/message/message.component';
import { AttachmentComponent } from './components/attachment/attachment.component';
import { ProfileComponent } from './components/profile/profile.component';
import { MessageListComponent } from './components/message/message-list/message-list.component';

// import {MatButtonModule} from '@angular/material' ;

@NgModule({
  declarations: [
    RolePipe,
    SelectFilterPipe,
    DateTimeFormatPipe,
    AppComponent,
    HeaderComponent,
    FooterComponent,
    MainComponent,
    DashboardComponent,
    LoginComponent,
    UserComponent,
    FormValidationCommonComponent,
    DashboardComponent,
    MainComponent,
    MessageComponent,
    AttachmentComponent,
    ProfileComponent,
    MessageListComponent
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule,
    MatSelectModule,
    MatTableModule,
    MatButtonModule,
    MatIconModule,
    MatPaginatorModule,
    NbLayoutModule,
    NbEvaIconsModule,
    NbThemeModule.forRoot({ name: 'default' }),
    NgMultiSelectDropDownModule.forRoot(),
    NbToastrModule.forRoot(),
    NbDialogModule.forRoot(),
    NbCardModule,
  ],

  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
})

export class AppModule { }
