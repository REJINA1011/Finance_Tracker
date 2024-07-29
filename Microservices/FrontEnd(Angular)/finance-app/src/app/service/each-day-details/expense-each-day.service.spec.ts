import { TestBed } from '@angular/core/testing';

import { ExpensesEachDayService } from './expense-each-day.service'


describe('ExpensesEachDayService', () => {
  let service: I;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExpensesEachDayService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
