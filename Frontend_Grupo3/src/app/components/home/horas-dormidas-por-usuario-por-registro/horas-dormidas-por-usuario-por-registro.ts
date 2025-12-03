import { Component, OnInit } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { HorasDormidasDTO } from '../../../models/HorasDormidasDTO';
import { SuenoService } from '../../../services/sueno-service';
import { CommonModule, DatePipe } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-horas-dormidas-por-usuario-por-registro',
  imports: [CommonModule,
    MatTableModule,
    MatIconModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule, RouterLink],
  templateUrl: './horas-dormidas-por-usuario-por-registro.html',
  styleUrl: './horas-dormidas-por-usuario-por-registro.css',
})
export class HorasDormidasPorUsuarioPorRegistro implements OnInit{
  displayedColumns: string[] = [
    'idUsuario',
    'fechaRegistro',
    'horasDormidas',
  ];
  dataSource: MatTableDataSource<HorasDormidasDTO> = new MatTableDataSource();
  
  constructor(private sService: SuenoService) {}

  ngOnInit(): void {
    // Llamada al Query
    this.sService.horasDormidasPorUsuarioPorRegistro().subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
    });
  }

  // Permite filtrar por ID de usuario
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    
    this.dataSource.filterPredicate = (data, filter: string) => {
        return data.idUsuario.toString().includes(filter);
    };
  }
}
