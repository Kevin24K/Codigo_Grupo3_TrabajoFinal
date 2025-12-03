import { Users } from './Usuarios';

export class Sueno {
  idSueno: number = 0;
  fechaRegistro: string = '';
  horaAcostarse: string = '';
  horaDespertar: string = '';
  calidadSueno: number = 0;
  interrupciones: number = 0;
  cafeinaConsumida: boolean = false;
  notas: string = '';
  idUsuario: Users = new Users();
}