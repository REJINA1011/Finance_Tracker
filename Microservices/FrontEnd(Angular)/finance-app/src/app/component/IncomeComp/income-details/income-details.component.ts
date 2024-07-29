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
  constructor(private incomeLists: IncomeServicesService) { }

  ngOnInit(): void {

    const yearOfExpenseEntered = this.today.getFullYear();
    const monthOfExpenseEntered = this.today.getMonth() + 1;

    this.incomeLists.getIncomeListsOnTheDate(yearOfExpenseEntered, monthOfExpenseEntered).subscribe(
      (response: any) => {
        console.log("From response" + response);
        this.incomeList = response;
      }
    )
  }
}
