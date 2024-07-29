import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FirstDashboardContentComponent } from './first-dashboard-content.component';

describe('FirstDashboardContentComponent', () => {
  let component: FirstDashboardContentComponent;
  let fixture: ComponentFixture<FirstDashboardContentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FirstDashboardContentComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FirstDashboardContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
