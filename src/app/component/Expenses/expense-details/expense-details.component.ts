import { Component, OnInit } from '@angular/core';
import { ExpensesDetailsService } from '../../../service/expenses/expenses-details.service';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-expense-details',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './expense-details.component.html',
  styleUrl: './expense-details.component.css'
})
export class ExpenseDetailsComponent implements OnInit {


  constructor(private expensesLists: ExpensesDetailsService) {

  }

  expensesList: any = {};
  reports: any = {};
  selectedDays: number = 7;
  today: Date = new Date();

  getReports(days: number): void {
    this.expensesLists.getReportsForLastDays(days).subscribe((data: any) => {
      this.reports = data;
    });
  }
  getTotalIncome(): number {
    if (this.reports && this.reports.length > 0) {
      return this.reports.reduce((sum: any, expense: { amount: any; }) => sum + expense.amount, 0);
    }
    return 0;
  }

  ngOnInit(): void {

    this.getReports(this.selectedDays);
    const yearOfExpenseEntered = this.today.getFullYear();
    const monthOfExpenseEntered = this.today.getMonth() + 1;

    this.expensesLists.getExpenseList(yearOfExpenseEntered, monthOfExpenseEntered).subscribe(
      (response: any) => {
        console.log("From response" + response);
        this.expensesList = response;
      }
    )
  }

}


