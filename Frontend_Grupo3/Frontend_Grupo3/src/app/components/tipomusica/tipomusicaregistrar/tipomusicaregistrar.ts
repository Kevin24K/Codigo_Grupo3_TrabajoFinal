import { Component, OnInit, Inject } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { TipoMusica } from '../../../models/TipoMusica';
import { TipoMusicaService } from '../../../services/tipomusica-service';
import { CommonModule } from '@angular/common';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-tipomusicaregistrar',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatDialogModule,
  ],
  templateUrl: './tipomusicaregistrar.html',
  styleUrls: ['./tipomusicaregistrar.css'],
})
export class Tipomusicaregistrar implements OnInit {
  form: FormGroup;
  isEdit = false; // para diferenciar registrar / editar

  constructor(
    private tS: TipoMusicaService,
    private formBuilder: FormBuilder,
    private dialogRef: MatDialogRef<Tipomusicaregistrar>,
    @Inject(MAT_DIALOG_DATA) public data: TipoMusica | null
  ) {
    this.form = this.formBuilder.group({
      idTipoMusica: [null],
      nombreTipo: ['', Validators.required],
      categoria: ['', Validators.required],
      descripcion: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    if (this.data) {
      this.isEdit = true;
      this.form.patchValue(this.data); // cargar datos al formulario
    }
  }

  guardar(): void {
    if (this.form.invalid) return;

    const tipoMusica = this.form.value as TipoMusica;

    if (this.isEdit) {
      this.tS.update(tipoMusica).subscribe({
        next: () => {
          this.tS.list().subscribe((data) => this.tS.setList(data));
          this.dialogRef.close('saved');
        },
        error: (err) => console.error('Error al editar:', err),
      });
    } else {
      this.tS.insert(tipoMusica).subscribe({
        next: () => {
          this.tS.list().subscribe((data) => this.tS.setList(data));
          this.dialogRef.close('saved');
        },
        error: (err) => console.error('Error al registrar:', err),
      });
    }
  }

  cancelar(): void {
    this.dialogRef.close();
  }
}
