import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SavingsDetailsService {

  constructor(private http: HttpClient) { }

  private savingsApi = 'http://localhost:8083/api/saving/getAllSavings/'
  private apiAddSavings = 'http://localhost:8083/api/saving/addSavingDetails';

  getSavingsList(yearOfExpenseEntered: number, monthOfExpenseEntered: number) {
    const yearmonth = `${yearOfExpenseEntered}-${monthOfExpenseEntered.toString().padStart(2, '0')}`;

    return this.http.get(this.savingsApi + yearmonth);
  }

  addSavings(data: any) {
    return this.http.post(this.apiAddSavings, data);
  }
}
