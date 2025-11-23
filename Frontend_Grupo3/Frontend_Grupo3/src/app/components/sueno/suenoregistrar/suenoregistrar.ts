import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker'; // Importante para fechas
import { MatNativeDateModule } from '@angular/material/core';
import { ActivatedRoute, Params, Router } from '@angular/router';

import { Sueno } from '../../../models/Sueno';
import { SuenoService } from '../../../services/sueno-service';
import { Users } from '../../../models/Usuarios';
import { UsuarioService } from '../../../services/usuarios-service';

@Component({
  selector: 'app-suenoregistrar',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  templateUrl: './suenoregistrar.html',
  styleUrls: ['./suenoregistrar.css'],
})
export class SuenoRegistrar implements OnInit {
  form: FormGroup = new FormGroup({});
  sueno: Sueno = new Sueno();
  edicion: boolean = false;
  id: number = 0;
  listaUsuarios: Users[] = [];
  
  // Opciones para selects simples
  calidades = [1, 2, 3, 4, 5];

  constructor(
    private sService: SuenoService,
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

    this.uService.list().subscribe(data => this.listaUsuarios = data);

    this.form = this.formBuilder.group({
      idSueno: [{ value: '', disabled: true }],
      fechaRegistro: ['', Validators.required],
      horaAcostarse: ['', Validators.required],
      horaDespertar: ['', Validators.required],
      calidadSueno: [3, Validators.required],
      interrupciones: [0, [Validators.required, Validators.min(0)]],
      cafeinaConsumida: [false, Validators.required],
      notas: ['', Validators.maxLength(300)],
      usuario: ['', Validators.required],
    });
  }

  aceptar(): void {
    if (this.form.invalid) {
        this.form.markAllAsTouched();
        return;
    }

    const raw = this.form.getRawValue();

    this.sueno.idSueno = this.edicion ? this.id : 0;
    this.sueno.fechaRegistro = raw.fechaRegistro;
    this.sueno.horaAcostarse = raw.horaAcostarse;
    this.sueno.horaDespertar = raw.horaDespertar;
    this.sueno.calidadSueno = raw.calidadSueno;
    this.sueno.interrupciones = raw.interrupciones;
    this.sueno.cafeinaConsumida = raw.cafeinaConsumida;
    this.sueno.notas = raw.notas;

    this.sueno.idUsuario = new Users();
    this.sueno.idUsuario.id = raw.usuario;

    if (this.edicion) {
      this.sService.update(this.sueno).subscribe(() => {
        this.sService.list().subscribe(data => this.sService.setList(data));
      });
    } else {
      this.sService.insert(this.sueno).subscribe(() => {
        this.sService.list().subscribe(data => this.sService.setList(data));
      });
    }
    this.router.navigate(['/suenos']);
  }

  init() {
    if (this.edicion) {
      this.sService.listId(this.id).subscribe((data) => {
        this.form.patchValue({
          idSueno: data.idSueno,
          fechaRegistro: data.fechaRegistro,
          horaAcostarse: data.horaAcostarse,
          horaDespertar: data.horaDespertar,
          calidadSueno: data.calidadSueno,
          interrupciones: data.interrupciones,
          cafeinaConsumida: data.cafeinaConsumida,
          notas: data.notas,
          usuario: data.idUsuario.id,
        });
      });
    }
  }

  cancelar() {
    this.router.navigate(['/suenos']);
  }
}