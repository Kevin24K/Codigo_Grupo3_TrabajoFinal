import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { UsuarioService } from '../../../services/usuarios-service';
import { Users } from '../../../models/Usuarios';
import { CommonModule } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-usuariosbuscar',
  standalone: true, // Asumiendo que se usan componentes Standalone
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    MatCardModule,
  ],
  templateUrl: './usuariosbuscar.html',
  styleUrl: './usuariosbuscar.css',
})
export class Usuariosbuscar implements OnInit {
  form: FormGroup = new FormGroup({});
  usuarioEncontrado: Users | null = null;
  mensaje: string = '';

  constructor(private formBuilder: FormBuilder, private uService: UsuarioService) {}

  get rolesFormateados(): string {
    if (
      this.usuarioEncontrado &&
      this.usuarioEncontrado.roles &&
      this.usuarioEncontrado.roles.length > 0
    ) {
      // Aplica la lógica de map y join aquí, en el componente.
      return this.usuarioEncontrado.roles.map((r) => r.rol).join(', ');
    }
    return '';
  }

  ngOnInit(): void {
    // Inicialización del formulario reactivo con validación de campo requerido
    this.form = this.formBuilder.group({
      username: ['', Validators.required],
    });
  }

  buscar(): void {
    this.form.markAllAsTouched();
    this.usuarioEncontrado = null; // Limpiar resultados anteriores
    this.mensaje = ''; // Limpiar mensajes anteriores

    if (!this.form.valid) {
      this.mensaje = 'Por favor, ingrese un nombre de usuario.';
      return;
    }

    const usernameABuscar = this.form.value.username;

    // El servicio necesita un nuevo método 'buscarPorUsername'
    this.uService.buscarPorUsername(usernameABuscar).subscribe({
      next: (data: Users) => {
        // Asume que el backend devuelve 200 con el objeto si lo encuentra
        this.usuarioEncontrado = data;
        this.mensaje = `Usuario '${usernameABuscar}' encontrado exitosamente.`;
      },
      error: (err) => {
        // Manejo de errores (ej. 404 Not Found)
        console.error('Error al buscar usuario:', err);
        // El backend devuelve 404 con un mensaje en caso de no encontrarlo
        this.mensaje = `No se encontró el usuario con nombre: '${usernameABuscar}'`;
        this.usuarioEncontrado = null;
      },
    });
  }
}
