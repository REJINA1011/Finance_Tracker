import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AccountsDetailsService {

  constructor(private http: HttpClient) { }

  private apiAccountsList = 'http://localhost:8085/api/accounts/addDetails/';

  getAccountList(yearOfExpenseEntered: number, monthOfExpenseEntered: number) {
    const yearmonth = `${yearOfExpenseEntered}-${monthOfExpenseEntered.toString().padStart(2, '0')}`;

    return this.http.get(this.apiAccountsList + yearmonth);
  }
}
