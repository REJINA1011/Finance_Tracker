import { Component, OnInit } from '@angular/core';
import { BaseChartDirective } from 'ng2-charts';
import { Chart, registerables } from 'chart.js';
import { UtilsService } from '../../util.services';
// import { FirstDashboardContentComponent } from '../first-dashboard-content.component';
@Component({
  selector: 'app-monthly-charts',
  standalone: true,
  imports: [BaseChartDirective],
  templateUrl: './monthly-charts.component.html',
  styleUrl: './monthly-charts.component.css'
})
export class MonthlyChartsComponent implements OnInit {
  private ctx: any;
  private myLineChart: any;

  private today: Date = new Date();

  constructor(private utilsService: UtilsService) {
    Chart.register(...registerables); // Register Chart.js components
  }
  ngOnInit(): void {
    this.getValuesForChart();
  }

  getValuesForChart(): void {
    const yearOfEntery = this.today.getFullYear();
    const monthOfEntry = this.today.getMonth() + 1;

    let needsAmount: any, wantsAmount: any, savingsAmount: any;

    this.utilsService.getTotalSavingsForTheCurrentMonthYear(yearOfEntery, monthOfEntry).subscribe(amount => {
      savingsAmount = amount;

      // Fetch data from the second API
      this.utilsService.getTotalNeedsForTheCurrentMonthYear(yearOfEntery, monthOfEntry).subscribe(amount => {
        needsAmount = amount;

        // Create the chart once both data are fetched
        this.utilsService.getTotalWantsForTheCurrentMonthYear(yearOfEntery, monthOfEntry).subscribe(amount => {
          wantsAmount = amount;

          // Create the chart once both data are fetched
          this.createChart(wantsAmount, needsAmount, savingsAmount);
        });
      });
    });
  }

  createChart(wantsAmount: any, needsAmount: any, savingsAmount: any): void {
    this.ctx = document.getElementById('myChart') as HTMLCanvasElement;
    this.myLineChart = new Chart(this.ctx, {
      type: 'bar',
      data: {
        labels: this.utilsService.getMonths(1),
        datasets: [{
          label: 'Needs',
          data: [needsAmount], // Example data for 'Needs'
          backgroundColor: ' #292F36',
          barPercentage: 0.5,
          // borderRadius:30,
        },
        {
          label: 'Wants',
          data: [wantsAmount], // Example data for 'Wants'
          backgroundColor: '#588B8B',
          borderColor: 'rgba(54, 162, 235, 1)',
          barPercentage: 0.5,
        },
        {
          label: 'Savings',
          data: [savingsAmount], // Example data for 'Savings'
          backgroundColor: '#445D48',
          borderColor: 'rgba(255, 206, 86, 1)',
          barPercentage: 0.5,
        }
        ]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });
  }
}
