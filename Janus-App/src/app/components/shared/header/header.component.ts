import { AfterViewInit, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StateService } from '../../../service/state.service';
import { AuthenticationService } from 'src/app/service/authentication.service';
import { NbToastrService } from '@nebular/theme';
import { NbMenuService, NbSidebarService } from '@nebular/theme';
import { User } from 'src/app/entity/user';
import { Role } from 'src/app/entity/role';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  errMsg: any;
  selectedProject: any;
  id: number;
  pro: any;
  projects: any;
  isDisabledProject = false;
  userPictureOnly: boolean = false;
  user: any;
  currentUser: User;

  userMenu = [
    // { title: 'Profile' },
    { title: 'Log out' },
  ];
  constructor(
    public router: Router,
    public stateService: StateService,
    private authenticationService: AuthenticationService,
    private toastrService: NbToastrService,
  ) { }

  ngOnInit() {
    // this.projectService.getAll().subscribe(data=> this.projects = data );
    this.id = this.authenticationService.currentUserValue.id;
    this.authenticationService.currentUser.subscribe(x => this.currentUser = x)
  }

  get isAdmin() {
    return (this.currentUser.roles[0] === Role.ROLE_MANAGER);
  }

  logout() {
    this.authenticationService.logout();
  }
}
