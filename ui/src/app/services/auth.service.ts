import {Injectable} from '@angular/core';

import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import 'rxjs/add/observable/of';
import "rxjs/add/operator/map";
import 'rxjs/add/operator/catch';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {Auth} from "../common/models/user.model";

@Injectable()
export class AuthService implements CanActivate {

  constructor(private router: Router, private http: HttpClient) {
  }

  authenticate(login, password): Observable<boolean> {
    const request = {username: login, password: password};
   // console.log('Auth', request);
    return this.http.post('/api/auth/', request).map(result => {
     if(result['data'].token === null)
       return false;
      localStorage.setItem('auth', JSON.stringify(result['data']));
      return true;
    }).catch(() => {
      return Observable.of(false);
    });
  }

  logout() {
    localStorage.removeItem('auth');
    this.router.navigate(['/auth']);
  }

  getAuth(): Auth {
    return JSON.parse(localStorage.getItem('auth')) as Auth;
  }

  isAuthenticated() {
    const auth = JSON.parse(localStorage.getItem('auth')) as Auth;
    return auth !== null;
  }


  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const authenticated = this.isAuthenticated();
    if (!authenticated) {
      this.router.navigate(['auth']);
    }
    return authenticated;
  }

}
