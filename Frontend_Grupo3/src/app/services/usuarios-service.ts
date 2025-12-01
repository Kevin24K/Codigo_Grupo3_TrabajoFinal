import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Users } from '../models/Usuarios';

const base_url = environment.base;

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  private url = `${base_url}/users`;
  private listaCambio = new Subject<Users[]>();

  constructor(private http: HttpClient) {}

  list(): Observable<Users[]> {
    return this.http.get<Users[]>(this.url);
  }

  insert(users: Users): Observable<string> {
    return this.http.post(this.url, users, { responseType: 'text' });
  }

  update(users: Users): Observable<string> {
    return this.http.put(this.url, users, { responseType: 'text' });
  }

  delete(id: number): Observable<string> {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }

  listId(id: number): Observable<Users> {
    return this.http.get<Users>(`${this.url}/${id}`);
  }

  setList(listaNueva: Users[]) {
    this.listaCambio.next(listaNueva);
  }

  getList(): Observable<Users[]> {
    return this.listaCambio.asObservable();
  }
<<<<<<< HEAD

  buscarPorUsername(username: string): Observable<Users> {
    // Corresponde a GET /users/buscar/{username}
    return this.http.get<Users>(`${this.url}/buscar/${username}`);
  }
=======
>>>>>>> 025f87f507c1755ca786cb4953a649d705e74a23
}
