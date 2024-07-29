import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UtilsService {
  constructor(private http: HttpClient) { }

  private totalSavingsApi = "http://localhost:8083/api/saving/getSavingAmounts/";

  private totalNeedsApi = "http://localhost:8082/api/expenses/getAllExpensesAmount/";

  getTotalSavingsForTheCurrentMonthYear(yearOfEntry: number, monthOfEntry: number) {
    const yearmonth = `${yearOfEntry}-${monthOfEntry.toString().padStart(2, '0')}`;

    return this.http.get(this.totalSavingsApi + yearmonth);

  }

  getTotalNeedsForTheCurrentMonthYear(yearOfEntry: number, monthOfEntry: number) {
    const yearmonth = `${yearOfEntry}-${monthOfEntry.toString().padStart(2, '0')}`;

    return this.http.get(this.totalNeedsApi + yearmonth + '/' + 'NEEDS');

  }


  getTotalWantsForTheCurrentMonthYear(yearOfEntry: number, monthOfEntry: number) {
    const yearmonth = `${yearOfEntry}-${monthOfEntry.toString().padStart(2, '0')}`;

    return this.http.get(this.totalNeedsApi + yearmonth + '/' + 'WANTS');
  }

  getMonths(count: number): string[] {
    const months: string[] = [];
    const currentDate = new Date();
    const currentMonth = currentDate.getMonth();

    for (let i = 0; i < count; i++) {
      const nextMonth = (currentMonth + i) % 12;
      months.push(this.getMonthName(nextMonth));
    }

    return months;
  }
  getYears(month: string): number {
    const currentDate = new Date();
    const currentYear = currentDate.getFullYear(); // Note the parentheses to call the method
    return currentYear;
  }

  private getMonthName(monthIndex: number): string {
    const monthNames = [
      'January', 'February', 'March', 'April', 'May', 'June',
      'July', 'August', 'September', 'October', 'November', 'December'
    ];
    return monthNames[monthIndex];
  }


}
