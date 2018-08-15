import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Globals } from '../../../shared/config/globals.service';
import { LocaleStorageService } from '../../../shared/general-services/locale-storage.service';


@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http: HttpClient, 
    private globals: Globals,
    private localeStorage: LocaleStorageService
  ) { }

  getCart(id: string) {
    return this.http.get(this.globals.BASE_API_URL+"shopping/getCart/"+id);
  }

  checkout() {
    return this.http.post(this.globals.BASE_API_URL+"shopping/cart/checkout/"+this.localeStorage.getCartId(), {});
  }

}
