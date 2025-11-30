import { Component, OnInit } from '@angular/core';
import { Users } from '../../../models/Usuarios';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { UsuarioService } from '../../../services/usuarios-service';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';


@Component({
  selector: 'app-usuarioslistar',
  imports: [CommonModule, RouterLink, MatTableModule, MatButtonModule, MatIconModule],
  templateUrl: './usuarioslistar.html',
  styleUrl: './usuarioslistar.css',
})
export class Usuarioslistar implements OnInit {
  dataSource: MatTableDataSource<Users> = new MatTableDataSource();

  displayedColumns: string[] = ['id', 'username', 'editar', 'eliminar'];

  constructor(private uS: UsuarioService) {}

  ngOnInit(): void {
    this.uS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });

    this.uS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
  }

  eliminar(id: number) {
    if (confirm('¿Deseas eliminar esta usuario?')) {
      console.log('Intentando eliminar ID:', id);
      this.uS.delete(id).subscribe({
        next: () => {
          this.uS.list().subscribe((data) => this.uS.setList(data));
        },
        error: (err) => {
          console.error('Error al eliminar:', err);
          alert('No se pudo eliminar el registro dado que está en uso.');
        },
      });
    }
  }
}