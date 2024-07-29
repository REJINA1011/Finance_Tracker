import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class IncomeAllocationsDetailsService {

  constructor(private http: HttpClient) { }

  private incomeAllocationGenerateApi = "http://localhost:8084/api/incomeAllocator/addDetails/";

  generateIncomeAllocations(yearOfExpenseEntered: number, monthOfExpenseEntered: number) {
    const yearmonth = `${yearOfExpenseEntered}-${monthOfExpenseEntered.toString().padStart(2, '0')}`;

    return this.http.get(this.incomeAllocationGenerateApi + yearmonth);
  }
}
