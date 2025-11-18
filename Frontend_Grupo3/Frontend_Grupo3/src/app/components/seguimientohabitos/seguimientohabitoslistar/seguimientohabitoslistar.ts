import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, ActivatedRoute } from '@angular/router';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

import { SeguimientoHabitos } from '../../../models/SeguimientoHabitos';
import { SeguimientoHabitoService } from '../../../services/seguimientohabitos-service';

@Component({
  selector: 'app-seguimientohabitoslistar',
  standalone: true,
  imports: [CommonModule, RouterLink, MatTableModule, MatButtonModule, MatIconModule],
  templateUrl: './seguimientohabitoslistar.html',
  styleUrls: ['./seguimientohabitoslistar.css'],
})
export class SeguimientoHabitosListar implements OnInit {
  dataSource: MatTableDataSource<SeguimientoHabitos> = new MatTableDataSource();

  displayedColumns: string[] = [
    'fechaSeguimiento',
    'completado',
    'calidadEjecucion',
    'notas',
    'editar',
    'eliminar',
  ];

  idHabito: number = 0;

  constructor(private sS: SeguimientoHabitoService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.idHabito = this.route.parent?.snapshot.params['idHabito'];

    this.sS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(
        data.filter((x) => x.idHabito.idHabitos == this.idHabito)
      );
    });

    this.sS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(
        data.filter((x) => x.idHabito.idHabitos == this.idHabito)
      );
    });
  }

  eliminar(id: number) {
    if (confirm('¿Deseas eliminar este seguimiento?')) {
      this.sS.delete(id).subscribe({
        next: () => {
          this.sS.list().subscribe((data) => this.sS.setList(data));
        },
        error: () => {
          alert('No se pudo eliminar el registro debido a que está en uso.');
        },
      });
    }
  }
}
