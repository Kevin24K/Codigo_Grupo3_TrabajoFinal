import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, ActivatedRoute } from '@angular/router';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { ObjetivosRecompensas } from '../../../models/ObjetivosRecompensas';
import { ObjetivosRecompensasService } from '../../../services/objetivosrecompensas-service';

@Component({
  selector: 'app-objetivosrecompensaslistar',
  imports: [CommonModule, RouterLink, MatTableModule, MatButtonModule, MatIconModule],
  templateUrl: './objetivosrecompensaslistar.html',
  styleUrl: './objetivosrecompensaslistar.css',
})
export class Objetivosrecompensaslistar implements OnInit {
  dataSource: MatTableDataSource<ObjetivosRecompensas> = new MatTableDataSource();

  displayedColumns: string[] = ['fechaObtencion','Recompensa', 'Objetivo', 'editar', 'eliminar'];

  constructor(private orS: ObjetivosRecompensasService) {}

  ngOnInit(): void {
    this.orS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });

    this.orS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
  }

  eliminar(id: number) {
    if (confirm('¿Deseas eliminar este registro?')) {
      console.log('Intentando eliminar ID:', id);
      this.orS.delete(id).subscribe({
        next: () => {
          this.orS.list().subscribe((data) => this.orS.setList(data));
        },
        error: (err) => {
          console.error('Error al eliminar:', err);
          alert('No se pudo eliminar el registro dado que está en uso.');
        },
      });
    }
  }
}
