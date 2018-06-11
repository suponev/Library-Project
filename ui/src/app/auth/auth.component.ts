import {Component, OnInit} from '@angular/core';
import {AuthService} from "../services/auth.service";
import {UserService} from "../services/user.service";
import {Router} from "@angular/router";

import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {


  public form: FormGroup;

  constructor(private router: Router,
              private userService: UserService,
              private authService: AuthService,
              private fb: FormBuilder,) {
    this.form = fb.group({
      login: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  ngOnInit() {
  }

  logIn() {
    if (this.authService.isAuthenticated()) {
      this.authService.logout();
    }
    this.authService.authenticate(this.form.value.login, this.form.value.password).subscribe((res: boolean) => {
        if (res) {
          this.router.navigate(['feed'])
        }
      }
    );
  }


  logOut() {
    this.authService.logout();
  }

  test() {
    this.userService.test().subscribe();
  }
}
