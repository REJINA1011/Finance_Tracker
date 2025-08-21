import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { SavingFormComponent } from '../saving-form/saving-form.component';
import { SavingDetailsComponent } from '../saving-details/saving-details.component';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-saving',
  standalone: true,
  imports: [RouterModule, SavingFormComponent, SavingDetailsComponent, CommonModule],
  templateUrl: './saving.component.html',
  styleUrl: './saving.component.css'
})
export class SavingComponent {

}
