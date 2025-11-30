import { Component, OnInit } from '@angular/core';
import {
  Chart,
  ChartDataset,
  ChartOptions,
  ChartType,
  registerables,
  BarController,
} from 'chart.js';
import { SuenoService } from '../../../services/sueno-service';
import { BaseChartDirective, provideCharts, withDefaultRegisterables } from 'ng2-charts';
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from "@angular/router";

Chart.register(...registerables);

@Component({
  selector: 'app-promedio-sueno-todos-usuarios',
  imports: [MatIconModule, BaseChartDirective, RouterLink],
  templateUrl: './promedio-sueno-todos-usuarios.html',
  styleUrl: './promedio-sueno-todos-usuarios.css',
})
export class promedioSuenoTodosUsuarios implements OnInit{
  hasData = false;

  barChartOptions: ChartOptions = {
    responsive: true,
  };
  barChartLabels: string[] = [];
  barChartType: ChartType = 'bar';
  barChartLegend = true;
  barChartData: ChartDataset[] = [];

  constructor(private suenoService: SuenoService) {}

  ngOnInit(): void {
    this.suenoService.promedioSuenoTodosUsuarios().subscribe((data) => {
      if (data.length > 0) {
        this.hasData = true;
        this.barChartLabels = data.map((item) => `Usuario ${item.idUsuario}`);
        this.barChartData = [
          {
            data: data.map((item) => item.promedioHorasDormidas),
            label: 'Promedio Horas Dormidas',
            backgroundColor: ['rgb(54, 162, 235)', 'rgb(84, 192, 255)'],
          },
          {
            data: data.map((item) => item.promedioInterrupciones),
            label: 'Promedio Interrupciones',
            backgroundColor: ['rgb(255, 99, 132)', 'rgb(255, 129, 162)'],
          },
          {
            data: data.map((item) => item.promedioCalidad),
            label: 'Promedio Calidad',
            backgroundColor: ['rgb(75, 192, 192)', 'rgb(105, 222, 222)'],
          },
        ];
      } else {
        this.hasData = false;
      }
    });
  }
}
