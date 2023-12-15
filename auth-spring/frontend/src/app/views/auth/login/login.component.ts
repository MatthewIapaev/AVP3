import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  loginForm: FormGroup;

  constructor(fb: FormBuilder,
              private authService: AuthService,
              private router: Router) {
    this.loginForm = fb.group({
      'username': ['', [Validators.required]],
      'password': ['', [Validators.required]],
      'remember_me': ['', []]
    })
  }

  onSubmit() {
    if (this.loginForm.invalid) return;
    this.authService.logout().subscribe(() => {
      this.authService.login(this.loginForm.value).subscribe(d => {
        this.router.navigateByUrl("/");
      })
    })
  }
}
