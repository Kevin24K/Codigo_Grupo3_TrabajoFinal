import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ObjetivosRecompensas } from '../../../models/ObjetivosRecompensas';
import { Objetivos } from '../../../models/Objetivos';
import { Recompensa } from '../../../models/Recompensa';
import { ObjetivosRecompensasService } from '../../../services/objetivosrecompensas-service';
import { ObjetivosService } from '../../../services/objetivos-service';
import { RecompensaService } from '../../../services/recompensa-service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';

@Component({
  selector: 'app-objetivosrecompensasregistrar',
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    MatDatepickerModule,
    MatNativeDateModule,
  ],
  templateUrl: './objetivosrecompensasregistrar.html',
  styleUrl: './objetivosrecompensasregistrar.css',
})
export class Objetivosrecompensasregistrar implements OnInit {
  form: FormGroup = new FormGroup({});
  objetivorecompensa: ObjetivosRecompensas = new ObjetivosRecompensas();
  edicion: boolean = false;
  id: number = 0;
  listaobjetivos: Objetivos[] = [];
  listarecompensas: Recompensa[] = [];

  constructor(
    private orService: ObjetivosRecompensasService,
    private oService: ObjetivosService,
    private rService: RecompensaService,
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

    this.oService.list().subscribe((data) => {
      this.listaobjetivos = data;
    });

    this.rService.list().subscribe((data) => {
      this.listarecompensas = data;
    });

    this.form = this.formBuilder.group({
      codigo: [''],
      fechaObtencion: ['', Validators.required],
      objetivo: ['', Validators.required],
      recompensa: ['', Validators.required],
    });
  }

  aceptar(): void {
    this.form.markAllAsTouched();

    if (!this.form.valid) {
      return;
    }

    this.objetivorecompensa.idObjetivosRecompensas = this.form.value.codigo;
    this.objetivorecompensa.fechaObtencion = this.form.value.fechaObtencion;
    this.objetivorecompensa.idRecompensa = new Recompensa();
    this.objetivorecompensa.idRecompensa.idRecompensa = this.form.value.recompensa;
    this.objetivorecompensa.idObjetivo = new Objetivos();
    this.objetivorecompensa.idObjetivo.idObjetivos = this.form.value.objetivo;

    if (this.edicion) {
      this.orService.update(this.objetivorecompensa).subscribe(() => {
        this.orService.list().subscribe((data) => {
          this.orService.setList(data);
        });
      });
    } else {
      this.orService.insert(this.objetivorecompensa).subscribe(() => {
        this.orService.list().subscribe((data) => {
          this.orService.setList(data);
        });
      });
    }
    this.router.navigate(['objetivosrecompensas']);
  }

  init() {
    if (this.edicion) {
      this.orService.listId(this.id).subscribe((data) => {
        this.form.setValue({
          codigo: data.idObjetivosRecompensas,
          fechaObtencion: data.fechaObtencion,
          recompensa: data.idRecompensa.idRecompensa,
          objetivo: data.idObjetivo.idObjetivos,
        });
      });
    }
  }

  cancelar() {
    this.router.navigate(['/objetivosrecompensas']);
  }
}
