import { Component } from '@angular/core';
import { RouterOutlet, ActivatedRoute } from '@angular/router';
import { EstresListar } from './estreslistar/estreslistar';

@Component({
  selector: 'app-estres',
  standalone: true,
  imports: [RouterOutlet, EstresListar ],
  templateUrl: './estres.html',
  styleUrl: './estres.css',
})
export class Estres {
  constructor(public route: ActivatedRoute){}
}
