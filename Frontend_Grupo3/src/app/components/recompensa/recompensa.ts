import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-recompensa',
  imports: [RouterOutlet],
  templateUrl: './recompensa.html',
  styleUrl: './recompensa.css',
})
export class Recompensa {
  constructor(public route: ActivatedRoute){}
}
