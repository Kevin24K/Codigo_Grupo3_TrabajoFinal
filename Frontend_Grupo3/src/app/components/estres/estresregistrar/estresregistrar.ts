import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { ReactiveFormsModule, FormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatOptionModule } from '@angular/material/core';
import { MatNativeDateModule, provideNativeDateAdapter } from '@angular/material/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { CommonModule } from '@angular/common';

import { Estres } from '../../../models/Estres';
import { Users } from '../../../models/Usuarios';
import { EstresService } from '../../../services/estres-service';
import { UsuarioService } from '../../../services/usuarios-service';

@Component({
  selector: 'app-estresregistrar',
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
    MatDatepickerModule,
    MatNativeDateModule,
  ],
  providers: [provideNativeDateAdapter()],
  templateUrl: './estresregistrar.html',
  styleUrls: ['./estresregistrar.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class Estresregistrar implements OnInit {
  form: FormGroup = new FormGroup({});
  estres: Estres = new Estres();
  edicion: boolean = false;
  id: number = 0;

  listaUsuarios: Users[] = [];

  niveles = [0,1,2,3,4,5]; // opcional para selects

  constructor(
    private eS: EstresService,
    private uService: UsuarioService,
    private router: Router,
    private fb: FormBuilder,
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

    this.form = this.fb.group({
      codigo: [{ value: '', disabled: true }],
      nivelEstres: [null, [Validators.required, Validators.min(0), Validators.max(10)]],
      nivelAnsiedad: [null, [Validators.min(0), Validators.max(10)]],
      factoresEstimulantes: ['', Validators.maxLength(500)],
      sintomasFisicos: ['', Validators.maxLength(300)],
      sintomasEmocionales: ['', Validators.maxLength(300)],
      fechaRegistro: [new Date(), Validators.required],
      usuario: [null, Validators.required],
    });
  }

  aceptar(): void {
    this.form.markAllAsTouched();
    if (!this.form.valid) return;

    const raw = this.form.getRawValue();

    this.estres.idEstres = raw.codigo ?? 0;
    this.estres.nivelEstres = Number(raw.nivelEstres);
    // asignar 0 por defecto si viene null para que coincida con tipo number
    this.estres.nivelAnsiedad = raw.nivelAnsiedad != null ? Number(raw.nivelAnsiedad) : 0;
    this.estres.factoresEstimulantes = raw.factoresEstimulantes;
    this.estres.sintomasFisicos = raw.sintomasFisicos;
    this.estres.sintomasEmocionales = raw.sintomasEmocionales;
    this.estres.fechaRegistro = raw.fechaRegistro ? new Date(raw.fechaRegistro) : new Date();

    this.estres.idUsuario = new Users();
    this.estres.idUsuario.id = raw.usuario;

    if (this.edicion) {
      this.eS.update(this.estres).subscribe(() => {
        this.eS.list().subscribe((data) => this.eS.setList(data));
      });
    } else {
      this.eS.insert(this.estres).subscribe(() => {
        this.eS.list().subscribe((data) => this.eS.setList(data));
      });
    }

    this.router.navigate(['/estres']);
  }

  init() {
    if (this.edicion) {
      this.eS.listId(this.id).subscribe((data) => {
        const d: any = data;
        this.form.patchValue({
          codigo: d.idEstres ?? d.id,
          nivelEstres: d.nivelEstres,
          nivelAnsiedad: d.nivelAnsiedad,
          factoresEstimulantes: d.factoresEstimulantes,
          sintomasFisicos: d.sintomasFisicos,
          sintomasEmocionales: d.sintomasEmocionales,
          fechaRegistro: d.fechaRegistro ? new Date(d.fechaRegistro) : new Date(),
          usuario: d.idUsuario?.id ?? d.idUsuario,
        });
        this.form.get('codigo')?.disable();
      });
    }
  }

  cancelar() {
    this.router.navigate(['/estres']);
  }
}