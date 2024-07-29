import { Component } from '@angular/core';
import { IncomeFormComponent } from '../income-form/income-form.component';
import { CommonModule } from '@angular/common';
import { IncomeDetailsComponent } from '../income-details/income-details.component';
@Component({
  selector: 'app-income',
  standalone: true,
  imports: [IncomeFormComponent, CommonModule, IncomeDetailsComponent],
  templateUrl: './income.component.html',
  styleUrl: './income.component.css'
})
export class IncomeComponent {

}
