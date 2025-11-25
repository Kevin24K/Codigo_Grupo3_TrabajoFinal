import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Tipomusicalistar } from './tipomusicalistar/tipomusicalistar';


@Component({
  selector: 'app-tipo-musica',
  standalone: true,
  imports: [RouterOutlet, Tipomusicalistar],
  templateUrl: './tipomusica.html',
  styleUrl: './tipomusica.css',
})
export class TipoMusica {
  constructor(public route: ActivatedRoute){}
}
