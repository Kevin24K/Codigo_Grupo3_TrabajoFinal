import { Component, OnInit } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { PromedioEstresDTO } from '../../../models/PromedioEstresDTO';
import { EstresService } from '../../../services/estres-service';
import { CommonModule } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-promedio-estres-ansiedad',
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule,
    MatIconModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    RouterLink
  ],
  templateUrl: './promedio-estres-ansiedad.html',
  styleUrls: ['./promedio-estres-ansiedad.css']
})
export class PromedioEstresAnsiedad implements OnInit {

  displayedColumns: string[] = [
    'nombreUsuario',
    'promedioEstres',
    'promedioAnsiedad'
  ];

  dataSource: MatTableDataSource<PromedioEstresDTO> = new MatTableDataSource();

  constructor(private estresService: EstresService) {}

  ngOnInit(): void {
    this.estresService.promedioEstresTodosUsuarios().subscribe({
      next: (data) => {
        this.dataSource = new MatTableDataSource(data);
      },
      error: (err) => {
        console.error('Error cargando promedios de estrés/ansiedad', err);
      }
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value.trim().toLowerCase();
    this.dataSource.filter = filterValue;

    this.dataSource.filterPredicate = (data: PromedioEstresDTO, filter: string) => {
      return data.nombreUsuario.toLowerCase().includes(filter);
    };
  }
}
