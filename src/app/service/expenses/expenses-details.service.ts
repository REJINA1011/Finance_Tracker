import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ExpensesDetailsService {

  constructor(private http: HttpClient) { }

  private apiExpensesList = 'http://localhost:8082/api/expenses/getAllExpenses/';

  private apiAddExpenses = 'http://localhost:8082/api/expenses/addExpenseDetails/';

  private reportUrl = 'http://localhost:8082/api/expenses/reports';

  getExpenseList(yearOfExpenseEntered: number, monthOfExpenseEntered: number) {
    const yearmonth = `${yearOfExpenseEntered}-${monthOfExpenseEntered.toString().padStart(2, '0')}`;

    return this.http.get(this.apiExpensesList + yearmonth + "/" + localStorage.getItem("userId"));
  }
  getAllExpense(id: number) {
    return this.http.get(this.apiExpensesList + id);
  }
  getReportsForLastDays(days: number) {
    return this.http.get(this.reportUrl + "/" + localStorage.getItem("userId") + '/' + days);
  }

  addExpense(data: any, email: string | null) {
    return this.http.post(this.apiAddExpenses + email, data);
  }
}

