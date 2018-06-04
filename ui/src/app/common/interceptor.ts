import {
  HttpErrorResponse, HttpEvent, HttpHandler,
  HttpInterceptor, HttpRequest, HttpResponse
} from '@angular/common/http';
import {Router} from '@angular/router';
import {Injectable} from '@angular/core';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/observable/empty';
import {Observable} from 'rxjs/Observable';
import {Auth} from "./models/user.model";

export const AUTH_HEADER_NAME = "Authorization";

@Injectable()
export class SecurityHttpInterceptor implements HttpInterceptor {


  constructor(private router: Router) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    request = request.clone({
      setHeaders: {
        Authorization: SecurityHttpInterceptor.getToken()
      }
    });
    return next.handle(request);
  }


  private static getToken(): string {
    const auth = JSON.parse(localStorage.getItem('auth')) as Auth;
    console.log('foundToken', auth);
    return auth ? auth.token : '';
  }

  private logout() {
    console.log('Logging out.');
    localStorage.removeItem('auth');
    this.router.navigate(['/auth']);
  }
}
