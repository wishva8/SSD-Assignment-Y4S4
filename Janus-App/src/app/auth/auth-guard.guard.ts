import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import Swal from 'sweetalert2';
import { AuthenticationService } from '../service/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {


  constructor(private router: Router, private authenticationService: AuthenticationService) { }

  canActivate(route: ActivatedRouteSnapshot) {
    const currentUser = this.authenticationService.currentUserValue;
    if (currentUser !== null && currentUser) {
      if (this.hasRole(route.data.roles, currentUser.roles)) {
        return true;
      } else {
        Swal.fire({
          icon: 'error',
          title: 'You do not have access to this',
        })
        return false;
      }
    }

    this.router.navigate(['/login']);
    return false;
  }

  hasRole(routeRoles, userRoles): boolean {

    for (const routeRole of routeRoles) {
      for (const userRole of userRoles) {
        if (routeRole === userRole) {
          return true;
        }
      }
    }
    return false;
  }

}
