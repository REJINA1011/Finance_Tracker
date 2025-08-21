import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { SavingsDetailsService } from '../../../service/savings/savings-details.service';
import { SnackbarService } from '../../../service/ToastService/snackbar.service';
@Component({
  selector: 'app-saving-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './saving-form.component.html',
  styleUrl: './saving-form.component.css'
})
export class SavingFormComponent {
  myForm: FormGroup;
  // submittedName: string = '';
  constructor(private snackbarService: SnackbarService, private formBuilder: FormBuilder, private getService: SavingsDetailsService) {
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
    // this.submittedName = this.myForm.get('needs')?.value;
    if (this.myForm.valid) {
      this.getService.addSavings(this.myForm.value).subscribe((response) => {
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
