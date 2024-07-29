import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ExpensesDetailsService } from '../../../service/expenses/expenses-details.service';

@Component({
  selector: 'app-expense-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './expense-form.component.html',
  styleUrl: './expense-form.component.css'
})
export class ExpenseFormComponent {
  myForm: FormGroup;
  submittedName: string = '';
  constructor(private formBuilder: FormBuilder, private getService: ExpensesDetailsService) {
    this.myForm = this.formBuilder.group({
      "category": ['', Validators.required],
      "description": ['', Validators.required],
      "amount": [0, Validators.required]
    });
  }
  selectCategory(category: string) {
    this.myForm.get('category')?.setValue(category);
  }

  onSubmit() {
    this.submittedName = this.myForm.get('needs')?.value;
    if (this.myForm.valid) {
      this.getService.addExpense(this.myForm.value).subscribe((response) => {
        console.log('Response from API:', response);
      });
    } else {
      console.error("Invalid Form");
    }
  }

}
