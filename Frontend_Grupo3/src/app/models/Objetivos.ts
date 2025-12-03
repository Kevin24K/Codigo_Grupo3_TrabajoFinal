import { Users } from "./Usuarios";

export class Objetivos {
    idObjetivos: number = 0;
    nombreObjetivo: string = "";
    tipoObjetivo: string = "";
    descripcion: string = "";
    valorObjetivo: number = 0;
    valorActual: number = 0;
    fechaInicio: Date = new Date()
    fechaFin: Date = new Date();
    alcanzado: boolean = false;
    idUsuario: Users = new Users();
}