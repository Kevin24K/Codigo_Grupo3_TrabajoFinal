import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { ReactiveFormsModule, FormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatOptionModule } from '@angular/material/core';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatNativeDateModule, provideNativeDateAdapter } from '@angular/material/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { CommonModule } from '@angular/common';

import { Objetivos } from '../../../models/Objetivos';
import { Users } from '../../../models/Usuarios';
import { ObjetivosService } from '../../../services/objetivos-service';
import { UsuarioService } from '../../../services/usuarios-service';

@Component({
  selector: 'app-objetivosregistrar',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatSelectModule,
    MatOptionModule,
    MatCheckboxModule,
    MatDatepickerModule,
    MatNativeDateModule,
  ],
  providers: [provideNativeDateAdapter()],
  templateUrl: './objetivosregistrar.html',
  styleUrls: ['./objetivosregistrar.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class Objetivosregistrar implements OnInit {
  form: FormGroup = new FormGroup({});
  objetivo: Objetivos = new Objetivos();
  edicion: boolean = false;
  id: number = 0;

  listaUsuarios: Users[] = [];

  tiposObjetivo = ['Corto plazo', 'Mediano plazo', 'Largo plazo'];
  categoriasEjemplo = ['Salud', 'Educación', 'Finanzas', 'Carrera', 'Personal'];
  rangosValor = [1, 5, 10, 50, 100];

  constructor(
    private objService: ObjetivosService,
    private uService: UsuarioService,
    private router: Router,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((data: Params) => {
      this.id = data['id'];
      this.edicion = this.id != null;
      this.init();
    });

    this.uService.list().subscribe((data) => {
      this.listaUsuarios = data;
    });

    this.form = this.formBuilder.group({
      codigo: [{ value: '', disabled: true }],
      nombreObjetivo: ['', [Validators.required, Validators.maxLength(100)]],
      tipoObjetivo: [null, Validators.required],
      descripcion: ['', Validators.maxLength(500)],
      valorObjetivo: [0, [Validators.required, Validators.min(0)]],
      valorActual: [0, [Validators.min(0)]],
      fechaInicio: [new Date(), Validators.required],
      fechaFin: [null],
      alcanzado: [false],
      usuario: [null, Validators.required],
    });
  }

  aceptar(): void {
    this.form.markAllAsTouched();
    if (!this.form.valid) return;

    const raw = this.form.getRawValue();

    this.objetivo.idObjetivos = raw.codigo ?? 0;
    this.objetivo.nombreObjetivo = raw.nombreObjetivo;
    this.objetivo.tipoObjetivo = raw.tipoObjetivo;
    this.objetivo.descripcion = raw.descripcion;
    this.objetivo.valorObjetivo = Number(raw.valorObjetivo);
    this.objetivo.valorActual = Number(raw.valorActual);
    this.objetivo.fechaInicio = raw.fechaInicio ? new Date(raw.fechaInicio) : new Date();
    this.objetivo.fechaFin = raw.fechaFin ? new Date(raw.fechaFin) : new Date();
    this.objetivo.alcanzado = !!raw.alcanzado;

    this.objetivo.idUsuario = new Users();
    this.objetivo.idUsuario.id = raw.usuario;

    if (this.edicion) {
      this.objService.update(this.objetivo).subscribe(() => {
        this.objService.list().subscribe((data) => {
          this.objService.setList(data);
        });
      });
    } else {
      this.objService.insert(this.objetivo).subscribe(() => {
        this.objService.list().subscribe((data) => {
          this.objService.setList(data);
        });
      });
    }

    this.router.navigate(['/objetivos']);
  }

  init() {
    if (this.edicion) {
      this.objService.listId(this.id).subscribe((data) => {
        const d: any = data;
        this.form.patchValue({
          codigo: d.idObjetivos ?? d.id,
          nombreObjetivo: d.nombreObjetivo ?? d.nombre,
          tipoObjetivo: d.tipoObjetivo,
          descripcion: d.descripcion,
          valorObjetivo: d.valorObjetivo,
          valorActual: d.valorActual,
          fechaInicio: d.fechaInicio ? new Date(d.fechaInicio) : new Date(),
          fechaFin: d.fechaFin ? new Date(d.fechaFin) : null,
          alcanzado: d.alcanzado ?? false,
          usuario: d.idUsuario?.id ?? d.idUsuario,
        });

        this.form.get('codigo')?.disable();
      });
    }
  }

  cancelar() {
    this.router.navigate(['/objetivos']);
  }
}
