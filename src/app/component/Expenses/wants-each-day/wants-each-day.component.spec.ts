import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WantsEachDayComponent } from './wants-each-day.component';

describe('WantsEachDayComponent', () => {
  let component: WantsEachDayComponent;
  let fixture: ComponentFixture<WantsEachDayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WantsEachDayComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WantsEachDayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
