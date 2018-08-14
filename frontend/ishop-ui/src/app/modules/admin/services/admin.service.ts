import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Globals } from '../../../shared/config/globals.service';
import { ProductCategory } from '../model/product-category';
import { Product } from '../model/product';


@Injectable({
  providedIn: 'root'
})
export class AdminService{



  constructor(private http: HttpClient, private globals: Globals) {
  }

  getProfile(): Observable<Object> {
    return this.http.get(this.globals.BASE_API_URL + "customer/get");
  }
  
  saveCategory(category: ProductCategory, categoryId: number ): Observable<Object> {
    let url = "";
    if(categoryId == null) {
      url = this.globals.BASE_API_URL + "product/category/add";
    } else {
      url = this.globals.BASE_API_URL + "product/category/update/" + categoryId;
    }

    return this.http.post(url, category);
  }
  addNewCategory(category: ProductCategory ): Observable<Object> {
    return this.http.post(this.globals.BASE_API_URL + "product/category/add", category);
  }

  getCategory(id: number ): Observable<Object> {
    return this.http.get(this.globals.BASE_API_URL + "product/category/get/" + id);
  }

  getProducts(): Observable<Object> {
    return this.http.get(this.globals.BASE_API_URL+"product/get");
  }

  getProduct(id: Number ): Observable<Object> {
    return this.http.get(this.globals.BASE_API_URL + "product/getById/" + id);
  }

  saveProduct(product: Product, productId: number ): Observable<Object> {
    let url = "";
    if(productId == null) {
      url = this.globals.BASE_API_URL + "product/add";
    } else {
      url = this.globals.BASE_API_URL + "product/update/" + productId;
    }

    return this.http.post(url, product);
  }

  getCategories() {
    return this.http.get(this.globals.BASE_API_URL+"product/category/get");
  }

  postFile(fileToUpload: File, productId: Number): Observable<Object> {
   // let endpoint = 'http://localhost:9091/uploadFile/' + productId;
   let endpoint = this.globals.BASE_API_URL + 'product/uploadFile/' + productId;
    const formData: FormData = new FormData();
    formData.append('file', fileToUpload, fileToUpload.name);
    return this.http.post(endpoint, formData);//, { headers: yourHeadersConfig });
}
}
