import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { RouterLink, Router, RouterOutlet } from '@angular/router';  // Importar Router
import { LoginService } from '../../services/login-service';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';

@Component({
  selector: 'app-menu',
  imports: [
    MatToolbarModule,
    MatSidenavModule,
    MatIconModule,
    MatButtonModule,
    MatMenuModule,
    RouterLink,
    CommonModule,
    RouterLink,
    MatListModule,
    RouterOutlet
  ],
  templateUrl: './menu.html',
  styleUrl: './menu.css',
})
export class Menu {
  role: string = '';
  usuario: string = '';

  constructor(private loginService: LoginService, private router: Router) {}  // Inyectar Router

  cerrar() {
    sessionStorage.clear();  // Limpiar sesión
    this.router.navigate(['/']);  // Redirigir a la landing page
  }

  verificar() {
    this.role = this.loginService.showRole();
    return this.loginService.verificar();
  }

  isAdmin() {
    return this.role === 'admin';
  }

  isClient() {
    return this.role === 'cliente';
  }

  isCoach() {
    return this.role === 'coach';
  }

  isAnalist() {
    return this.role === 'analista';
  }
}
