import {Injectable} from '@angular/core';

import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import 'rxjs/add/observable/of';
import "rxjs/add/operator/map";
import 'rxjs/add/operator/catch';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {Auth} from "../common/models/user.model";

@Injectable()
export class UserService {

  constructor(private http: HttpClient) {
  }

  public test(): Observable<any> {
    console.log('test');
    return this.http.get('/api/user/').map(res => res['data']);
  }
}


