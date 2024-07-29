import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ExpensesDetailsService {

  constructor(private http: HttpClient) { }

  private apiExpensesList = 'http://localhost:8082/api/expenses/getAllExpenses/';

  private apiAddExpenses = 'http://localhost:8082/api/expenses/addExpenseDetails';

  getExpenseList(yearOfExpenseEntered: number, monthOfExpenseEntered: number) {
    const yearmonth = `${yearOfExpenseEntered}-${monthOfExpenseEntered.toString().padStart(2, '0')}`;

    return this.http.get(this.apiExpensesList + yearmonth);
  }

  addExpense(data: any) {
    return this.http.post(this.apiAddExpenses, data);
  }
}
