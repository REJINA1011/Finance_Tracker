import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ExpensesDetailsService } from '../../../service/expenses/expenses-details.service';
import { ValidationsService } from '../../../service/validation/validations.service';
import { Router } from '@angular/router';
import { SnackbarService } from '../../../service/ToastService/snackbar.service';

interface User {
  id: number;
  username: string;
  email: string;
  password: string;
  dateOfEntry: string;
}
@Component({
  selector: 'app-expense-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './expense-form.component.html',
  styleUrl: './expense-form.component.css'
})

export class ExpenseFormComponent {
  user: User | undefined;
  myForm: FormGroup;
  submittedName: string = '';
  email: string | null = '';
  constructor(private snackbarService: SnackbarService, private formBuilder: FormBuilder, private getService: ExpensesDetailsService, private getValidationService: ValidationsService) {
    this.myForm = this.formBuilder.group({
      "category": ['', Validators.required],
      "description": ['', Validators.required],
      "amount": [0, Validators.required]
    });
  }
  selectCategory(category: string) {
    this.myForm.get('category')?.setValue(category);
  }
  userId: any;

  onSubmit() {
    if (this.myForm.valid) {
      this.email = localStorage.getItem("email");
      this.getService.addExpense(this.myForm.value, this.email).subscribe((response) => {
        this.showSnackbar();
        setTimeout(() => {
          window.location.reload();
        }, 3000);
      });
    } else {
      console.error("Invalid Form");
    }
  }

  showSnackbar() {
    this.snackbarService.showMessage('Data Inserted', 'Close');
  }

}
