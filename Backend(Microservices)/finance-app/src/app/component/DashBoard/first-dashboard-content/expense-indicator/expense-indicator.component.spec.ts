import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExpenseIndicatorComponent } from './expense-indicator.component';

describe('ExpenseIndicatorComponent', () => {
  let component: ExpenseIndicatorComponent;
  let fixture: ComponentFixture<ExpenseIndicatorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ExpenseIndicatorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExpenseIndicatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
