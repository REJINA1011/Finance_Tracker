import { ComponentFixture, TestBed } from '@angular/core/testing';

import {ExpensesOfEachDayComponent } from './expenses-of-each-day.component';

describe('IncomeOfEachDayComponent', () => {
  let component: ExpensesOfEachDayComponent;
  let fixture: ComponentFixture<ExpensesOfEachDayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ExpensesOfEachDayComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExpensesOfEachDayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
