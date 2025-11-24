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

  list(): Observable<SeguimientoHabitos[]> {
    return this.http.get<SeguimientoHabitos[]>(this.url);
  }

  insert(seguimientoHabitos: SeguimientoHabitos): Observable<string> {
    return this.http.post(this.url, seguimientoHabitos, { responseType: 'text' });
  }

  listByHabit(idHabito: number): Observable<SeguimientoHabitos[]> {
    return this.http.get<SeguimientoHabitos[]>(`${this.url}/habito/${idHabito}`);
  }

  update(seguimientoHabitos: SeguimientoHabitos): Observable<string> {
    return this.http.put(this.url, seguimientoHabitos, { responseType: 'text' });
  }

  delete(id: number): Observable<string> {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' }); 
  }

  listId(id: number): Observable<SeguimientoHabitos> {
    return this.http.get<SeguimientoHabitos>(`${this.url}/${id}`);
  }

  setList(listaNueva: SeguimientoHabitos[]) {
    this.listaCambio.next(listaNueva);
  }

  getList(): Observable<SeguimientoHabitos[]> {
    return this.listaCambio.asObservable();
  }
}
