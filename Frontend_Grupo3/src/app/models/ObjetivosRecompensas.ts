import { Objetivos } from "./Objetivos";
import { Recompensa } from "./Recompensa";

export class ObjetivosRecompensas{

    idObjetivosRecompensas: number = 0;
    fechaObtencion: string = '';
    idRecompensa: Recompensa = new Recompensa();
    idObjetivo: Objetivos = new Objetivos();
}