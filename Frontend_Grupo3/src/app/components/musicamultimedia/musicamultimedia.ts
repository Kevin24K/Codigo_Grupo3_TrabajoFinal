
import { Component } from '@angular/core';
import { RouterOutlet, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-musicamultimedia',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './musicamultimedia.html',
  styleUrl: './musicamultimedia.css',
})
export class Musicamultimedia {
  constructor(public route: ActivatedRoute){}
}
    