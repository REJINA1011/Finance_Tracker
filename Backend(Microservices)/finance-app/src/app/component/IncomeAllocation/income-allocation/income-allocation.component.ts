import { Component, OnInit } from '@angular/core';
import { IncomeAllocationsDetailsService } from '../../../service/incomeAllocation/income-allocations-details.service';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';
@Component({
  selector: 'app-income-allocation',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './income-allocation.component.html',
  styleUrl: './income-allocation.component.css'
})
export class IncomeAllocationComponent implements OnInit {
  form!: FormGroup;
  incomeAllocationList: any;
  constructor(private fb: FormBuilder, private allocationLists: IncomeAllocationsDetailsService) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      month: ['']
    });
  }

  onMonthChange(event: Event): void {
    const input = event.target as HTMLInputElement;
    const selectedDate = new Date(input.value);
    const month = selectedDate.getMonth() + 1; // Months are zero-indexed
    const year = selectedDate.getFullYear();
    this.invokeMethod(month, year);
  }

  invokeMethod(month: number, year: number): void {

    this.allocationLists.generateIncomeAllocations(year, month).subscribe((response: any) => {
      console.log("From response" + response);
      this.incomeAllocationList = response;
    }, (error) => {
      this.incomeAllocationList = null;
    });
  }
}
