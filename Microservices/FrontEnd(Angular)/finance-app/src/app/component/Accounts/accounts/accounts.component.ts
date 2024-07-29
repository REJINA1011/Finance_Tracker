import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AccountsDetailsService } from '../../../service/accounts/accounts-details.service';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-accounts',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './accounts.component.html',
  styleUrl: './accounts.component.css'
})
export class AccountsComponent implements OnInit {
  form!: FormGroup;
  accountLists: any;
  needsDeviation!: number;
  savingsDeviation!: number;
  wantsDeviation!: number;
  today: Date = new Date();
  errorMessge!: string;
  constructor(private fb: FormBuilder, private accountList: AccountsDetailsService) { }

  ngOnInit(): void {
    const currentYear = this.today.getMonth() + 1
    const currentMonth = this.today.getFullYear();
    this.form = this.fb.group({
      month: ['']
    });
  }

  onMonthChange(event: Event): void {
    const input = event.target as HTMLInputElement;
    const selectedDate = new Date(input.value);
    const month = selectedDate.getMonth() + 1;
    const year = selectedDate.getFullYear();

    this.invokeMethod(month, year);
  }

  invokeMethod(month: number, year: number): void {
    console.log(month, year);
    this.accountList.getAccountList(year, month).subscribe((response: any) => {
      console.log("From response" + response);
      this.accountLists = response;
      this.needsDeviation = response.allocatedNeeds - response.spentOnNeeds;
      this.savingsDeviation = response.allocatedSavings - response.spendOnSavings;
      this.wantsDeviation = response.allocatedWants - response.spentOnWants;
    }, (error) => {
      this.accountLists = null;
    });
  }
}
