import { TestBed } from '@angular/core/testing';

import { ExpensesDetailsService } from './expenses-details.service';

describe('ExpesesDetailsService', () => {
  let service: ExpensesDetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExpensesDetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
