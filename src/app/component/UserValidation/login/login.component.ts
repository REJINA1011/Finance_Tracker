
import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { ValidationsService } from '../../../service/validation/validations.service';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

import { SnackbarService } from '../../../service/ToastService/snackbar.service';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  loginForm: FormGroup;
  registerForm: FormGroup;
  userId: any;
  // submittedName: string = '';
  constructor(private snackbarService: SnackbarService, private formBuilder: FormBuilder, private getService: ValidationsService, private router: Router) {
    this.loginForm = this.formBuilder.group({
      "email": ['', Validators.required],
      "password": ['', Validators.required],
    });
    this.registerForm = this.formBuilder.group({
      "username": ['', Validators.required],
      "email": ['', Validators.required],
      "password": ['', Validators.required],
    });
  }

  onRegistrationSubmit() {
    this.getService.register(this.registerForm.value).subscribe(response => {
      console.log('Registration successful', response);
      this.router.navigate(['']);
    }, error => {
      console.error('Registration failed', error);
    });
  }

  onLoginSubmit() {
    this.getService.login(this.loginForm.value).subscribe(response => {
      console.log('Login successful', response);
      this.router.navigate(['/dashboard/home'], { state: { showSnackbar: true } });
    }, error => {
      this.showSnackbarError();
    });
  }

  showSnackbarRegistration() {
    const snackbarRef = this.snackbarService.showMessage("Registerd Successfully", 'Undo');

    snackbarRef.onAction().subscribe(() => {
      console.log('Action button clicked!');
    });
  }
  showSnackbarError() {
    const snackbarRef = this.snackbarService.showMessage("Username or Password incorrect", 'Undo');

    snackbarRef.onAction().subscribe(() => {
      console.log('Action button clicked with error!');
    });
  }

}
