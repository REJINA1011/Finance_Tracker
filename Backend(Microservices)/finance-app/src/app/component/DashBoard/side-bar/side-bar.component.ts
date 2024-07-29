import { Component } from '@angular/core';
import {ExpenseComponent} from "../../Expenses/expense/expense.component"
import { RouterModule } from '@angular/router';
import { IncomeComponent } from '../../IncomeComp/income/income.component';
import { SavingComponent } from '../../Saving/saving/saving.component';
import { IncomeAllocationComponent } from '../../IncomeAllocation/income-allocation/income-allocation.component';
import { AccountsComponent } from '../../Accounts/accounts/accounts.component';
;
@Component({
  selector: 'app-side-bar',
  standalone: true,
  imports: [ExpenseComponent,RouterModule,IncomeComponent,SavingComponent,IncomeAllocationComponent,AccountsComponent],
  templateUrl: './side-bar.component.html',
  styleUrl: './side-bar.component.css'
})
export class SideBarComponent {
  
}
