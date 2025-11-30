import { Injectable, OnInit } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { ObjetivosRecompensas } from '../models/ObjetivosRecompensas';

const base_url=environment.base
@Injectable({
  providedIn: 'root',
})

export class ObjetivosRecompensasService implements OnInit{
    private url = `${base_url}/objetivosrecompensas`;
    private listaCambio = new Subject<ObjetivosRecompensas[]>();

    constructor(private http: HttpClient) {}

    ngOnInit(): void {}
    
    list() {
    return this.http.get<ObjetivosRecompensas[]>(this.url);
    }

    insert(objetivosrecompensas: ObjetivosRecompensas): Observable<string> {
    return this.http.post(this.url, objetivosrecompensas, { responseType: 'text' });
    }

    setList(listaNueva: ObjetivosRecompensas[]) {
    this.listaCambio.next(listaNueva);
    }
    getList() {
    return this.listaCambio.asObservable();
    }

    listId(id: number) {
    return this.http.get<ObjetivosRecompensas>(`${this.url}/${id}`);
    }

    update(objetivosrecompensas:ObjetivosRecompensas) {
    return this.http.put(`${this.url}`, objetivosrecompensas, { responseType: 'text' });
    }

    delete(id: number) {
    return this.http.delete(`${this.url}/${id}`,{ responseType: 'text' })
    }
}