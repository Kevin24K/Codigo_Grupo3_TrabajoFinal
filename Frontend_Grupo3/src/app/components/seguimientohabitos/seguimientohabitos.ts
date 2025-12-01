import { Component } from '@angular/core';
import { RouterOutlet, ActivatedRoute } from '@angular/router';
<<<<<<< HEAD

@Component({
  selector: 'app-seguimientohabitos',
  imports: [RouterOutlet],
=======
import { SeguimientoHabitosListar } from './seguimientohabitoslistar/seguimientohabitoslistar';

@Component({
  selector: 'app-seguimientohabitos',
  imports: [RouterOutlet, SeguimientoHabitosListar ],
>>>>>>> 025f87f507c1755ca786cb4953a649d705e74a23
  templateUrl: './seguimientohabitos.html',
  styleUrl: './seguimientohabitos.css',
})
export class Seguimientohabitos {
  constructor(public route: ActivatedRoute){}
}
