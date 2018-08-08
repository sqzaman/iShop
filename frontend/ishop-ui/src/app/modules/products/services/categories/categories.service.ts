import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Globals } from '../../../../shared/config/globals.service';

@Injectable({
  providedIn: 'root'
})
export class CategoriesService {

  constructor(private http: HttpClient, private globals: Globals) { }

  getCategories() {
    return this.http.get(this.globals.BASE_API_URL+"product/category/get");
  }
}
