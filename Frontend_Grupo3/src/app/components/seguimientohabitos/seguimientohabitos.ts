import { Component } from '@angular/core';
import { RouterOutlet, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-seguimientohabitos',
  imports: [RouterOutlet],
  templateUrl: './seguimientohabitos.html',
  styleUrl: './seguimientohabitos.css',
})
export class Seguimientohabitos {
  constructor(public route: ActivatedRoute){}
}
