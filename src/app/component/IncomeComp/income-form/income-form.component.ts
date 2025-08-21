import { Component } from '@angular/core';
// import { CalenderComponent } from '../../Expenses/calender/calender.component';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { IncomeDetailsComponent } from '../income-details/income-details.component';
import { IncomeServicesService } from '../../../service/income/income-services.service';
import { SnackbarService } from '../../../service/ToastService/snackbar.service';
@Component({
  selector: 'app-income-form',
  standalone: true,
  imports: [IncomeDetailsComponent, ReactiveFormsModule],
  templateUrl: './income-form.component.html',
  styleUrl: './income-form.component.css'
})
export class IncomeFormComponent {
  myForm: FormGroup;
  submittedName: string = '';
  constructor(private snackbarService: SnackbarService, private formBuilder: FormBuilder, private getService: IncomeServicesService) {
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
      this.getService.addIncomeDetails(this.myForm.value).subscribe((response) => {
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
