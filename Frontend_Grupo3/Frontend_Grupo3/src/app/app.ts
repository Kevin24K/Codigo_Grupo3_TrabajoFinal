import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TipoMusica } from "./components/tipomusica/tipomusica";
import { MatDialogModule } from '@angular/material/dialog';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet, TipoMusica, MatDialogModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('Frontend_Grupo3');
}
