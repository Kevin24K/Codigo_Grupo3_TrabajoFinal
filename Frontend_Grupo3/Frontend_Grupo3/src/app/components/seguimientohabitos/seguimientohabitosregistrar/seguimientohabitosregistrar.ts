import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MatRadioModule } from '@angular/material/radio';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { provideNativeDateAdapter } from '@angular/material/core';

import { SeguimientoHabitos } from '../../../models/SeguimientoHabitos';
import { SeguimientoHabitoService } from '../../../services/seguimientohabitos-service';
import { Users } from '../../../models/Usuarios';
import { Habitos } from '../../../models/Habitos';

@Component({
  selector: 'app-seguimientohabitosregistrar',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatInputModule,
    MatFormFieldModule,
    MatRadioModule,
    MatDatepickerModule,
    MatButtonModule,
    MatSelectModule,
    MatDatepickerModule,
  ],

  templateUrl: './seguimientohabitosregistrar.html',
  providers: [provideNativeDateAdapter()],
  styleUrl: './seguimientohabitosregistrar.css',
})
export class SeguimientoHabitosRegistrar implements OnInit {
  form: FormGroup = new FormGroup({});
  seguimiento: SeguimientoHabitos = new SeguimientoHabitos();

  edicion: boolean = false;
  idHabito: number = 0;
  idSeguimientoHabitos: number = 0;

  constructor(
    private sService: SeguimientoHabitoService,
    private router: Router,
    private fb: FormBuilder,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      codigo: [''],
      fechaSeguimiento: ['', Validators.required],
      completado: ['', Validators.required],
      calidadEjecucion: ['', [Validators.required, Validators.min(0), Validators.max(10)]],
      notas: ['', Validators.maxLength(200)],
    });

    this.route.params.subscribe((params: Params) => {
      this.idHabito = params['idHabito'];
      this.idSeguimientoHabitos = params['idSeguimientoHabitos'];
      this.edicion = this.idSeguimientoHabitos != null;
      this.init();
    });
  }

  aceptar(): void {
    this.form.markAllAsTouched();
    if (!this.form.valid) return;

    this.seguimiento.idSeguimientoHabitos = this.form.value.codigo;
    this.seguimiento.fechaSeguimiento = this.form.value.fechaSeguimiento;
    this.seguimiento.completado = this.form.value.completado;
    this.seguimiento.calidadEjecucion = this.form.value.calidadEjecucion;
    this.seguimiento.notas = this.form.value.notas;

    this.seguimiento.idHabito = new Habitos();
    this.seguimiento.idHabito.idHabitos = this.idHabito;

    this.seguimiento.idUsuario = new Users();
    this.seguimiento.idUsuario.id = 1;

    if (this.edicion) {
      this.sService.update(this.seguimiento).subscribe(() => {
        this.sService.listByHabit(this.idHabito).subscribe((data) => {
          this.sService.setList(data);
        });
      });
    } else {
      this.sService.insert(this.seguimiento).subscribe(() => {
        this.sService.listByHabit(this.idHabito).subscribe((data) => {
          this.sService.setList(data);
        });
      });
    }

    this.router.navigate(['/seguimientohabitos', this.idHabito]);
  }

  init(): void {
    if (this.edicion) {
      this.sService.listId(this.idSeguimientoHabitos).subscribe((data) => {
        this.form.patchValue({  
          codigo: data.idSeguimientoHabitos,
          fechaSeguimiento: new Date(data.fechaSeguimiento),
          completado: data.completado,
          calidadEjecucion: data.calidadEjecucion,
          notas: data.notas,
        });
      });
    }
  }

  limitarCalidad(event: any) {
    let value = Number(event.target.value);
    if (value > 10) value = 10;
    if (value < 0) value = 0;
    event.target.value = value;
    this.form.get('calidadEjecucion')?.setValue(value);
  }

  cancelar(): void {
    this.router.navigate(['/seguimientohabitos', this.idHabito]);
  }
}
