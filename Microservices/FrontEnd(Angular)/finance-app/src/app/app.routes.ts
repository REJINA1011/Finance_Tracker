import { Routes } from '@angular/router';
import { LoginComponent } from './component/UserValidation/login/login.component';

import { DashboardComponent } from './component/DashBoard/dashboard/dashboard.component';
import { ExpenseComponent } from './component/Expenses/expense/expense.component';
import { IncomeComponent } from './component/IncomeComp/income/income.component';
import { SavingComponent } from './component/Saving/saving/saving.component';
import { IncomeAllocationComponent } from './component/IncomeAllocation/income-allocation/income-allocation.component';
import { AccountsComponent } from './component/Accounts/accounts/accounts.component';
import { FirstDashboardContentComponent } from './component/DashBoard/first-dashboard-content/first-dashboard-content.component';
import { ExpensesOfEachDayComponent } from './component/Expenses/expenses-each-day/expenses-of-each-day.component';
import { WantsEachDayComponent } from './component/Expenses/wants-each-day/wants-each-day.component';
import { SavingEachDayComponent } from './component/Saving/saving-each-day/saving-each-day.component';

export const routes: Routes = [{
    path: '',
    component: LoginComponent,
    title: 'Login Page'
},
{
    path: 'dashboard',
    component: DashboardComponent,
    title: 'DashBoard',
    children: [
        {
            path: 'expense',
            component: ExpenseComponent,
        },
        {
            path: 'income',
            component: IncomeComponent,
        },
        {
            path: 'saving',
            component: SavingComponent,
        },
        {
            path: 'income-allocation',
            component: IncomeAllocationComponent,
        },
        {
            path: 'accounts',
            component: AccountsComponent,
        },
        {
            path: 'home',
            component: FirstDashboardContentComponent,
        },
        {
            path: 'expenseEachDay',
            component: ExpensesOfEachDayComponent,
        },
        {
            path: 'expenseWantsEachDay',
            component: WantsEachDayComponent,
        },
        {
            path: 'savingsEachDay',
            component: SavingEachDayComponent,
        },
    ]
},

{
    path: 'income',
    component: IncomeComponent,
    title: 'Incomes'
}
];
