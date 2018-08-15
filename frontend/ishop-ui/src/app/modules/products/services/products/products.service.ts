import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Globals } from '../../../../shared/config/globals.service';
import { LocaleStorageService } from '../../../../shared/general-services/locale-storage.service';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http: HttpClient, 
    private globals: Globals, 
    private localStorage: LocaleStorageService) { }

  getProducts() {
    return this.http.get(this.globals.BASE_API_URL+"product/get");
  }

  getProduct(id: number) {
    return this.http.get(this.globals.BASE_API_URL+"product/get/"+id);
  }

  getProductByCategory(id: number) {
    return this.http.get(this.globals.BASE_API_URL+"product/category/get/"+id);
  }
  
  addProductToCart(product_id: string, quantity: string) {
    let cart_id = this.localStorage.getCartId();
    if( cart_id != null) {
      return this.http.post(
        this.globals.BASE_API_URL+"shopping/addToCart", 
        {productId: product_id, quantity: quantity, cartId: cart_id}
      );
    } else {
      return this.http.post(
        this.globals.BASE_API_URL+"shopping/addToCart", 
        {productId: product_id, quantity: quantity}
      );
    }
  }
}
