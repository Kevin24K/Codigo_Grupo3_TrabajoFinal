import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UsuariosHabitosDTO } from '../models/UsuariosHabitosDTO';

const base_url = environment.base;

@Injectable({
  providedIn: 'root',
})
export class ReportesSeguimientoService {
  private url = `${base_url}/seguimiento-habitos`;

  constructor(private http: HttpClient) {}

  // Reporte 1: Hábitos Completados por Usuario
  getHabitosCompletados(): Observable<UsuariosHabitosDTO[]> {
    return this.http.get<UsuariosHabitosDTO[]>(
      `${this.url}/habitoscompletadosPorUsuario`
    );
  }

  // Reporte 2: Hábitos No Completados por Usuario
  getHabitosNoCompletados(): Observable<UsuariosHabitosDTO[]> {
    return this.http.get<UsuariosHabitosDTO[]>(
      `${this.url}/habitosNocompletadosPorUsuario`
    );
  }
}