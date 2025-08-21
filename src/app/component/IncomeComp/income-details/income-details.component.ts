import { Component, OnInit } from '@angular/core';
import { IncomeServicesService } from '../../../service/income/income-services.service';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-income-details',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './income-details.component.html',
  styleUrl: './income-details.component.css'
})
export class IncomeDetailsComponent implements OnInit {
  incomeList: any = {};
  today: Date = new Date();
  reports: any = {};
  selectedDays: number = 7;

  constructor(private incomeLists: IncomeServicesService) { }

  getReports(days: number): void {
    this.incomeLists.getReportsForLastDays(days).subscribe((data: any) => {
      this.reports = data;
    });
  }

  getTotalIncome(): number {
    if (this.reports && this.reports.length > 0) {
      return this.reports.reduce((sum: any, income: { amount: any; }) => sum + income.amount, 0);
    }
    return 0;
  }
  ngOnInit(): void {
    this.getReports(this.selectedDays);

    // const yearOfExpenseEntered = this.today.getFullYear();
    // const monthOfExpenseEntered = this.today.getMonth() + 1;

    // // this.incomeLists.getIncomeListsOnTheDate(yearOfExpenseEntered, monthOfExpenseEntered).subscribe(
    // //   (response: any) => {
    // //     console.log("From response" + response);
    // //     this.incomeList = response;
    // //   }
    // // )
  }
}
