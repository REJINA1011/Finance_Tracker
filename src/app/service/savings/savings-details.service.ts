import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SavingsDetailsService {

  constructor(private http: HttpClient) { }

  private savingsApi = 'http://localhost:8083/api/saving/getSavings/'
  private apiAddSavings = 'http://localhost:8083/api/saving/addSavingDetails/';
  private reportUrl = 'http://localhost:8083/api/saving/reports';

  getSavingsList(yearOfExpenseEntered: number, monthOfExpenseEntered: number) {
    const yearmonth = `${yearOfExpenseEntered}-${monthOfExpenseEntered.toString().padStart(2, '0')}`;

    return this.http.get(this.savingsApi + yearmonth + '/' + localStorage.getItem("userId"));
  }

  addSavings(data: any) {
    return this.http.post(this.apiAddSavings + Number(localStorage.getItem("userId")), data);
  }

  getReportsForLastDays(days: number) {
    return this.http.get(this.reportUrl + "/" + localStorage.getItem("userId") + '/' + days);
  }
}
