import { Component } from '@angular/core';
import { RouterOutlet, ActivatedRoute } from '@angular/router';
import { Objetivoslistar } from './objetivoslistar/objetivoslistar';

@Component({
  selector: 'app-objetivos',
  standalone: true,
  imports: [RouterOutlet, Objetivoslistar],
  templateUrl: './objetivos.html',
  styleUrl: './objetivos.css',
})
export class Objetivos {
  constructor(public route: ActivatedRoute){}
}
