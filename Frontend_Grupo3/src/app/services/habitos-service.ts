import { Injectable, OnInit } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Habitos } from '../models/Habitos';
import { HabitosActivosPorUsuarioDTO } from '../models/habitos-activos-por-usuario-dto';


const base_url = environment.base;
@Injectable({
  providedIn: 'root',
})
export class HabitosService implements OnInit {
  private url = `${base_url}/habitos`;
  private listaCambio = new Subject<Habitos[]>();

  constructor(private http: HttpClient) {}

  ngOnInit(): void {}

  list() {
    return this.http.get<Habitos[]>(this.url);
  }

  insert(habitos: Habitos): Observable<string> {
    return this.http.post(this.url, habitos, { responseType: 'text' });
  }

  setList(listaNueva: Habitos[]) {
    this.listaCambio.next(listaNueva);
  }
  getList() {
    return this.listaCambio.asObservable();
  }

  listId(id: number) {
    return this.http.get<Habitos>(`${this.url}/${id}`);
  }

  update(habitos: Habitos) {
    return this.http.put(`${this.url}`, habitos, { responseType: 'text' });
  }

  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }

  HabitosActivosParaUnUsuario(id: number): Observable<HabitosActivosPorUsuarioDTO[]> {
    return this.http.get<HabitosActivosPorUsuarioDTO[]>(`${this.url}/HabitosActivosporUsuario?id=${id}`);
  }

}
