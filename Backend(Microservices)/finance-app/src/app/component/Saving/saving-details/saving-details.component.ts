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

  ngOnInit(): void {

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
