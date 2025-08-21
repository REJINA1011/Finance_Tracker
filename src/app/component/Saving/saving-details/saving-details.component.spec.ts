import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SavingDetailsComponent } from './saving-details.component';

describe('SavingDetailsComponent', () => {
  let component: SavingDetailsComponent;
  let fixture: ComponentFixture<SavingDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SavingDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SavingDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
