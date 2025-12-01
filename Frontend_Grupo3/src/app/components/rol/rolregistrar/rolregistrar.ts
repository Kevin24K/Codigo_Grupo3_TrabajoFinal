<<<<<<< HEAD
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { CommonModule } from '@angular/common'; // Importar CommonModule para *ngIf
import { MatCardModule } from '@angular/material/card'; // Importar MatCardModule

import { Rol } from '../../../models/Rol';
import { RolService } from '../../../services/rol-service';
import { Users } from '../../../models/Usuarios';
import { UsuarioService } from '../../../services/usuarios-service'; // Asegúrate de tener este servicio

@Component({
  selector: 'app-rolregistrar',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatSelectModule,
    MatAutocompleteModule,
    CommonModule, // Agregado para usar *ngIf en el template
    MatCardModule, // Sugerido para estilos de tarjeta
  ],
  templateUrl: './rolregistrar.html',
  styleUrls: ['./rolregistrar.css'],
})
export class RolRegistrar implements OnInit {
  form: FormGroup = new FormGroup({});
  rol: Rol = new Rol();
  edicion: boolean = false;
  id: number = 0;

  listaUsuarios: Users[] = [];

  listaroles = ['admin', 'analista', 'coach', 'cliente'];

  constructor(
    private rService: RolService,
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

    // Cargar usuarios para el Dropdown
    this.uService.list().subscribe((data) => {
      this.listaUsuarios = data;
    });

    this.form = this.formBuilder.group({
      id: [{ value: '', disabled: true }],
      rol: ['', Validators.required],
      usuario: ['', Validators.required],
    });
  }

  
  init() {
    if (this.edicion) {
      this.rService.listId(this.id).subscribe((data) => {
        this.form.patchValue({
          id: data.id,
          rol: data.rol,
          // Se asume que data.user es un objeto Users con un campo 'id'
          usuario: data.user.id, 
        });
      });
    }
  }

  aceptar(): void {
    this.form.markAllAsTouched();
    if (this.form.invalid) return;

    const raw = this.form.getRawValue();

    this.rol.id = this.edicion ? this.id : 0;
    this.rol.rol = raw.rol;

    this.rol.user = new Users();
    // Asignamos el ID del usuario seleccionado al objeto Users dentro de Rol
    this.rol.user.id = raw.usuario; 

    // Lógica para INSERT (Registro) o UPDATE (Modificación)
    if (this.edicion) {
      // Modificar Rol
      this.rService.update(this.rol).subscribe(() => {
        this.rService.list().subscribe((data) => {
          this.rService.setList(data);
          this.router.navigate(['rol']); // Navega a la lista
        });
      });
    } else {
      // Registrar Rol
      this.rService.insert(this.rol).subscribe(() => {
        this.rService.list().subscribe((data) => {
          this.rService.setList(data);
          this.router.navigate(['rol']); // Navega a la lista
        });
      });
    }
  }

  cancelar(): void {
    this.router.navigate(['rol']); // Botón de cancelar
  }
}
=======
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { ActivatedRoute, Params, Router } from '@angular/router';

import { Rol } from '../../../models/Rol';
import { RolService } from '../../../services/rol-service';
import { Users } from '../../../models/Usuarios';
import { UsuarioService } from '../../../services/usuarios-service'; // Asegúrate de tener este servicio

@Component({
  selector: 'app-rolregistrar',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatSelectModule,
  ],
  templateUrl: './rolregistrar.html',
  styleUrls: ['./rolregistrar.css'],
})
export class RolRegistrar implements OnInit {
  form: FormGroup = new FormGroup({});
  rol: Rol = new Rol();
  edicion: boolean = false;
  id: number = 0;

  listaUsuarios: Users[] = [];
  // Lista predefinida de roles sugeridos, o puedes dejarlo libre
  rolesSugeridos = ['ADMIN', 'USER', 'INVITADO', 'MODERADOR'];

  constructor(
    private rService: RolService,
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

    // Cargar usuarios para el Dropdown
    this.uService.list().subscribe((data) => {
      this.listaUsuarios = data;
    });

    this.form = this.formBuilder.group({
      id: [{ value: '', disabled: true }],
      rol: ['', Validators.required],
      usuario: ['', Validators.required],
    });
  }

  aceptar(): void {
    this.form.markAllAsTouched();
    if (this.form.invalid) return;

    const raw = this.form.getRawValue();

    this.rol.id = this.edicion ? this.id : 0;
    this.rol.rol = raw.rol;
    
    // Mapeo manual del usuario, similar a Habitos
    this.rol.user = new Users();
    this.rol.user.id = raw.usuario;

    if (this.edicion) {
      this.rService.update(this.rol).subscribe(() => {
        this.rService.list().subscribe((data) => this.rService.setList(data));
      });
    } else {
      this.rService.insert(this.rol).subscribe(() => {
        this.rService.list().subscribe((data) => this.rService.setList(data));
      });
    }

    this.router.navigate(['/roles']);
  }

  init() {
    if (this.edicion) {
      this.rService.listId(this.id).subscribe((data) => {
        this.form.patchValue({
          id: data.id,
          rol: data.rol,
          usuario: data.user.id,
        });
      });
    }
  }

  cancelar() {
    this.router.navigate(['/roles']);
  }
}
>>>>>>> 025f87f507c1755ca786cb4953a649d705e74a23
