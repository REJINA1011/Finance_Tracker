import { Component } from '@angular/core';
import { LoginComponent } from '../../UserValidation/login/login.component';
import { RouterModule } from '@angular/router';
import { IncomeComponent } from '../../IncomeComp/income/income.component';
@Component({
  selector: 'app-header',
  standalone: true,
  imports: [LoginComponent,RouterModule,IncomeComponent],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  today:Date =new Date();
  year= this.today.getFullYear();
  month=this.today.getMonth();
  day=this.today.getDate();
  username='user1';

}
