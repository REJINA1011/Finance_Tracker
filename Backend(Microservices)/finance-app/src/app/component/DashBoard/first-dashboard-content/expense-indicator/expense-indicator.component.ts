import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-expense-indicator',
  standalone: true,
  imports: [],
  templateUrl: './expense-indicator.component.html',
  styleUrl: './expense-indicator.component.css'
})
export class ExpenseIndicatorComponent {
  @Input() level: number = 50;
}
