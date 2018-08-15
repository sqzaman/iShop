import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductsService } from '../../services/products/products.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  id: number;
  product: object;
  dataLoaded: Promise<boolean>;

  constructor(private route: ActivatedRoute, private service: ProductsService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = +params['id'];
    });
    this.service.getProduct(this.id).subscribe(
      data => {
        this.product = data;
        console.log(this.product);
        this.dataLoaded = Promise.resolve(true);
      }
    )
  }

}
