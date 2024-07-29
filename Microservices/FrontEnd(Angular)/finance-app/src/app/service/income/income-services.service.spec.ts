import { TestBed } from '@angular/core/testing';

import { IncomeServicesService } from '../income/income-services.service';

describe('IncomeServicesService', () => {
  let service: IncomeServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IncomeServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
