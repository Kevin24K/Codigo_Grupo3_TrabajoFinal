
import { Component } from '@angular/core';
import { RouterOutlet, ActivatedRoute} from '@angular/router';
import { MusicaMultimediaListar } from './musicamultimedialistar/musicamultimedialistar';

@Component({
  selector: 'app-musicamultimedia',
  standalone: true,
  imports: [MusicaMultimediaListar, RouterOutlet],
  templateUrl: './musicamultimedia.html',
  styleUrl: './musicamultimedia.css',
})
export class Musicamultimedia {
  constructor(public route: ActivatedRoute){}
}
    