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
import { TipoMusica } from '../../../models/TipoMusica';
import { TipoMusicaService } from '../../../services/tipomusica-service';
import { MatCell } from "@angular/material/table";

@Component({
  selector: 'app-tipomusicaregistrar',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatSelectModule,
    MatCell
  ],
  templateUrl: './tipomusicaregistrar.html',
  styleUrl: './tipomusicaregistrar.css',
})
export class Tipomusicaregistrar implements OnInit {
  
  form: FormGroup = new FormGroup({});
  tipoMusica: TipoMusica = new TipoMusica();
  edicion: boolean = false;
  id: number = 0;

  categorias: string[] = [
    'Relajacion',
    'Sueño',
    'Meditacion',
    'Concentración',
    'Estrés'
  ];

  constructor(
    private tService: TipoMusicaService,
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
      nombreTipo: ['', Validators.required],
      categoria: ['', Validators.required],
      descripcion: ['', Validators.required],
    });
  }

  aceptar(): void {
    this.form.markAllAsTouched();

    if (!this.form.valid) {
      return; 
    }

    this.tipoMusica.idTipoMusica = this.form.value.codigo;
    this.tipoMusica.nombreTipo = this.form.value.nombreTipo;
    this.tipoMusica.categoria = this.form.value.categoria;
    this.tipoMusica.descripcion = this.form.value.descripcion;

    if (this.edicion) {
      this.tService.update(this.tipoMusica).subscribe(() => {
        this.tService.list().subscribe((data) => {
          this.tService.setList(data);
        });
      });
    } else {
      this.tService.insert(this.tipoMusica).subscribe(() => {
        this.tService.list().subscribe((data) => {
          this.tService.setList(data);
        });
      });
    }
    this.router.navigate(['tipomusica']);
  }

  // Cargar datos si es edición
  init(): void {
    if (this.edicion) {
      this.tService.listId(this.id).subscribe((data) => {
        this.form.setValue({
          codigo: data.idTipoMusica,
          nombreTipo: data.nombreTipo,
          categoria: data.categoria,
          descripcion: data.descripcion
        });
      });
    }
  }

  cancelar(): void {
    this.router.navigate(['/tipomusica']);
  }
}
