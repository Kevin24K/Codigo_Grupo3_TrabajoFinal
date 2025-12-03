import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { SeguimientoHabitos } from '../models/SeguimientoHabitos';

const base_url = environment.base;

@Injectable({
  providedIn: 'root',
})
export class SeguimientoHabitoService {
  private url = `${base_url}/seguimiento-habitos`;
  private listaCambio = new Subject<SeguimientoHabitos[]>();

  constructor(private http: HttpClient) {}

  // Listar seguimientos de un hábito y un usuario específicos
  list(idHabito: number, idUsuario: number): Observable<SeguimientoHabitos[]> {
    return this.http.get<SeguimientoHabitos[]>(`${this.url}/listar/${idHabito}/${idUsuario}`);
  }

  // Insertar un nuevo seguimiento
  insert(idHabito: number, idUsuario: number, seguimientoHabitos: SeguimientoHabitos): Observable<string> {
    return this.http.post(`${this.url}/registrar/${idHabito}/${idUsuario}`, seguimientoHabitos, { responseType: 'text' });
  }

  // Actualizar un seguimiento
  update(idHabito: number, idUsuario: number, seguimientoHabitos: SeguimientoHabitos): Observable<string> {
    return this.http.put(
      `${this.url}/editar/${idHabito}/${idUsuario}/${seguimientoHabitos.idSeguimientoHabitos}`,
      seguimientoHabitos,
      { responseType: 'text' }
    );
  }

  // Eliminar un seguimiento
  delete(idHabito: number, idUsuario: number, id: number): Observable<string> {
    return this.http.delete(`${this.url}/eliminar/${idHabito}/${idUsuario}/${id}`, { responseType: 'text' });
  }

  // Obtener un seguimiento por ID
  listId(id: number): Observable<SeguimientoHabitos> {
    return this.http.get<SeguimientoHabitos>(`${this.url}/editar/${id}`);
  }

  // Establecer nueva lista de seguimientos
  setList(listaNueva: SeguimientoHabitos[]) {
    this.listaCambio.next(listaNueva);
  }

  // Obtener la lista de seguimientos
  getList(): Observable<SeguimientoHabitos[]> {
    return this.listaCambio.asObservable();
  }
}
