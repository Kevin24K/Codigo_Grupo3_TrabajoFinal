import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { RouterLink } from '@angular/router';
import { Recompensa } from '../../../models/Recompensa';
import { RecompensaService } from '../../../services/recompensa-service';

@Component({
  selector: 'app-recompensalistar',
  imports: [CommonModule, RouterLink, MatTableModule, MatButtonModule, MatIconModule],
  templateUrl: './recompensalistar.html',
  styleUrl: './recompensalistar.css',
})
export class Recompensalistar implements OnInit {
  dataSource = new MatTableDataSource<Recompensa>();
  displayedColumns: string[] = [
    'idRecompensa',
    'nombreRecompensa',
    'descripcion',
    'tipoRecompensa',
    'puntosValor',
    'editar',
    'eliminar',
  ];

  constructor(private rS: RecompensaService) {}

  ngOnInit(): void {
    this.rS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });

    this.rS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
  }

  eliminar(id: number) {
    if (confirm('¿Deseas eliminar esta recompensa?')) {
      console.log('Intentando eliminar ID:', id);
      this.rS.delete(id).subscribe({
        next: () => {
          this.rS.list().subscribe((data) => this.rS.setList(data));
        },
        error: (err) => {
          console.error('Error al eliminar:', err);
          alert('No se pudo eliminar el registro dado que está en uso.');
        },
      });
    }
  }
}
