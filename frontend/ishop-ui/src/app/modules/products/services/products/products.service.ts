import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Globals } from '../../../../shared/config/globals.service';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http: HttpClient, private globals: Globals) { }

  getProducts() {
    return this.http.get(this.globals.BASE_API_URL+"product/get");
  }

  getProduct(id: number) {
    return this.http.get(this.globals.BASE_API_URL+"product/get/"+id);
  }

  getProductByCategory(id: number) {
    return this.http.get(this.globals.BASE_API_URL+"product/category/get/"+id);
  }
}
