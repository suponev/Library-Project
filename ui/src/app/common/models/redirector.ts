import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {Injectable} from "@angular/core";
import {AuthService} from "../../services/auth.service";

@Injectable()
export class AuthRedirector implements CanActivate {

  constructor(private authService: AuthService, private router: Router) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const authenticated = this.authService.isAuthenticated();
    if (authenticated) {
      this.router.navigate(['']);
    }
    return !authenticated;
  }
}
