import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { ValidationsService } from '../../../service/validation/validations.service';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { SnackbarService } from '../../../service/ToastService/snackbar.service';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {
  registerForm: FormGroup;
  userId: any;
  constructor(private snackbarService: SnackbarService, private formBuilder: FormBuilder, private getService: ValidationsService, private router: Router) {
    this.registerForm = this.formBuilder.group({
      "username": ['', Validators.required],
      "email": ['', Validators.required],
      "password": ['', Validators.required],
    });
  }

  onRegistrationSubmit() {
    this.getService.register(this.registerForm.value).subscribe(response => {
      this.showSnackbarRegistration();
      this.router.navigate(['']);
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
    const snackbarRef = this.snackbarService.showMessage("Registration failed.Please fill the form again", 'Undo');

    snackbarRef.onAction().subscribe(() => {
      console.log('Action button clicked with error!');
    });
  }
}


