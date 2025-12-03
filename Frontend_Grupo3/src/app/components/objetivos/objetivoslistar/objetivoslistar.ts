import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { Objetivos } from '../../../models/Objetivos';
import { ObjetivosService } from '../../../services/objetivos-service';
import { RouterLink } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-objetivoslistar',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink,
    MatTableModule,
    MatPaginatorModule,
    MatIconModule,
    MatButtonModule,
  ],
  templateUrl: './objetivoslistar.html',
  styleUrls: ['./objetivoslistar.css'],
})
export class ObjetivosListar implements OnInit, AfterViewInit {
  dataSource = new MatTableDataSource<Objetivos>([]);
  displayedColumns: string[] = ['id', 'nombre', 'tipo', 'valorObjetivo', 'valorActual', 'fechaInicio', 'fechaFin', 'alcanzado', 'usuario', 'acciones'];

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private objS: ObjetivosService) {}

  ngOnInit(): void {
    this.objS.list().subscribe((data) => {
      this.dataSource.data = data ?? [];
    });
  }

  ngAfterViewInit(): void {
    if (this.paginator) {
      this.dataSource.paginator = this.paginator;
      this.paginator.pageSize = 8;
    }
  }

  eliminar(id: number) {
    if (!confirm('¿Deseas eliminar este objetivo?')) return;

    this.objS.delete(id).subscribe({
      next: () => {
        this.objS.list().subscribe((data) => this.objS.setList(data));
      },
      error: (err) => {
        console.error('Error al eliminar:', err);
        alert('No se pudo eliminar el objetivo, puede estar en uso.');
      },
    });
  }
}

export { ObjetivosListar as Objetivoslistar };