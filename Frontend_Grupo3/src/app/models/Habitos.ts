import { Users } from './Usuarios';

export class Habitos {
  idHabitos: number = 0;
  nombreHabito: string = '';
  descripcion: string = '';
  categoria: string = '';
  momentoDia: string = '';
  activo: boolean = true;
  idUsuario: Users = new Users();
}
