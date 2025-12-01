import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Sueno } from '../models/Sueno';
import { HorasDormidasDTO } from '../models/HorasDormidasDTO';
import { PromedioSuenoDTO } from '../models/PromedioSuenoDTO';

const base_url = environment.base;

@Injectable({
  providedIn: 'root',
})
export class SuenoService {
  private url = `${base_url}/suenos`;
  private listaCambio = new Subject<Sueno[]>();

  constructor(private http: HttpClient) {}

  // CRUD BÁSICO
  list() {
    return this.http.get<Sueno[]>(this.url);
  }

  insert(sueno: Sueno): Observable<string> {
    return this.http.post(this.url, sueno, { responseType: 'text' });
  }

  listId(id: number) {
    return this.http.get<Sueno>(`${this.url}/${id}`);
  }

  update(sueno: Sueno) {
    return this.http.put(this.url, sueno, { responseType: 'text' });
  }

  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }

  // MANEJO DE ESTADO (REFRESH)
  setList(listaNueva: Sueno[]) {
    this.listaCambio.next(listaNueva);
  }

  getList() {
    return this.listaCambio.asObservable();
  }

  BuscarPorUmbralCalidadDeSueno(umbral: number): Observable<Sueno[]> {
    return this.http.get<Sueno[]>(`${this.url}/por-calidad?umbral=${umbral}`);
  }

  promedioSuenoTodosUsuarios(): Observable<PromedioSuenoDTO[]> {
    return this.http.get<PromedioSuenoDTO[]>(`${this.url}/promedios`);
  }

  horasDormidasPorUsuarioPorRegistro(): Observable<HorasDormidasDTO[]> {
    return this.http.get<HorasDormidasDTO[]>(`${this.url}/horasdormidas`);
  }
}
