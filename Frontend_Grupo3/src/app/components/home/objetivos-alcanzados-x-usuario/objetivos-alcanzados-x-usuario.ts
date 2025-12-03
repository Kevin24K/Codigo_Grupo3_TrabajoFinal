import { Component, OnInit, ViewChild } from '@angular/core';
import {
  Chart,
  ChartDataset,
  ChartOptions,
  ChartType,
  ChartData,
  registerables
} from 'chart.js';
import { ObjetivosService } from '../../../services/objetivos-service';
import { ObjetivosAlcanzadosDTO } from '../../../models/ObjetivosAlcanzadosDTO';
import { BaseChartDirective } from 'ng2-charts';
import { CommonModule } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

Chart.register(...registerables);

@Component({
  selector: 'app-objetivos-alcanzados-todos-usuario',
  standalone: true,
  imports: [
    CommonModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    BaseChartDirective,
    RouterLink
  ],
  templateUrl: './objetivos-alcanzados-x-usuario.html',
  styleUrls: ['./objetivos-alcanzados-x-usuario.css']
})
export class ObjetivosAlcanzadosXUsuario implements OnInit {
  @ViewChild(BaseChartDirective) chart?: BaseChartDirective;

  allData: ObjetivosAlcanzadosDTO[] = [];
  filteredData: ObjetivosAlcanzadosDTO[] = [];
  hasData = false;
  searchTerm: string = '';

  // CHART DATA (corrección de tipos)
  barChartLabels: string[] = [];
  barChartType: ChartType = 'bar';
  barChartLegend = true;

  chartData: any = { labels: [], datasets: [] };

  barChartOptions: ChartOptions = {
    responsive: true,
    maintainAspectRatio: false,
    scales: {
      y: {
        beginAtZero: true,
        ticks: { precision: 0 }
      }
    }
  };

  barChartData: ChartDataset<'bar', number[]>[] = [];

  constructor(private objetivosService: ObjetivosService) {}

  ngOnInit(): void {
    this.objetivosService.objetivosAlcanzados().subscribe({
      next: (data) => {
        this.allData = data ?? [];
        this.applyFilter();
      },
      error: (err) => {
        console.error('Error cargando objetivos', err);
        this.allData = [];
        this.applyFilter();
      }
    });
  }

  applyFilter(): void {
    const term = (this.searchTerm || '').trim().toLowerCase();

    if (!term) {
      this.filteredData = [...this.allData];
    } else {
      this.filteredData = this.allData.filter(
        r => (r.nombreUsuario ?? '').toLowerCase().includes(term)
      );
    }

    this.updateChart();
  }

  private updateChart(): void {
    if (!this.filteredData.length) {
      this.hasData = false;
      this.barChartLabels = [];
      this.barChartData = [];
      this.chartData = { labels: [], datasets: [] };
      return;
    }

    this.hasData = true;

    this.barChartLabels = this.filteredData.map(x => x.nombreUsuario);

    this.barChartData = [
      {
        data: this.filteredData.map(x => x.objetivosAlcanzados ?? 0),
        label: 'Objetivos Alcanzados',
        backgroundColor: '#64ffda',
        borderColor: '#64ffda',
        borderWidth: 1
      },
      {
        data: this.filteredData.map(x => x.objetivosNoAlcanzados ?? 0),
        label: 'Objetivos No alcanzados',
        backgroundColor: '#d6e2f0',
        borderColor: '#d6e2f0',
        borderWidth: 1
      }
    ];

    this.chartData = {
      labels: this.barChartLabels,
      datasets: this.barChartData
    };

    setTimeout(() => {
      try {
        this.chart?.update();
      } catch {}
    }, 0);
  }

  clearSearch(): void {
    this.searchTerm = '';
    this.applyFilter();
  }
}
