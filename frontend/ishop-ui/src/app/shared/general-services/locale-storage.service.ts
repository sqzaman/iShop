import { Injectable } from '@angular/core';

const CART_KEY = 'cartId';

@Injectable({
  providedIn: 'root'
})
export class LocaleStorageService {

  constructor() { }

  public saveCartId(cart_id: string) {
    window.sessionStorage.removeItem(CART_KEY);
    window.sessionStorage.setItem(CART_KEY,  cart_id);
  }

  public getCartId(): string {
    return window.sessionStorage.getItem(CART_KEY);
  }

  public clearCart() {
    window.sessionStorage.removeItem(CART_KEY);
  }

}
