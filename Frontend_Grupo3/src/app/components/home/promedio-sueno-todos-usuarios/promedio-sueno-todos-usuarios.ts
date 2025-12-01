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
    maintainAspectRatio: false,
    plugins: {
      legend: {
        display: true,
        labels: {
          color: '#ffffff', // Texto de leyenda en blanco
          font: {
            size: 14
          }
        }
      },
      tooltip: {
        bodyColor: '#ffffff',
        titleColor: '#ffffff'
      }
    },
    scales: {
      x: {
        ticks: {
          color: '#ffffff' // Etiquetas eje X en blanco
        },
        grid: {
          color: 'rgba(100, 255, 218, 0.1)'
        }
      },
      y: {
        ticks: {
          color: '#ffffff' // Etiquetas eje Y en blanco
        },
        grid: {
          color: 'rgba(100, 255, 218, 0.1)'
        }
      }
    }
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
            backgroundColor: '#64ffda',
            borderColor: '#64ffda',
            borderWidth: 1
          },
          {
            data: data.map((item) => item.promedioInterrupciones),
            label: 'Promedio Interrupciones',
            backgroundColor: '#ffffff',
            borderColor: '#ffffff',
            borderWidth: 1
          },
          {
            data: data.map((item) => item.promedioCalidad),
            label: 'Promedio Calidad',
            backgroundColor: '#b8c1cc',
            borderColor: '#b8c1cc',
            borderWidth: 1
          },
        ];
      } else {
        this.hasData = false;
      }
    });
  }
}