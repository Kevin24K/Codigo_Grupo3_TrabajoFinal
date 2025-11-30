import { Component, OnInit } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { SuenoService } from '../../../services/sueno-service';
import { CommonModule, DatePipe } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { Sueno } from '../../../models/Sueno';
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-buscar-por-umbral-calidad-de-sueno',
  standalone: true,
  imports: [CommonModule,
    MatTableModule,
    MatIconModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    FormsModule, RouterLink],
  providers: [DatePipe],
  templateUrl: './buscar-por-umbral-calidad-de-sueno.html',
  styleUrls: ['./buscar-por-umbral-calidad-de-sueno.css'],
})
export class BuscarPorUmbralCalidadDeSueno implements OnInit{
  displayedColumns: string[] = [
    'idSueno',
    'idUsuario',
    'fechaRegistro',
    'calidadSueno',
    'interrupciones',
    'cafeinaConsumida'
  ];
  dataSource: MatTableDataSource<Sueno> = new MatTableDataSource();
  umbralCalidad: number = 3; // Valor inicial del umbral
  mensajeError: string = '';

  constructor(private sService: SuenoService) {}

  ngOnInit(): void {
    // Carga inicial con el umbral por defecto
    this.buscarSuenos();
  }

  buscarSuenos() {
    this.mensajeError = '';
    // Validación básica del rango del umbral (asumido de 1 a 5)
    if (this.umbralCalidad < 1 || this.umbralCalidad > 5 || this.umbralCalidad === null) {
      this.mensajeError = 'El umbral de calidad debe ser un número entre 1 y 5.';
      this.dataSource = new MatTableDataSource<Sueno>([]);
      return;
    }

    // Llamada al Query
    this.sService.BuscarPorUmbralCalidadDeSueno(this.umbralCalidad).subscribe({
        next: (data) => {
            this.dataSource = new MatTableDataSource(data);
            if (data.length === 0) {
              this.mensajeError = `No se encontraron registros con calidad igual o menor a ${this.umbralCalidad}.`;
            }
        },
        error: (err) => {
            console.error('Error al buscar sueños por umbral:', err);
            this.mensajeError = 'Ocurrió un error al cargar los datos del reporte. Verifique el backend y el endpoint /suenos/calidad-umbral/{umbral}.';
            this.dataSource = new MatTableDataSource<Sueno>([]);
        }
    });
  }
}
