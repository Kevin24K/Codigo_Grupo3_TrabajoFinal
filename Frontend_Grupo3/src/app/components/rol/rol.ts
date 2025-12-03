import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-rol',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './rol.html',
  styleUrl: './rol.css',
})
export class Rol {
  constructor(public route: ActivatedRoute) {}
}