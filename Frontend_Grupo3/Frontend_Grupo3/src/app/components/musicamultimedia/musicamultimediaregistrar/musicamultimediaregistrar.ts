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
import { Musicamultimedia } from '../../../models/MusicaMultimedia';
import { MusicaMultimediaService } from '../../../services/musicamultimedia-service';
import { TipoMusica } from '../../../models/TipoMusica';
import { TipoMusicaService } from '../../../services/tipomusica-service';

@Component({
  selector: 'app-musicamultimediaregistrar',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatSelectModule,
  ],
  templateUrl: './musicamultimediaregistrar.html',
  styleUrl: './musicamultimediaregistrar.css',
})
export class MusicamultimediaRegistrar implements OnInit {
  
  form: FormGroup = new FormGroup({});
  musica: Musicamultimedia = new Musicamultimedia();
  edicion: boolean = false;
  id: number = 0;
  listaTipos: TipoMusica[] = [];

  constructor(
    private mService: MusicaMultimediaService,
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

    this.tService.list().subscribe((data) => {
      this.listaTipos = data;
    });

    this.form = this.formBuilder.group({
      codigo: [''],
      nombreMusica: ['', Validators.required],
      linkArchivo: ['', Validators.required],
      tipo: ['', Validators.required],
    });
  }

  aceptar(): void {

    this.form.markAllAsTouched();

    if (!this.form.valid) {
      return;
    }

    this.musica.idMusicaMultimedia = this.form.value.codigo;
    this.musica.nombreMusica = this.form.value.nombreMusica;
    this.musica.linkArchivo = this.form.value.linkArchivo;

    // ❗ Corregido: tu objeto es anidado
    this.musica.idTipoMusica = new TipoMusica();
    this.musica.idTipoMusica.idTipoMusica = this.form.value.tipo;

    if (this.edicion) {
      this.mService.update(this.musica).subscribe(() => {
        this.mService.list().subscribe((data) => {
          this.mService.setList(data);
        });
      });
    } else {
      this.mService.insert(this.musica).subscribe(() => {
        this.mService.list().subscribe((data) => {
          this.mService.setList(data);
        });
      });
    }
    this.router.navigate(['musicamultimedia']);
  }

  init() {
    if (this.edicion) {
      this.mService.listId(this.id).subscribe((data) => {

        this.form.setValue({
          codigo: data.idMusicaMultimedia,
          nombreMusica: data.nombreMusica,
          linkArchivo: data.linkArchivo,
          tipo: data.idTipoMusica.idTipoMusica
        });

      });
    }
  }

  cancelar() {
    this.router.navigate(['/musicamultimedia']);
  }
}
