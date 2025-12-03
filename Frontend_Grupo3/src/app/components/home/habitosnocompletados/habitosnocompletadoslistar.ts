import { Component, OnInit } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { UsuariosHabitosDTO } from '../../../models/UsuariosHabitosDTO';
import { ReportesSeguimientoService } from '../../../services/reportes-seguimiento-service';
import { MatIconModule } from '@angular/material/icon';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-habitosnocompletadoslistar',
  standalone: true,
  imports: [CommonModule, MatTableModule, MatIconModule],
  templateUrl: './habitosnocompletadoslistar.html',
  // Reutilizamos el CSS del otro reporte para mantener la consistencia
  styleUrls: ['../habitoscompletados/habitoscompletadoslistar.css'], 
})
export class HabitosNoCompletadosListar implements OnInit {
  
  dataSource: MatTableDataSource<UsuariosHabitosDTO> = new MatTableDataSource();
  displayedColumns: string[] = ['nombreHabito', 'nombreUsuario'];

  constructor(private rS: ReportesSeguimientoService) {}

  ngOnInit(): void {
    // Llamada al método para Hábitos NO Completados
    this.rS.getHabitosNoCompletados().subscribe({
      next: (data) => {
        this.dataSource = new MatTableDataSource(data);
      },
      error: (err) => {
        console.error('Error al cargar hábitos NO completados:', err);
      },
    });
  }
}