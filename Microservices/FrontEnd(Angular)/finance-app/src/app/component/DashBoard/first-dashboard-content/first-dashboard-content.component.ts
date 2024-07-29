import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { DailyExpensesComponent } from './daily-expenses/daily-expenses.component';
// import { ExpensesOfEachDayComponent } from '../../Expenses/expenses-each-day/expenses-of-each-day.component';
// import { ExpensesEachDayService } from '../../../service/expense-each-day.service';
// import { WantsEachDayComponent } from '../../Expenses/wants-each-day/wants-each-day.component';
import { MonthlyChartsComponent } from './monthly-charts/monthly-charts.component';
@Component({
  selector: 'app-first-dashboard-content',
  standalone: true,
  imports: [RouterModule, DailyExpensesComponent, MonthlyChartsComponent],
  templateUrl: './first-dashboard-content.component.html',
  styleUrl: './first-dashboard-content.component.css'
})
export class FirstDashboardContentComponent {
  // constructor(private expenseService: ExpensesEachDayService) {

  // }

  // public needsValue: any; // Example value
  // public wantsValue: any;  // Example value
  // public savingValue: any;
  // today: Date = new Date();

  // ngOnInit(): void {
  //   const yearOfExpenseEntered = this.today.getFullYear();
  //   const monthOfExpenseEntered = this.today.getMonth() + 1;
  //   const dayofExpenseEntered = this.today.getDate();

  //   this.expenseService.getNeedsExpensesAmountEachDay(yearOfExpenseEntered, monthOfExpenseEntered, dayofExpenseEntered).subscribe(
  //     (response) => {
  //       console.log("From response" + response);
  //       this.needsValue = response;
  //     });

  //   this.expenseService.getWantsExpensesAmountEachDay(yearOfExpenseEntered, monthOfExpenseEntered, dayofExpenseEntered).subscribe(
  //     (response) => {
  //       console.log("From response" + response);
  //       this.wantsValue = response;
  //     });

  //   this.expenseService.getSavingsExpensesAmountEachDay(yearOfExpenseEntered, monthOfExpenseEntered, dayofExpenseEntered).subscribe(
  //     (response) => {
  //       console.log("From response" + response);
  //       this.savingValue = response;
  //     });
  // }


  // Initialize with current date and time

}
