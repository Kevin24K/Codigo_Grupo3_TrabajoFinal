import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { RouterLink } from '@angular/router';
import { TipoMusica } from '../../../models/TipoMusica';
import { TipoMusicaService } from '../../../services/tipomusica-service';
import { Tipomusicaregistrar } from '../tipomusicaregistrar/tipomusicaregistrar'; 

@Component({
  selector: 'app-tipomusicalistar',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink,
    MatTableModule,
    MatButtonModule,
    MatIconModule,
    MatDialogModule,
    Tipomusicaregistrar,        
  ],
  templateUrl: './tipomusicalistar.html',
  styleUrls: ['./tipomusicalistar.css'],
})
export class Tipomusicalistar implements OnInit {
  dataSource = new MatTableDataSource<TipoMusica>();
  displayedColumns: string[] = ['nombreTipo', 'categoria', 'descripcion', 'editar', 'eliminar'];

  constructor(private tS: TipoMusicaService, private dialog: MatDialog) {}

  ngOnInit(): void {
    this.tS.list().subscribe({
      next: (data) => (this.dataSource = new MatTableDataSource(data)),
      error: (err) => console.error('Error al listar:', err),
    });

    // Escuchar actualizaciones
    this.tS.getList().subscribe({
      next: (data) => (this.dataSource = new MatTableDataSource(data)),
    });
  }

  eliminar(id: number) {
    if (confirm('¿Deseas eliminar este tipo de música?')) {
      console.log('Intentando eliminar ID:', id);
      this.tS.delete(id).subscribe({
        next: (mensaje) => {
          console.log('Backend respondió:', mensaje);
          this.tS.list().subscribe((data) => {
            this.tS.setList(data);
          });
        },
        error: (err) => {
          console.error('Error al eliminar:', err);
          alert('No se pudo eliminar el registro.');
        },
      });
    }
  }

  editar(id: number) {
    const item = this.dataSource.data.find((i) => i.idTipoMusica === id);
    const dialogRef = this.dialog.open(Tipomusicaregistrar, {
      width: '450px',
      data: item,
      panelClass: 'custom-dialog-container',
      backdropClass: 'custom-dialog-backdrop',
      disableClose: true,
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result === 'saved') {
        this.tS.list().subscribe((data) => this.tS.setList(data));
      }
    });
  }

  openDialog() {
    const dialogRef = this.dialog.open(Tipomusicaregistrar, {
      width: '450px',
      disableClose: true,
      panelClass: 'custom-dialog-container',
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result === 'saved') {
        this.tS.list().subscribe((data) => this.tS.setList(data));
      }
    });
  }
}
