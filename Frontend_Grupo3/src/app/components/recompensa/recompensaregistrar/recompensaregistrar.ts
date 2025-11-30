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
import { ActivatedRoute, Params, Router } from '@angular/router';
import { MatSelectModule } from '@angular/material/select';
import { Recompensa } from '../../../models/Recompensa';
import { RecompensaService } from '../../../services/recompensa-service';

@Component({
  selector: 'app-recompensaregistrar',
  imports: [
    ReactiveFormsModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatSelectModule,
  ],
  templateUrl: './recompensaregistrar.html',
  styleUrl: './recompensaregistrar.css',
})
export class Recompensaregistrar implements OnInit {
  form: FormGroup = new FormGroup({});
  recompensa: Recompensa = new Recompensa();
  edicion: boolean = false;
  id: number = 0;

  categorias: string[] = ['Relajacion', 'Sueño', 'Meditacion', 'Ejericio', 'General'];

  constructor(
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

    // FORMULARIO CON VALIDACIONES
    this.form = this.formBuilder.group({
      codigo: [''],
      nombreRecompensa: ['', Validators.required],
      descripcion: ['', Validators.required],
      tipoRecompensa: ['', Validators.required],
      puntosValor: ['', Validators.required],
    });
  }

  aceptar(): void {
    this.form.markAllAsTouched();

    if (!this.form.valid) {
      return;
    }

    this.recompensa.idRecompensa = this.form.value.codigo;
    this.recompensa.nombreRecompensa = this.form.value.nombreRecompensa;
    this.recompensa.descripcion = this.form.value.descripcion;
    this.recompensa.tipoRecompensa = this.form.value.tipoRecompensa;
    this.recompensa.puntosValor = this.form.value.puntosValor;

    if (this.edicion) {
      this.rService.update(this.recompensa).subscribe(() => {
        this.rService.list().subscribe((data) => {
          this.rService.setList(data);
        });
      });
    } else {
      this.rService.insert(this.recompensa).subscribe(() => {
        this.rService.list().subscribe((data) => {
          this.rService.setList(data);
        });
      });
    }
    this.router.navigate(['recompensa']);
  }

  // Cargar datos si es edición
  init(): void {
    if (this.edicion) {
      this.rService.listId(this.id).subscribe((data) => {
        this.form.setValue({
          codigo: data.idRecompensa,
          nombreRecompensa: data.nombreRecompensa,
          descripcion: data.descripcion,
          tipoRecompensa: data.tipoRecompensa,
          puntosValor: data.puntosValor,
        });
      });
    }
  }

  limitarCalidad(event: any): void {
    let value = Number(event.target.value);
    if (value > 300) value = 300;
    if (value < 0) value = 0;
    event.target.value = value;
    this.form.get('puntosValor')?.setValue(value);
  }

  cancelar(): void {
    this.router.navigate(['/recompensa']);
  }
}
