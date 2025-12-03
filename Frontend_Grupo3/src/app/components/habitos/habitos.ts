import { Component } from '@angular/core';
import { RouterOutlet, ActivatedRoute } from '@angular/router';
import { HabitosListar } from './habitoslistar/habitoslistar';

@Component({
  selector: 'app-habitos',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './habitos.html',
  styleUrl: './habitos.css',
})
export class Habitos {
  constructor(public route: ActivatedRoute){}
}
