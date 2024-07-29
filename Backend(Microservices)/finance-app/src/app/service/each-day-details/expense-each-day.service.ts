import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ExpensesEachDayService {

  constructor(private http:HttpClient) { }


  private apiExpenseEachDay='http://localhost:8082/api/expenses/getAllExpenses/';

  private apiExpensesEachDayAmount='http://localhost:8082/api/expenses/getAllExpensesAmount/';

  private apiSavingsEachDay='http://localhost:8083/api/saving/getAllSavings/'

  private apiSavingsEachDayAmount='http://localhost:8083/api/saving/getSavingAmount/';

  //all information about the expenses on the given date as per category
  getNeedsExpensesEachDay(yearOfExpenseEntered:number,monthOfExpenseEntered:number,dayofExpenseEntered:number){
    const yearmonth = `${yearOfExpenseEntered}-${monthOfExpenseEntered.toString().padStart(2, '0')}`;

    return this.http.get(this.apiExpenseEachDay+yearmonth+'/'+dayofExpenseEntered+'/'+'NEEDS');
  }

  getWantsExpensesEachDay(yearOfExpenseEntered:number,monthOfExpenseEntered:number,dayofExpenseEntered:number){
    const yearmonth = `${yearOfExpenseEntered}-${monthOfExpenseEntered.toString().padStart(2, '0')}`;
    return this.http.get(this.apiExpenseEachDay+yearmonth+'/'+dayofExpenseEntered+'/'+'WANTS');
  }

  getSavingsExpensesEachDay(yearOfExpenseEntered:number,monthOfExpenseEntered:number,dayofExpenseEntered:number){
    const yearmonth = `${yearOfExpenseEntered}-${monthOfExpenseEntered.toString().padStart(2, '0')}`;
    return this.http.get(this.apiSavingsEachDay+yearmonth+'/'+dayofExpenseEntered);
  }

  
  //total expenses amount on the given date as per category
  getNeedsExpensesAmountEachDay(yearOfExpenseEntered:number,monthOfExpenseEntered:number,dayofExpenseEntered:number){
    const yearmonth = `${yearOfExpenseEntered}-${monthOfExpenseEntered.toString().padStart(2, '0')}`;

    return this.http.get(this.apiExpensesEachDayAmount+yearmonth+'/'+dayofExpenseEntered+'/'+'NEEDS');
  }

  getWantsExpensesAmountEachDay(yearOfExpenseEntered:number,monthOfExpenseEntered:number,dayofExpenseEntered:number){
    const yearmonth = `${yearOfExpenseEntered}-${monthOfExpenseEntered.toString().padStart(2, '0')}`;

    return this.http.get(this.apiExpensesEachDayAmount+yearmonth+'/'+dayofExpenseEntered+'/'+'WANTS');
  }

  getSavingsExpensesAmountEachDay(yearOfExpenseEntered:number,monthOfExpenseEntered:number,dayofExpenseEntered:number){
    const yearmonth = `${yearOfExpenseEntered}-${monthOfExpenseEntered.toString().padStart(2, '0')}`;

    return this.http.get(this.apiSavingsEachDayAmount+yearmonth+'/'+dayofExpenseEntered);
  }

}
