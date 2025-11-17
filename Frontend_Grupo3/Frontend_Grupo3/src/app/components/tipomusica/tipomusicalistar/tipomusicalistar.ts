import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { RouterLink } from '@angular/router';
import { TipoMusica } from '../../../models/TipoMusica';
import { TipoMusicaService } from '../../../services/tipomusica-service';

@Component({
  selector: 'app-tipomusicalistar',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink,
    MatTableModule,
    MatButtonModule,
    MatIconModule,       
  ],
  templateUrl: './tipomusicalistar.html',
  styleUrls: ['./tipomusicalistar.css'],
})
export class Tipomusicalistar implements OnInit {
  dataSource = new MatTableDataSource<TipoMusica>();
  displayedColumns: string[] = ['nombreTipo', 'categoria', 'descripcion', 'editar', 'eliminar'];

  constructor(private tS: TipoMusicaService) {}

  ngOnInit(): void {
    this.tS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });

    this.tS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
  }

  eliminar(id: number) {
    if (confirm('¿Deseas eliminar este tipo de música?')) {
      console.log('Intentando eliminar ID:', id);
      this.tS.delete(id).subscribe({
        next: () => {
          this.tS.list().subscribe((data) => this.tS.setList(data));
        },
        error: (err) => {
          console.error('Error al eliminar:', err);
          alert('No se pudo eliminar el registro dado que está en uso.');
        },
      });
    }
  }
}
