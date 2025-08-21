import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MonthlyChartsComponent } from './monthly-charts.component';

describe('MonthlyChartsComponent', () => {
  let component: MonthlyChartsComponent;
  let fixture: ComponentFixture<MonthlyChartsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MonthlyChartsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MonthlyChartsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
