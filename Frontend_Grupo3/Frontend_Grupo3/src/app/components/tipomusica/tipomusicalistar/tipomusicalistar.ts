import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { TipoMusica } from '../../../models/TipoMusica';
import { TipoMusicaService } from '../../../services/tipomusica-service';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-tipomusicalistar',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule,
    MatTableModule,
    MatButtonModule,
    MatIconModule
  ],
  templateUrl: './tipomusicalistar.html',
  styleUrl: './tipomusicalistar.css',
})
export class Tipomusicalistar implements OnInit {
  dataSource: MatTableDataSource<TipoMusica> = new MatTableDataSource();
  displayedColumns: string[] = ['nombreTipo', 'categoria', 'descripcion', 'editar', 'eliminar'];

  constructor(private tS: TipoMusicaService, private router: Router) {}

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
      this.tS.delete(id).subscribe(() => {
        this.tS.list().subscribe((data) => {
          this.tS.setList(data);
        });
      });
    }
  }

  editar(id: number) {
    // Redirige al componente de edición (si ya lo tienes)
    this.router.navigate(['/tipomusica/editar', id]);
  }
}
