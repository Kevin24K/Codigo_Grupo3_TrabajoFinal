import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
<<<<<<< HEAD
import { Menu } from './components/menu/menu';
=======
import { TipoMusica } from "./components/tipomusica/tipomusica";
import { MatDialogModule } from '@angular/material/dialog';
>>>>>>> 025f87f507c1755ca786cb4953a649d705e74a23


@Component({
  selector: 'app-root',
<<<<<<< HEAD
  imports: [RouterOutlet, Menu],
  standalone: true,
=======
  imports: [RouterOutlet, TipoMusica, MatDialogModule],
>>>>>>> 025f87f507c1755ca786cb4953a649d705e74a23
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('Frontend_Grupo3');
}
