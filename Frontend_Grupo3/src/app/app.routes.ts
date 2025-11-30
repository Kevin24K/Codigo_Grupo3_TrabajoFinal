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
import { Rol } from './components/rol/rol';
import { RolListar } from './components/rol/rollistar/rollistar';
import { RolRegistrar } from './components/rol/rolregistrar/rolregistrar';
import { Suenos } from './components/sueno/sueno';
import { SuenoListar } from './components/sueno/suenolistar/suenolistar';
import { SuenoRegistrar } from './components/sueno/suenoregistrar/suenoregistrar';
import { Usuarios } from './components/usuarios/usuarios';
import { Usuarioslistar } from './components/usuarios/usuarioslistar/usuarioslistar';
import { Usuariosregistrar } from './components/usuarios/usuariosregistrar/usuariosregistrar';
import { Autenticador } from './components/autenticador/autenticador';
import { Home } from './components/home/home';
import { seguridadGuard } from './guard/seguridad-guard';
import { Recompensalistar } from './components/recompensa/recompensalistar/recompensalistar';
import { Recompensaregistrar } from './components/recompensa/recompensaregistrar/recompensaregistrar';
import { Objetivosrecompensas } from './components/objetivosrecompensas/objetivosrecompensas';
import { Objetivosrecompensaslistar } from './components/objetivosrecompensas/objetivosrecompensaslistar/objetivosrecompensaslistar';
import { Objetivosrecompensasregistrar } from './components/objetivosrecompensas/objetivosrecompensasregistrar/objetivosrecompensasregistrar';
import { HabitosActivosPorUsuario } from './components/home/habitos-activos-por-usuario/habitos-activos-por-usuario';
import { HabitosCompletadosListar } from './components/home/habitoscompletados/habitoscompletadoslistar';
import { HabitosNoCompletadosListar } from './components/home/habitosnocompletados/habitosnocompletadoslistar';
import { Usuariosbuscar } from './components/home/usuariosbuscar/usuariosbuscar';
import { promedioSuenoTodosUsuarios } from './components/home/promedio-sueno-todos-usuarios/promedio-sueno-todos-usuarios';
import { HorasDormidasPorUsuarioPorRegistro } from './components/home/horas-dormidas-por-usuario-por-registro/horas-dormidas-por-usuario-por-registro';
import { BuscarPorUmbralCalidadDeSueno } from './components/home/buscar-por-umbral-calidad-de-sueno/buscar-por-umbral-calidad-de-sueno';
import { SleepCalendar } from './components/sleep-calendar/sleep-calendar';
import { Objetivos } from './components/objetivos/objetivos';
import { Objetivoslistar } from './components/objetivos/objetivoslistar/objetivoslistar';
import { Objetivosregistrar } from './components/objetivos/objetivosregistrar/objetivosregistrar';
import { Estreslistar } from './components/estres/estreslistar/estreslistar';
import { Estresregistrar } from './components/estres/estresregistrar/estresregistrar';
import { Estres } from './components/estres/estres';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full',
  },
  {
    path: 'login',
    component: Autenticador,
  },

  {
    path: 'homes',
    component: Home,
    canActivate: [seguridadGuard],
  },

  {
    path: 'tipomusica',
    component: TipoMusica,
    children: [
      { path: '', component: Tipomusicalistar, canActivate: [seguridadGuard] },
      { path: 'news', component: Tipomusicaregistrar, canActivate: [seguridadGuard] },
      { path: 'edits/:id', component: Tipomusicaregistrar, canActivate: [seguridadGuard] },
    ],
  },

  {
    path: 'recompensa',
    component: TipoMusica,
    children: [
      { path: '', component: Recompensalistar, canActivate: [seguridadGuard] },
      { path: 'news', component: Recompensaregistrar, canActivate: [seguridadGuard] },
      { path: 'edits/:id', component: Recompensaregistrar, canActivate: [seguridadGuard] },
    ],
  },

  {
    path: 'habitos',
    component: Habitos,
    children: [
      { path: '', component: HabitosListar, canActivate: [seguridadGuard] },
      { path: 'news', component: HabitosRegistrar, canActivate: [seguridadGuard] },
      { path: 'edits/:id', component: HabitosRegistrar, canActivate: [seguridadGuard] },
    ],
  },

  {
    path: 'musicamultimedia',
    component: Musicamultimedia,
    children: [
      { path: '', component: MusicaMultimediaListar, canActivate: [seguridadGuard] },
      { path: 'news', component: MusicamultimediaRegistrar, canActivate: [seguridadGuard] },
      { path: 'edits/:id', component: MusicamultimediaRegistrar, canActivate: [seguridadGuard] },
    ],
  },

  {
    path: 'usuarios',
    component: Usuarios,
    children: [
      { path: '', component: Usuarioslistar, canActivate: [seguridadGuard] },
      { path: 'news', component: Usuariosregistrar, canActivate: [seguridadGuard] },
      { path: 'edits/:id', component: Usuariosregistrar, canActivate: [seguridadGuard] },
    ],
  },

  {
    path: 'seguimientohabitos/registrar/:idHabito/:idUsuario',
    component: SeguimientoHabitosRegistrar,
    canActivate: [seguridadGuard],
  },
  {
    path: 'seguimientohabitos/listar/:idHabito/:idUsuario',
    component: SeguimientoHabitosListar,
    canActivate: [seguridadGuard],
  },
  {
    path: 'seguimientohabitos/editar/:idHabito/:idUsuario/:id',
    component: SeguimientoHabitosRegistrar,
    canActivate: [seguridadGuard],
  },

  {
    path: 'rol',
    component: Rol,
    children: [
      { path: '', component: RolListar, canActivate: [seguridadGuard] },
      { path: 'news', component: RolRegistrar, canActivate: [seguridadGuard] },
      { path: 'edits/:id', component: RolRegistrar, canActivate: [seguridadGuard] },
    ],
  },

  {
    path: 'suenos',
    component: Suenos,
    children: [
      { path: '', component: SuenoListar, canActivate: [seguridadGuard] },
      { path: 'news', component: SuenoRegistrar, canActivate: [seguridadGuard] },
      { path: 'edits/:id', component: SuenoRegistrar, canActivate: [seguridadGuard] },
    ],
  },

  {
    path: 'objetivosrecompensas',
    component: Objetivosrecompensas,
    children: [
      { path: '', component: Objetivosrecompensaslistar, canActivate: [seguridadGuard] },
      { path: 'news', component: Objetivosrecompensasregistrar, canActivate: [seguridadGuard] },
      {
        path: 'edits/:id',
        component: Objetivosrecompensasregistrar,
        canActivate: [seguridadGuard],
      },
    ],
  },
  {
    path: 'sleep-calendar',
    component: SleepCalendar,
    canActivate: [seguridadGuard],
  },

    {
    path: 'estres',
    component: Estres,
    children: [
      { path: '', component: Estreslistar },
      { path: 'news', component: Estresregistrar },
      { path: 'edits/:id', component: Estresregistrar },
    ],
  },

  {
    path: 'objetivos',
    component: Objetivos,
    children: [
      { path: '', component: Objetivoslistar },
      { path: 'news', component: Objetivosregistrar },
      { path: 'edits/:id', component: Objetivosregistrar },
    ],
  },


  // Corresponde al Queries

  {
    path: 'homes',
    component: Home,
    children: [
      { path: 'buscar', component: Usuariosbuscar, canActivate: [seguridadGuard] },

      {
        path: 'calidad-umbral',
        component: BuscarPorUmbralCalidadDeSueno,
        canActivate: [seguridadGuard],
      },
      {
        path: 'promedio-sueno-todos-usuarios',
        component: promedioSuenoTodosUsuarios,
        canActivate: [seguridadGuard],
      },
      {
        path: 'horas-dormidas-por-usuario-por-registro',
        component: HorasDormidasPorUsuarioPorRegistro,
        canActivate: [seguridadGuard],
      },

      {
        path: 'completados-listar', // URL final: /reportes-seguimiento-habitos/completados-listar
        component: HabitosCompletadosListar,
      },
      {
        path: 'no-completados-listar', // URL final: /reportes-seguimiento-habitos/no-completados-listar
        component: HabitosNoCompletadosListar,
      },
      {
        path: 'reporte-activos',
        component: HabitosActivosPorUsuario,
      },
    ],
  },
];
