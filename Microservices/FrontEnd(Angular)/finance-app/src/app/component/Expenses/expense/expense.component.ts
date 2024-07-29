import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ExpenseFormComponent } from '../expense-form/expense-form.component';
import { ExpenseDetailsComponent } from '../expense-details/expense-details.component';
// import { CalenderComponent } from '../calender/calender.component';

@Component({
  selector: 'app-expense',
  standalone: true,
  imports: [RouterModule, ExpenseFormComponent, ExpenseDetailsComponent],
  templateUrl: './expense.component.html',
  styleUrl: './expense.component.css'
})
export class ExpenseComponent {

}
