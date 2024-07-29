import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IncomeAllocationComponent } from './income-allocation.component';

describe('IncomeAllocationComponent', () => {
  let component: IncomeAllocationComponent;
  let fixture: ComponentFixture<IncomeAllocationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [IncomeAllocationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IncomeAllocationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
