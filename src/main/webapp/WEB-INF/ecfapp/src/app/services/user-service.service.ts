import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, Observer} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  port: number = 8080;


  constructor(private http: HttpClient) { }

  public login(username: string, password: string): Observable<any> {
    return this.http.post(`http://localhost:${this.port}/login`, {
      username,
      password
    });
  }

  public register(username: string, password: string): Observable<any> {
    return this.http.post(`http://localhost:${this.port}/register`, {
      username,
      password
    });
  }

  private getAuthenticatedHttpOptions(): any {
    const token = sessionStorage.getItem('token');
    if (token) {
      return {
        headers: new HttpHeaders({
          Authorization: `Basic ${token}`,
          'Content-Type': 'application/json'
        })
      };
    }
    return undefined;
  }
  
}
