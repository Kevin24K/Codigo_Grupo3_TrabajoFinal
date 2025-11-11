import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TipoMusica } from "./components/tipomusica/tipomusica";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, TipoMusica],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('Frontend_Grupo3');
}
