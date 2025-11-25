import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { ActivatedRoute, Params, Router } from '@angular/router';

import { Habitos } from '../../../models/Habitos';
import { HabitosService } from '../../../services/habitos-service';
import { Users } from '../../../models/Usuarios';
import { UsuarioService } from '../../../services/usuarios-service';

@Component({
  selector: 'app-habitosregistrar',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatSelectModule,
  ],
  templateUrl: './habitosregistrar.html',
  styleUrl: './habitosregistrar.css',
})
export class HabitosRegistrar implements OnInit {
  
  form: FormGroup = new FormGroup({});
  habito: Habitos = new Habitos();
  edicion: boolean = false;
  id: number = 0;

  listaUsuarios: Users[] = [];

  categorias = ['Salud mental', 'Desarrollo personal', 'Salud física', 'Relajación', 'Productividad', 'Nutrición', 'Social'];
  momentos = ['Mañana', 'Tarde', 'Noche'];

  constructor(
    private hService: HabitosService,
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
      codigo: [{ value: '', disabled: true }], // ID BLOQUEADO
      nombreHabito: ['', Validators.required],
      descripcion: ['', Validators.required],
      categoria: ['', Validators.required],
      momentoDia: ['', Validators.required],
      usuario: ['', Validators.required],
      activo: [true, Validators.required],
    });
  }

  aceptar(): void {
    this.form.markAllAsTouched();
    if (!this.form.valid) return;

    // Si el campo está disabled, obtener valor con getRawValue()
    const raw = this.form.getRawValue();

    this.habito.idHabitos = raw.codigo;
    this.habito.nombreHabito = raw.nombreHabito;
    this.habito.descripcion = raw.descripcion;
    this.habito.categoria = raw.categoria;
    this.habito.momentoDia = raw.momentoDia;
    this.habito.activo = raw.activo;

    this.habito.idUsuario = new Users();
    this.habito.idUsuario.id = raw.usuario;

    if (this.edicion) {
      this.hService.update(this.habito).subscribe(() => {
        this.hService.list().subscribe((data) => {
          this.hService.setList(data);
        });
      });
    } else {
      this.hService.insert(this.habito).subscribe(() => {
        this.hService.list().subscribe((data) => {
          this.hService.setList(data);
        });
      });
    }

    this.router.navigate(['/habitos']);
  }

  init() {
    if (this.edicion) {
      this.hService.listId(this.id).subscribe((data) => {
        this.form.patchValue({
          codigo: data.idHabitos,
          nombreHabito: data.nombreHabito,
          descripcion: data.descripcion,
          categoria: data.categoria,
          momentoDia: data.momentoDia,
          usuario: data.idUsuario.id,
          activo: data.activo,
        });

        // Asegurar que ID está deshabilitado
        this.form.get('codigo')?.disable();
      });
    }
  }

  cancelar() {
    this.router.navigate(['/habitos']);
  }
}
