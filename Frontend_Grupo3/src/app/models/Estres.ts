import { Users } from "./Usuarios";

export class Estres {
    idEstres: number = 0;
    nivelEstres: number = 0;
    nivelAnsiedad: number = 0;
    factoresEstimulantes: string = "";
    sintomasFisicos: string = "";
    sintomasEmocionales: string = "";
    fechaRegistro: Date = new Date();
    idUsuario: Users = new Users();
}
