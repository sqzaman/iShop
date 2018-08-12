import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
 
@Injectable({
  providedIn: 'root'
})
export class UserService {
 
  private baseUrl = 'http://localhost:8080/api/customer';
 
  constructor(private http: HttpClient) { }
 
  getUser(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
 
  createUser(user: Object): Observable<Object> {
    console.log(user);
    return this.http.post(`${this.baseUrl}` + `/signup`, user);
  }
 
  updateUser(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }
 
  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
 
  getUsersList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
  
  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }
}