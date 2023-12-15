import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent {
  signupForm: FormGroup;

  constructor(fb: FormBuilder,
              private authService: AuthService,
              private router: Router) {
    this.signupForm = fb.group({
      'username': ['', [Validators.required]],
      'password1': ['', [Validators.required]],
      'password2': ['', [Validators.required]]
    })
  }


  onSubmit(){
    if (this.signupForm.invalid) return;

    this.authService.signup(this.signupForm.value).subscribe(_ => {
      this.router.navigateByUrl("/auth/login")
    });
  }
}
