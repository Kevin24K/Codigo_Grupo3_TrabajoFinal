import { Routes } from '@angular/router';
import { Tipomusicaregistrar } from './components/tipomusica/tipomusicaregistrar/tipomusicaregistrar';
import { Musicamultimedia } from './components/musicamultimedia/musicamultimedia';
import { MusicamultimediaRegistrar } from './components/musicamultimedia/musicamultimediaregistrar/musicamultimediaregistrar';
import { TipoMusica } from './components/tipomusica/tipomusica';
import { MusicaMultimediaListar } from './components/musicamultimedia/musicamultimedialistar/musicamultimedialistar';
import { Tipomusicalistar } from './components/tipomusica/tipomusicalistar/tipomusicalistar';
import { Habitos } from './components/habitos/habitos';
import { HabitosListar } from './components/habitos/habitoslistar/habitoslistar';
import { HabitosRegistrar } from './components/habitos/habitosregistrar/habitosregistrar';
import { Seguimientohabitos } from './components/seguimientohabitos/seguimientohabitos';
import { SeguimientoHabitosListar } from './components/seguimientohabitos/seguimientohabitoslistar/seguimientohabitoslistar';
import { SeguimientoHabitosRegistrar } from './components/seguimientohabitos/seguimientohabitosregistrar/seguimientohabitosregistrar';

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

  {
    path: 'habitos',
    component: Habitos,
    children: [
      { path: '', component: HabitosListar },
      { path: 'news', component: HabitosRegistrar },
      { path: 'edits/:id', component: HabitosRegistrar },
    ],
  },

  {
    path: 'seguimientohabitos/:idHabito',
    component: Seguimientohabitos,
    children: [
      { path: '', component: SeguimientoHabitosListar },
      { path: 'news', component: SeguimientoHabitosRegistrar },
      { path: 'edits/:id', component: SeguimientoHabitosRegistrar },
    ],
  },
];
