import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountsTableComponent } from './accounts-table.component';

describe('AccountsTableComponent', () => {
  let component: AccountsTableComponent;
  let fixture: ComponentFixture<AccountsTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AccountsTableComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AccountsTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
