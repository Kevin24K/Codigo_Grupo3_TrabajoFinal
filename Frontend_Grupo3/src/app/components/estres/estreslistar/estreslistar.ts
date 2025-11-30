import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { Estres } from '../../../models/Estres';
import { EstresService } from '../../../services/estres-service';
import { RouterLink } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';

@Component({
  selector: 'app-estreslistar',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink,
    MatTableModule,
    MatPaginatorModule,
    MatIconModule,
    MatButtonModule,
  ],
  templateUrl: './estreslistar.html',
  styleUrls: ['./estreslistar.css'],
})
export class EstresListar implements OnInit, AfterViewInit {
  dataSource = new MatTableDataSource<any>([]);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private eS: EstresService) {}

  ngOnInit(): void {
    this.eS.list().subscribe((data) => {
      this.dataSource.data = data ?? [];
    });
  }

  ngAfterViewInit(): void {
    // establece paginador y tamaño por página
    if (this.paginator) {
      this.dataSource.paginator = this.paginator;
      this.paginator.pageSize = 8;
    }
  }

  eliminar(id: number) {
    if (!confirm('¿Deseas eliminar este registro de estrés?')) return;

    this.eS.delete(id).subscribe({
      next: () => {
        this.eS.list().subscribe((data) => this.eS.setList(data));
      },
      error: (err) => {
        console.error('Error al eliminar:', err);
        alert('No se pudo eliminar el registro, puede estar en uso.');
      },
    });
  }
}

// Alias para compatibilidad con imports existentes
export { EstresListar as Estreslistar };
