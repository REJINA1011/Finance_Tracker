import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { ExpensesEachDayService } from '../../../../service/each-day-details/expense-each-day.service';

@Component({
  selector: 'app-expense-indicator',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './expense-indicator.component.html',
  styleUrl: './expense-indicator.component.css'
})
export class ExpenseIndicatorComponent {
  @Input() level: number = 50;

  constructor(private expenseService: ExpensesEachDayService) { }

  public needsValue: any; // Example value
  public wantsValue: any;  // Example value
  public savingValue: any;
  today: Date = new Date();

  ngOnInit(): void {
    const yearOfExpenseEntered = this.today.getFullYear();
    const monthOfExpenseEntered = this.today.getMonth() + 1;
    const dayofExpenseEntered = this.today.getDate();

    this.expenseService.getNeedsExpensesEachDay(yearOfExpenseEntered, monthOfExpenseEntered, dayofExpenseEntered).subscribe(
      (response) => {
        console.log("From response" + response);
        this.needsValue = response;
      });
    // this.expenseService.getWantsExpensesEachDay(yearOfExpenseEntered, monthOfExpenseEntered, dayofExpenseEntered).subscribe(
    //   (response) => {
    //     console.log("From response" + response);
    //     this.needsValue = response;
    //   });
    // this.expenseService.getSavingsExpensesEachDay(yearOfExpenseEntered, monthOfExpenseEntered, dayofExpenseEntered).subscribe(
    //   (response) => {
    //     console.log("From response" + response);
    //     this.needsValue = response;
    //   });
  }
}
