import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { TipoMusica } from '../models/TipoMusica';

const base_url = environment.base;

@Injectable({
  providedIn: 'root',
})
export class TipoMusicaService {
  private url = `${base_url}/tipoMusica`;
  private listaCambio = new Subject<TipoMusica[]>();

  constructor(private http: HttpClient) {}

  list(): Observable<TipoMusica[]> {
    return this.http.get<TipoMusica[]>(this.url);
  }

  insert(tipoMusica: TipoMusica): Observable<string> {
    return this.http.post(this.url, tipoMusica, { responseType: 'text' });
  }

  update(tipoMusica: TipoMusica): Observable<string> {
    return this.http.put(this.url, tipoMusica, { responseType: 'text' });
  }

  delete(id: number): Observable<string> {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' }); 
  }

  listId(id: number): Observable<TipoMusica> {
    return this.http.get<TipoMusica>(`${this.url}/${id}`);
  }

  setList(listaNueva: TipoMusica[]) {
    this.listaCambio.next(listaNueva);
  }

  getList(): Observable<TipoMusica[]> {
    return this.listaCambio.asObservable();
  }
}
