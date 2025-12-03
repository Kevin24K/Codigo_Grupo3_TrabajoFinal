import { Component } from '@angular/core';
import { RouterOutlet, ActivatedRoute } from '@angular/router';
import { SeguimientoHabitosListar } from './seguimientohabitoslistar/seguimientohabitoslistar';

@Component({
  selector: 'app-seguimientohabitos',
  imports: [RouterOutlet, SeguimientoHabitosListar ],
  templateUrl: './seguimientohabitos.html',
  styleUrl: './seguimientohabitos.css',
})
export class Seguimientohabitos {
  constructor(public route: ActivatedRoute){}
}
