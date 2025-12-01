import { Injectable } from '@angular/core';
import { Objetivos } from '../models/Objetivos';
import { OnInit } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { ObjetivosAlcanzadosDTO } from '../models/ObjetivosAlcanzadosDTO';

const base_url = environment.base;

@Injectable({
  providedIn: 'root',
})
export class ObjetivosService implements OnInit {
  private url = `${base_url}/objetivos`;
  private listaCambio = new Subject<Objetivos[]>();

  constructor(private http: HttpClient) {}

  ngOnInit(): void {}

  list() {
    return this.http.get<Objetivos[]>(this.url);
  }

  insert(objetivos: Objetivos): Observable<string> {
    return this.http.post(this.url, objetivos, { responseType: 'text' });
  }

  setList(listaNueva: Objetivos[]) {
    this.listaCambio.next(listaNueva);
  }
  getList() {
    return this.listaCambio.asObservable();
  }

  listId(id: number) {
    return this.http.get<Objetivos>(`${this.url}/${id}`);
  }

  update(objetivos: Objetivos) {
    return this.http.put(`${this.url}`, objetivos, { responseType: 'text' });
  }

  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }
  objetivosAlcanzados(): Observable<ObjetivosAlcanzadosDTO[]> {
    return this.http.get<ObjetivosAlcanzadosDTO[]>(`${this.url}/objetivosAlcanzados`);
  }
}
