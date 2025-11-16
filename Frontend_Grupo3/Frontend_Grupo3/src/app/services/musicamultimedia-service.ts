import { Injectable, OnInit } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Musicamultimedia } from '../models/MusicaMultimedia';

const base_url=environment.base
@Injectable({
  providedIn: 'root',
})

export class MusicaMultimediaService implements OnInit{
    private url = `${base_url}/musicasMultimedia`;
    private listaCambio = new Subject<Musicamultimedia[]>();

    constructor(private http: HttpClient) {}

    ngOnInit(): void {}
    
    list() {
    return this.http.get<Musicamultimedia[]>(this.url);
    }

    insert(d: Musicamultimedia): Observable<string> {
    return this.http.post(this.url, d, { responseType: 'text' });
    }

    setList(listaNueva: Musicamultimedia[]) {
    this.listaCambio.next(listaNueva);
    }
    getList() {
    return this.listaCambio.asObservable();
    }

    listId(id: number) {
    return this.http.get<Musicamultimedia>(`${this.url}/${id}`);
    }

    update(d: Musicamultimedia) {
    return this.http.put(`${this.url}`, d, { responseType: 'text' });
    }

    delete(id: number) {
    return this.http.delete(`${this.url}/${id}`,{ responseType: 'text' })
    }
}