import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  errorMessage: string | undefined;
  loginForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private router: Router
  ) {
    this.loginForm = formBuilder.group({
      login: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  ngOnInit(): void {}

  loginUser() {
    this.errorMessage = '';
    if (this.loginForm.invalid) {
      this.errorMessage = 'Mail and/or password is incorrect';
      return;
    }
    this.userService
      .login(this.login?.value, this.password?.value)
      .pipe()
      .subscribe((data) => {
        localStorage.setItem('currentUser', JSON.stringify(data));
        this.router.navigate(['home']);
      });
  }

  get login() {
    return this.loginForm?.get('login');
  }

  get password() {
    return this.loginForm?.get('password');
  }
}
