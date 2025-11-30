import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { JwtRequestDTO } from '../models/jwtRequestDTO';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpClient) {}

  private isBrowser(): boolean {
    return typeof window !== 'undefined' && typeof window.sessionStorage !== 'undefined';
  }

  login(request: JwtRequestDTO) {
    return this.http.post('http://localhost:8080/login', request);
  }

  verificar() {
    if (this.isBrowser()) {
      let token = sessionStorage.getItem('token');
      return token != null;
    }
    return false;  
  }

  showRole() {
    if (this.isBrowser()) {
      let token = sessionStorage.getItem('token');
      if (!token) {
        return null;
      }
      const helper = new JwtHelperService();
      const decodedToken = helper.decodeToken(token);
      return decodedToken?.role;
    }
    return null; 
  }
}
