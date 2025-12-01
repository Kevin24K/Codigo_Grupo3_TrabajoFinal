
import { Component } from '@angular/core';
import { RouterOutlet, ActivatedRoute} from '@angular/router';
<<<<<<< HEAD
=======
import { MusicaMultimediaListar } from './musicamultimedialistar/musicamultimedialistar';
>>>>>>> 025f87f507c1755ca786cb4953a649d705e74a23

@Component({
  selector: 'app-musicamultimedia',
  standalone: true,
<<<<<<< HEAD
  imports: [RouterOutlet],
=======
  imports: [MusicaMultimediaListar, RouterOutlet],
>>>>>>> 025f87f507c1755ca786cb4953a649d705e74a23
  templateUrl: './musicamultimedia.html',
  styleUrl: './musicamultimedia.css',
})
export class Musicamultimedia {
  constructor(public route: ActivatedRoute){}
}
    