import { Component, OnInit } from '@angular/core';
import { ProductsService } from '../../services/products/products.service';

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css']
})
export class ProductsListComponent implements OnInit {

  products : Object;

  constructor(private service: ProductsService) { }

  ngOnInit() {
    this.service.getProducts().subscribe(
      data => this.products = data
    )
  }

}
