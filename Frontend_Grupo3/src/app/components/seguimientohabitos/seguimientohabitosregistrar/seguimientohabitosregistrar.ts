import { Component, OnInit } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { SeguimientoHabitoService } from '../../../services/seguimientohabitos-service';
import { SeguimientoHabitos } from '../../../models/SeguimientoHabitos';
import { Habitos } from '../../../models/Habitos';
import { Users } from '../../../models/Usuarios';
import {
  FormBuilder,
  FormGroup,
  Validators,
  ReactiveFormsModule,
  FormControl,
} from '@angular/forms'; // Asegúrate de que ReactiveFormsModule esté aquí.
import { MatDatepickerModule } from '@angular/material/datepicker'; // Importamos MatDatepickerModule
import { MatNativeDateModule, provideNativeDateAdapter } from '@angular/material/core'; // Importamos MatNativeDateModule
import { MatRadioModule } from '@angular/material/radio'; // Importamos MatRadioModule aquí

@Component({
  selector: 'app-seguimientohabitosregistrar',
  templateUrl: './seguimientohabitosregistrar.html',
  providers: [provideNativeDateAdapter()],

  styleUrls: ['./seguimientohabitosregistrar.css'],
  imports: [
    ReactiveFormsModule, // Asegúrate de importar ReactiveFormsModule
    MatButtonModule, // Asegúrate de importar los módulos necesarios de Angular Material
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatDatepickerModule, // Importamos MatDatepickerModule aquí
    MatNativeDateModule, // Importamos MatNativeDateModule aquí
    MatRadioModule, // Importamos MatRadioModule aquí
  ],
})
export class SeguimientoHabitosRegistrar implements OnInit {
  form: FormGroup = new FormGroup({});
  seguimiento: SeguimientoHabitos = new SeguimientoHabitos();
  habito: Habitos = new Habitos();
  usuario: Users = new Users();
  idSeguimientoHabitos: number = 0;
  edicion: boolean = false;

  constructor(
    private sS: SeguimientoHabitoService,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((data: Params) => {
      this.habito.idHabitos = data['idHabito'];
      this.usuario.id = data['idUsuario'];
      this.idSeguimientoHabitos = data['id'];
      this.edicion = this.idSeguimientoHabitos != null;
      this.init();
    });

    // Crear el formulario al inicio
    this.form = this.formBuilder.group({
      codigo: [''],
      completado: ['', Validators.required],
      calidadEjecucion: ['', Validators.required],
      notas: ['', Validators.required],
      fechaSeguimiento: ['', Validators.required],
      usuario: [this.usuario.id],
      habito: [this.habito.idHabitos],
    });
  }

  aceptar(): void {
    this.form.markAllAsTouched();
    if (!this.form.valid) {
      return;
    }

    if (this.form.valid) {
      this.seguimiento.idSeguimientoHabitos = this.form.value.codigo;
      this.seguimiento.completado = this.form.value.completado;
      this.seguimiento.calidadEjecucion = this.form.value.calidadEjecucion;
      this.seguimiento.notas = this.form.value.notas;
      this.seguimiento.fechaSeguimiento = this.form.value.fechaSeguimiento;
      this.seguimiento.idUsuario.id = this.form.value.usuario;
      this.seguimiento.idHabito.idHabitos = this.form.value.habito;

      if (this.edicion) {
        this.sS.update(this.habito.idHabitos, this.usuario.id, this.seguimiento).subscribe(() => {
          this.sS.list(this.habito.idHabitos, this.usuario.id).subscribe((data) => {
            this.sS.setList(data);
          });
        });
      } else {
        this.sS.insert(this.habito.idHabitos, this.usuario.id, this.seguimiento).subscribe(() => {
          this.sS.list(this.habito.idHabitos, this.usuario.id).subscribe((data) => {
            this.sS.setList(data);
          });
        });
      }

      this.router.navigate([
        `/seguimientohabitos/listar/${this.habito.idHabitos}/${this.usuario.id}`,
      ]);
    }
  }

  init() {
    if (this.edicion) {
      this.sS.listId(this.idSeguimientoHabitos).subscribe((data) => {
        this.form.setValue({
          codigo: data.idSeguimientoHabitos,
          completado: data.completado,
          calidadEjecucion: data.calidadEjecucion,
          notas: data.notas,
          fechaSeguimiento: data.fechaSeguimiento,
          usuario: data.idUsuario.id,
          habito: data.idHabito.idHabitos,
        });
      });
    }
  }

  cancelar(): void {
    this.router.navigate([
      `/seguimientohabitos/listar/${this.habito.idHabitos}/${this.usuario.id}`,
    ]);
  }

  limitarCalidad(event: any): void {
    let value = Number(event.target.value);
    if (value > 10) value = 10;
    if (value < 0) value = 0;
    event.target.value = value;
    this.form.get('calidadEjecucion')?.setValue(value);
  }
}
