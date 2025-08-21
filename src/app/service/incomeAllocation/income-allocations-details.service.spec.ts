import { TestBed } from '@angular/core/testing';

import { IncomeAllocationsDetailsService } from './income-allocations-details.service';

describe('IncomeAllocationsDetailsService', () => {
  let service: IncomeAllocationsDetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IncomeAllocationsDetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
