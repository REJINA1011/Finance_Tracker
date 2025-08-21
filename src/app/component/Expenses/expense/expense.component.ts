import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { ExpenseFormComponent } from '../expense-form/expense-form.component';
import { ExpenseDetailsComponent } from '../expense-details/expense-details.component';
import { SnackbarService } from '../../../service/ToastService/snackbar.service';
// import { CalenderComponent } from '../calender/calender.component';

@Component({
  selector: 'app-expense',
  standalone: true,
  imports: [RouterModule, ExpenseFormComponent, ExpenseDetailsComponent],
  templateUrl: './expense.component.html',
  styleUrl: './expense.component.css'
})
export class ExpenseComponent {

  constructor(private snackbarService: SnackbarService, private router: Router) { }

  ngOnInit(): void {
    if (history.state && history.state.showSnackbar) {
      this.snackbarService.showMessage('Income Inserted', 'Close');
    }
  }
}
