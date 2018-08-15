import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LocaleStorageService } from '../../../../shared/general-services/locale-storage.service';
import { ProductsService } from '../../services/products/products.service';
declare let swal: any;

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  id: number;
  quantity: string;
  product: object;
  cart: object;
  dataLoaded: Promise<boolean>;

  constructor(private router: Router,
    private route: ActivatedRoute, 
    private service: ProductsService, 
    private localeStorage: LocaleStorageService
  ) { }

  ngOnInit() {
    this.quantity = "1";
    this.route.params.subscribe(params => {
      this.id = +params['id'];
    });
    this.service.getProduct(this.id).subscribe(
      data => {
        this.product = data;
        this.dataLoaded = Promise.resolve(true);
      }
    )
  }

  addProductToCart(product_id) {
    this.service.addProductToCart(product_id, this.quantity).subscribe(
      data =>  {
        this.cart = data;
        this.localeStorage.saveCartId(data["cartId"]);
        swal("Done!", "Product added successfly to cart!", "success");
        this.router.navigateByUrl('products');
      }
    )
  }

}
