import { Component, OnInit } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { UsuariosHabitosDTO } from '../../../models/UsuariosHabitosDTO';
import { ReportesSeguimientoService } from '../../../services/reportes-seguimiento-service';
import { MatIconModule } from '@angular/material/icon';
import { CommonModule } from '@angular/common';
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-habitoscompletadoslistar',
  standalone: true,
  imports: [CommonModule, MatTableModule, MatIconModule, RouterLink],
  templateUrl: './habitoscompletadoslistar.html',
  styleUrls: ['./habitoscompletadoslistar.css'],
})
export class HabitosCompletadosListar implements OnInit {
  
  dataSource: MatTableDataSource<UsuariosHabitosDTO> = new MatTableDataSource();
  
  // Columnas: nombreHabito (de UsuariosHabitosDTO), nombreUsuario (de UsuariosHabitosDTO)
  displayedColumns: string[] = ['nombreHabito', 'nombreUsuario'];

  constructor(private rS: ReportesSeguimientoService) {}

  ngOnInit(): void {
    this.rS.getHabitosCompletados().subscribe({
      next: (data) => {
        this.dataSource = new MatTableDataSource(data);
      },
      error: (err) => {
        console.error('Error al cargar hábitos completados:', err);
      },
    });
  }
}