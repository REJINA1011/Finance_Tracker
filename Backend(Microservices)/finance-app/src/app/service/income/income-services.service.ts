import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class IncomeServicesService {

  constructor(private http: HttpClient) { }

  private apiIncomeList = "http://localhost:8081/api/income/getAllIncomes/";

  private apiAddIncome = 'http://localhost:8081/api/income/addIncomeDetails';

  getIncomeListsOnTheDate(yearOfIncomeEntered: number, monthOfIncomeEntered: number) {
    const yearmonth = `${yearOfIncomeEntered}-${monthOfIncomeEntered.toString().padStart(2, '0')}`;

    return this.http.get(this.apiIncomeList + yearmonth);
  }

  addIncomeDetails(data: any) {
    return this.http.post(this.apiAddIncome, data);
  }
}
