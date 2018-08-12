import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Globals } from '../../../../../shared/config/globals.service';

@Injectable({
  providedIn: 'root'
})
export class UserProfileService {

  constructor(private http: HttpClient, private globals: Globals) {
  }

  getProfile(): Observable<Object> {
    return this.http.get(this.globals.BASE_API_URL + "customer/get");
  }

}