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
  today: Date = new Date();

  ngOnInit(): void {

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
