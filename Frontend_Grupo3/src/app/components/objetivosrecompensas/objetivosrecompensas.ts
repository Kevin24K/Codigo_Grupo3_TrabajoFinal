import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet} from '@angular/router';

@Component({
  selector: 'app-objetivosrecompensas',
  imports: [RouterOutlet],
  templateUrl: './objetivosrecompensas.html',
  styleUrl: './objetivosrecompensas.css',
})
export class Objetivosrecompensas {
  constructor(public route: ActivatedRoute){}
}
