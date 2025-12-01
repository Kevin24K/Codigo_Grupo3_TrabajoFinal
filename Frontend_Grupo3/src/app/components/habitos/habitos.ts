import { Component } from '@angular/core';
import { RouterOutlet, ActivatedRoute } from '@angular/router';
<<<<<<< HEAD
=======
import { HabitosListar } from './habitoslistar/habitoslistar';
>>>>>>> 025f87f507c1755ca786cb4953a649d705e74a23

@Component({
  selector: 'app-habitos',
  standalone: true,
<<<<<<< HEAD
  imports: [RouterOutlet],
=======
  imports: [RouterOutlet, HabitosListar ],
>>>>>>> 025f87f507c1755ca786cb4953a649d705e74a23
  templateUrl: './habitos.html',
  styleUrl: './habitos.css',
})
export class Habitos {
  constructor(public route: ActivatedRoute){}
}
