import { Routes } from '@angular/router';
import { Tipomusicalistar } from './components/tipomusica/tipomusicalistar/tipomusicalistar';
import { Tipomusicaregistrar } from './components/tipomusica/tipomusicaregistrar/tipomusicaregistrar';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'tipomusica',
    pathMatch: 'full',
  },
  {
    path: 'tipomusica',
    component: Tipomusicalistar,
  },
  {
    path: 'tipomusica/nuevo',
    component: Tipomusicaregistrar,
  },
  {
    path: 'tipomusica/editar/:id',
    component: Tipomusicaregistrar,
  },
];
