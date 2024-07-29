import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ExpensesOfEachDayComponent } from '../../../Expenses/expenses-each-day/expenses-of-each-day.component';
import { ExpensesEachDayService } from '../../../../service/each-day-details/expense-each-day.service';
import { WantsEachDayComponent } from '../../../Expenses/wants-each-day/wants-each-day.component';
import { ExpenseIndicatorComponent } from '../expense-indicator/expense-indicator.component';
@Component({
  selector: 'app-daily-expenses',
  standalone: true,
  imports: [RouterModule, ExpensesOfEachDayComponent, WantsEachDayComponent, ExpenseIndicatorComponent],
  templateUrl: './daily-expenses.component.html',
  styleUrl: './daily-expenses.component.css'
})
export class DailyExpensesComponent implements OnInit {
  constructor(private expenseService: ExpensesEachDayService) {

  }

  public needsValue: any; // Example value
  public wantsValue: any;  // Example value
  public savingValue: any;
  today: Date = new Date();

  ngOnInit(): void {
    const yearOfExpenseEntered = this.today.getFullYear();
    const monthOfExpenseEntered = this.today.getMonth() + 1;
    const dayofExpenseEntered = this.today.getDate();

    this.expenseService.getNeedsExpensesAmountEachDay(yearOfExpenseEntered, monthOfExpenseEntered, dayofExpenseEntered).subscribe(
      (response) => {
        console.log("From response" + response);
        this.needsValue = response;
      });

    this.expenseService.getWantsExpensesAmountEachDay(yearOfExpenseEntered, monthOfExpenseEntered, dayofExpenseEntered).subscribe(
      (response) => {
        console.log("From response" + response);
        this.wantsValue = response;
      });

    this.expenseService.getSavingsExpensesAmountEachDay(yearOfExpenseEntered, monthOfExpenseEntered, dayofExpenseEntered).subscribe(
      (response) => {
        console.log("From response" + response);
        this.savingValue = response;
      });
  }
}
