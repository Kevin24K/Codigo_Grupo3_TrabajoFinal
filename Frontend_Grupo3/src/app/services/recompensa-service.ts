import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Recompensa } from '../models/Recompensa';

const base_url = environment.base;

@Injectable({
  providedIn: 'root',
})
export class RecompensaService {
  private url = `${base_url}/recompensas`;
  private listaCambio = new Subject<Recompensa[]>();

  constructor(private http: HttpClient) {}

  list(): Observable<Recompensa[]> {
    return this.http.get<Recompensa[]>(this.url);
  }

  insert(recompensa: Recompensa): Observable<string> {
    return this.http.post(this.url, recompensa, { responseType: 'text' });
  }

  update(recompensa: Recompensa): Observable<string> {
    return this.http.put(this.url, recompensa, { responseType: 'text' });
  }

  delete(id: number): Observable<string> {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' }); 
  }

  listId(id: number): Observable<Recompensa> {
    return this.http.get<Recompensa>(`${this.url}/${id}`);
  }

  setList(listaNueva: Recompensa[]) {
    this.listaCambio.next(listaNueva);
  }

  getList(): Observable<Recompensa[]> {
    return this.listaCambio.asObservable();
  }
}
