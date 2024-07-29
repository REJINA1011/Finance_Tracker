import { Component, OnInit } from '@angular/core';
import { ExpensesEachDayService } from '../../../service/each-day-details/expense-each-day.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-wants-each-day',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './wants-each-day.component.html',
  styleUrl: './wants-each-day.component.css'
})
export class WantsEachDayComponent implements OnInit {
  expenses: any = {};
  today: Date = new Date();
  constructor(private expensedata: ExpensesEachDayService) { }

  ngOnInit(): void {
    const yearOfExpenseEntered = this.today.getFullYear();
    const monthOfExpenseEntered = this.today.getMonth() + 1;
    const dayofExpenseEntered = this.today.getDate();

    this.expensedata.getWantsExpensesEachDay(yearOfExpenseEntered, monthOfExpenseEntered, dayofExpenseEntered).subscribe(
      (response: any) => {
        console.log("From response" + response);
        this.expenses = response;
        console.log("expense value" + this.expenses);
      }
    )
  }

}
