import { Injectable } from '@angular/core';
import { OnInit } from '@angular/core';
import { environment } from '../../environments/environment';
import { Estres } from '../models/Estres';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { PromedioEstresDTO } from '../models/PromedioEstresDTO';


const base_url = environment.base;
@Injectable({
  providedIn: 'root',
})
export class EstresService implements OnInit {
  private url = `${base_url}/estres`;
  private listaCambio = new Subject<Estres[]>();

  constructor(private http: HttpClient) {}

  ngOnInit(): void {}

  list() {
      return this.http.get<Estres[]>(this.url);
    }

    insert(estres: Estres): Observable<string> {
      return this.http.post(this.url, estres, { responseType: 'text' });
    }
  
    setList(listaNueva: Estres[]) {
      this.listaCambio.next(listaNueva);
    }
    getList() {
      return this.listaCambio.asObservable();
    }
  
    listId(id: number) {
      return this.http.get<Estres>(`${this.url}/${id}`);
    }

    update(estres: Estres) {
      return this.http.put(`${this.url}`, estres, { responseType: 'text' });
    }
  
    delete(id: number) {
      return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
    }

    promedioEstresTodosUsuarios(): Observable<PromedioEstresDTO[]> {
    return this.http.get<PromedioEstresDTO[]>(`${this.url}/promedio`);
  }
}
