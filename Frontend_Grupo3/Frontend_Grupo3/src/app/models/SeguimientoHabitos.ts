import { Users } from "./Usuarios";
import { Habitos } from "./Habitos";

export class SeguimientoHabitos {
    idSeguimientoHabitos: number = 0;
    completado: boolean = false;
    calidadEjecucion: number = 0;
    notas: string = "";
    fechaSeguimiento: Date = new Date();
    idUsuario: Users = new Users();
    idHabito: Habitos = new Habitos();
}
