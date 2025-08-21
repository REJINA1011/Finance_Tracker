import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { SavingsDetailsService } from '../../../service/savings/savings-details.service';

@Component({
  selector: 'app-saving-details',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './saving-details.component.html',
  styleUrl: './saving-details.component.css'
})
export class SavingDetailsComponent implements OnInit {

  constructor(private savingsLists: SavingsDetailsService) {

  }
  savingList: any = {};
  today: Date = new Date();
  reports: any = {};
  selectedDays: number = 7;

  getReports(days: number): void {
    this.savingsLists.getReportsForLastDays(days).subscribe((data: any) => {
      this.reports = data;
    });
  }
  getTotalIncome(): number {
    if (this.reports && this.reports.length > 0) {
      return this.reports.reduce((sum: any, saving: { amount: any; }) => sum + saving.amount, 0);
    }
    return 0;
  }

  ngOnInit(): void {

    this.getReports(this.selectedDays);

    const yearOfExpenseEntered = this.today.getFullYear();
    const monthOfExpenseEntered = this.today.getMonth() + 1;

    this.savingsLists.getSavingsList(yearOfExpenseEntered, monthOfExpenseEntered).subscribe(
      (response: any) => {
        console.log("From response" + response);
        this.savingList = response;
      }
    )
  }



}
