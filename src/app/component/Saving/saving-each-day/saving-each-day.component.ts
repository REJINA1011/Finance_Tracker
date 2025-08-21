import { Component } from '@angular/core';
import { ExpensesEachDayService } from '../../../service/each-day-details/expense-each-day.service';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-saving-each-day',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './saving-each-day.component.html',
  styleUrl: './saving-each-day.component.css'
})
export class SavingEachDayComponent {
  savings: any = {};
  today: Date = new Date();
  constructor(private savingsEachDay: ExpensesEachDayService) { }

  ngOnInit(): void {

    const yearOfExpenseEntered = this.today.getFullYear();
    const monthOfExpenseEntered = this.today.getMonth() + 1;
    const dayofExpenseEntered = this.today.getDate();

    this.savingsEachDay.getSavingsExpensesEachDay(yearOfExpenseEntered, monthOfExpenseEntered, dayofExpenseEntered).subscribe(
      (response) => {
        this.savings = response;
      }
    )
  }
}
