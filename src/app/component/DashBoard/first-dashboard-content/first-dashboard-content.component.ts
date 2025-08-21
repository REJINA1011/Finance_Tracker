import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { DailyExpensesComponent } from './daily-expenses/daily-expenses.component';
// import { ExpensesOfEachDayComponent } from '../../Expenses/expenses-each-day/expenses-of-each-day.component';
// import { ExpensesEachDayService } from '../../../service/expense-each-day.service';
// import { WantsEachDayComponent } from '../../Expenses/wants-each-day/wants-each-day.component';
import { MonthlyChartsComponent } from './monthly-charts/monthly-charts.component';
import { SnackbarService } from '../../../service/ToastService/snackbar.service';
@Component({
  selector: 'app-first-dashboard-content',
  standalone: true,
  imports: [RouterModule, DailyExpensesComponent, MonthlyChartsComponent],
  templateUrl: './first-dashboard-content.component.html',
  styleUrl: './first-dashboard-content.component.css'
})
export class FirstDashboardContentComponent {

  constructor(private snackbarService: SnackbarService) { }

  ngOnInit(): void {
    if (history.state && history.state.showSnackbar) {
      this.snackbarService.showMessage('Login Successful', 'Close');
    }
  }
}
