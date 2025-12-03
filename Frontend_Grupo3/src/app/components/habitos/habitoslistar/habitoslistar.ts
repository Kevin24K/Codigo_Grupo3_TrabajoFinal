import { Component, OnInit } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { Habitos } from '../../../models/Habitos';
import { HabitosService } from '../../../services/habitos-service';
import { RouterLink } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-habitoslistar',
  imports: [
    CommonModule,
    RouterLink,
    MatTableModule,
    MatButtonModule,
    MatIconModule,
  ],
  templateUrl: './habitoslistar.html',
  styleUrls: ['./habitoslistar.css'],
})
export class HabitosListar implements OnInit {
  dataSource: MatTableDataSource<Habitos> = new MatTableDataSource();

  constructor(private hS: HabitosService) {}

  ngOnInit(): void {
    this.hS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
    
    this.hS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
  }

  eliminar(id: number) {
    if (confirm('¿Deseas eliminar este hábito?')) {
      this.hS.delete(id).subscribe({
        next: () => {
          this.hS.list().subscribe((data) => this.hS.setList(data));
        },
        error: (err) => {
          console.error('Error al eliminar:', err);
          alert('No se pudo eliminar el hábito, puede estar en uso.');
        },
      });
    }
  }
}
