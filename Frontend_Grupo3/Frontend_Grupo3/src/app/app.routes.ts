import { Routes } from '@angular/router';
import { Tipomusicalistar } from './components/tipomusica/tipomusicalistar/tipomusicalistar';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'tipomusica',
    pathMatch: 'full'
  },
  {
    path: 'tipomusica',
    component: Tipomusicalistar
  }
];
