import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SavingEachDayComponent } from './saving-each-day.component';

describe('SavingEachDayComponent', () => {
  let component: SavingEachDayComponent;
  let fixture: ComponentFixture<SavingEachDayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SavingEachDayComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SavingEachDayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
