// src/app/components/habitos/habitos-activos-por-usuario/habitos-activos-por-usuario.ts

import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';

import { HabitosService } from '../../../services/habitos-service';
import { HabitosActivosPorUsuarioDTO } from '../../../models/habitos-activos-por-usuario-dto';
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-habitos-activos-por-usuario',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatTableModule,
    MatIconModule,
],
  templateUrl: './habitos-activos-por-usuario.html',
  styleUrls: ['./habitos-activos-por-usuario.css'],
})
export class HabitosActivosPorUsuario implements OnInit {
  form: FormGroup = new FormGroup({});
  dataSource: MatTableDataSource<HabitosActivosPorUsuarioDTO> = new MatTableDataSource();
  
  // Columnas para la tabla
  columnas: string[] = ['nombreHabito', 'nombreUsuario'];
  
  mensaje: string = 'Ingrese el ID de usuario y presione "Buscar"';

  constructor(
    private fb: FormBuilder,
    private hService: HabitosService
  ) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      idUsuario: ['', [Validators.required, Validators.min(1)]],
    });
  }

  buscarHabitos(): void {
    if (this.form.invalid) {
      this.mensaje = 'Por favor, ingrese un ID de usuario válido.';
      this.dataSource = new MatTableDataSource();
      return;
    }

    const id = this.form.value.idUsuario;
    this.mensaje = 'Cargando...';
    this.dataSource = new MatTableDataSource();

    this.hService.HabitosActivosParaUnUsuario(id).subscribe({
      next: (data) => {
        if (data && data.length > 0) {
          this.dataSource = new MatTableDataSource(data);
          this.mensaje = `Hábitos activos encontrados para el usuario ${id}:`;
        } else {
          this.mensaje = `No se encontraron hábitos activos para el usuario con ID ${id}.`;
          this.dataSource = new MatTableDataSource();
        }
      },
      error: (err) => {
        // Manejo de error específico (ej. 404 del backend)
        this.mensaje = 'Error al buscar hábitos. Asegúrese de que el ID de usuario sea correcto.';
        console.error('Error en el reporte:', err);
        this.dataSource = new MatTableDataSource();
      }
    });
  }
}