import { Routes } from '@angular/router';
import { Tipomusicaregistrar } from './components/tipomusica/tipomusicaregistrar/tipomusicaregistrar';
import { Musicamultimedia } from './components/musicamultimedia/musicamultimedia';
import { MusicamultimediaRegistrar } from './components/musicamultimedia/musicamultimediaregistrar/musicamultimediaregistrar';
import { TipoMusica } from './components/tipomusica/tipomusica';
import { MusicaMultimediaListar } from './components/musicamultimedia/musicamultimedialistar/musicamultimedialistar';
import { Tipomusicalistar } from './components/tipomusica/tipomusicalistar/tipomusicalistar';

export const routes: Routes = [
  {
    path: 'tipomusica',
    component: TipoMusica,
    children: [
      { path: '', component: Tipomusicalistar },  
      { path: 'news', component: Tipomusicaregistrar },
      { path: 'edits/:id', component: Tipomusicaregistrar },
    ],
  },
  {
    path: 'musicamultimedia',
    component: Musicamultimedia,
    children: [
      { path: '', component: MusicaMultimediaListar },   
      { path: 'news', component: MusicamultimediaRegistrar },
      { path: 'edits/:id', component: MusicamultimediaRegistrar },
    ],
  },
];
