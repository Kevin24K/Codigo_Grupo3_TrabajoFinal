import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Sueno } from '../../../models/Sueno';
import { SuenoService } from '../../../services/sueno-service';
import { RouterLink } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule, DatePipe } from '@angular/common';

@Component({
  selector: 'app-suenolistar',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink,
    MatButtonModule,
    MatIconModule,
    // DatePipe es útil para formatear las fechas en el HTML
  ],
  templateUrl: './suenolistar.html',
  styleUrls: ['./suenolistar.css'],
})
export class SuenoListar implements OnInit {
  dataSource: MatTableDataSource<Sueno> = new MatTableDataSource();

  constructor(private sService: SuenoService) {}

  ngOnInit(): void {
    this.sService.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });

    this.sService.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
  }

  eliminar(id: number) {
    if (confirm('¿Deseas eliminar este registro de sueño?')) {
      this.sService.delete(id).subscribe({
        next: () => {
          this.sService.list().subscribe((data) => this.sService.setList(data));
        },
        error: (err) => {
          console.error('Error al eliminar:', err);
        },
      });
    }
  }
}