import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { TipoMusica } from '../../../models/TipoMusica';
import { TipoMusicaService } from '../../../services/tipomusica-service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-tipomusicaregistrar',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    CommonModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatCardModule,
  ],
  templateUrl: './tipomusicaregistrar.html',
  styleUrls: ['./tipomusicaregistrar.css'], // ✅ corregido
})
export class Tipomusicaregistrar implements OnInit {
  form: FormGroup = new FormGroup({});
  tm: TipoMusica = new TipoMusica();

  edicion: boolean = false;
  id: number = 0;

  constructor(
    private tS: TipoMusicaService,
    private router: Router,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((data: Params) => {
      this.id = data['id'];
      this.edicion = data['id'] != null;
      this.init();
    });

    this.form = this.formBuilder.group({
      codigo: [''],
      nombreTipo: ['', Validators.required],
      categoria: ['', Validators.required],
      descripcion: ['', Validators.required],
    });
  }

  aceptar(): void {
    if (this.form.valid) {
      this.tm.idTipoMusica = this.form.value.codigo;
      this.tm.nombreTipo = this.form.value.nombreTipo;
      this.tm.categoria = this.form.value.categoria;
      this.tm.descripcion = this.form.value.descripcion;

      if (this.edicion) {
        this.tS.update(this.tm).subscribe(() => {
          this.tS.list().subscribe((data) => this.tS.setList(data));
        });
      } else {
        this.tS.insert(this.tm).subscribe(() => {
          this.tS.list().subscribe((data) => this.tS.setList(data));
        });
      }

      this.router.navigate(['tipomusica']);
    }
  }

  init() {
    if (this.edicion) {
      this.tS.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          codigo: new FormControl(data.idTipoMusica),
          nombreTipo: new FormControl(data.nombreTipo),
          categoria: new FormControl(data.categoria),
          descripcion: new FormControl(data.descripcion),
        });
      });
    }
  }

  cancelar(): void {
    this.router.navigate(['tipomusica']);
  }
}
