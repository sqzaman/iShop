import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../../services/cart.service';
import { LocaleStorageService } from '../../../../shared/general-services/locale-storage.service';
declare let swal: any;

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cart: object;
  dataLoaded: Promise<boolean>;
  cartExist: boolean;

  constructor(private service: CartService, 
    private localeStorage: LocaleStorageService,
    private router: Router
  ) { }

  ngOnInit() {
    let cart_id = this.localeStorage.getCartId();
    if(cart_id != null){
      this.cartExist = true;
      this.service.getCart(cart_id).subscribe(
        data =>  {
          this.cart = data;
          this.dataLoaded = Promise.resolve(true);
        }
      );
    }else{
      this.cartExist = false;
    }
  }

  checkout() {
    this.service.checkout().subscribe(
      data => { 
        console.log(data);
        this.localeStorage.clearCart();
        swal("Done!", "Oredr is placed successfly!", "success");
        this.router.navigateByUrl('orders');
      }
    )
    
  }

}
