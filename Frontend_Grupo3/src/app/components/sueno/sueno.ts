<<<<<<< HEAD
import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-suenos',
  standalone: true,
  imports: [RouterOutlet],
  template: `<router-outlet></router-outlet>`,
})
export class Suenos {
  constructor(public route: ActivatedRoute) {}
=======
import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-suenos',
  standalone: true,
  imports: [RouterOutlet],
  template: `<router-outlet></router-outlet>`,
})
export class Suenos {
  constructor(public route: ActivatedRoute) {}
>>>>>>> 025f87f507c1755ca786cb4953a649d705e74a23
}