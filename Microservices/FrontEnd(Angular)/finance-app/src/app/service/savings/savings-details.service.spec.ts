import { TestBed } from '@angular/core/testing';

import { SavingsDetailsService } from './savings-details.service';

describe('SavingsDetailsService', () => {
  let service: SavingsDetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SavingsDetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
