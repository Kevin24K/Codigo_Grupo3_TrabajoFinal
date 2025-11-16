import { Component, OnInit } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { Musicamultimedia } from '../../../models/MusicaMultimedia';
import { MusicaMultimediaService } from '../../../services/musicamultimedia-service';
import { RouterLink } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-musicamultimedialistar',
  imports: [
    CommonModule,
    RouterLink,
    MatTableModule,
    MatButtonModule,
    MatIconModule,
  ],
  templateUrl: './musicamultimedialistar.html',
  styleUrls: ['./musicamultimedialistar.css'], 
})
export class MusicaMultimediaListar implements OnInit { 
  dataSource: MatTableDataSource<Musicamultimedia> = new MatTableDataSource();

  displayedColumns: string[] = ['nombreMusica', 'linkArchivo', 'tipoMusica', 'editar', 'eliminar'];

  constructor(private mS: MusicaMultimediaService) {}

  ngOnInit(): void {
    this.mS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });

    this.mS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
  }

  eliminar(id: number) {
    if (confirm('¿Deseas eliminar esta música?')) {
      console.log('Intentando eliminar ID:', id);
      this.mS.delete(id).subscribe({
        next: () => {
          this.mS.list().subscribe((data) => this.mS.setList(data));
        },
        error: (err) => {
          console.error('Error al eliminar:', err);
          alert('No se pudo eliminar el registro dado que está en uso.');
        },
      });
    }
  }
}
