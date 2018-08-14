import { Component, OnInit } from '@angular/core';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-admin-product',
  templateUrl: './admin-product.component.html',
  styleUrls: ['./admin-product.component.css']
})
export class AdminProductComponent implements OnInit {

  products : Object;

  constructor(private service: AdminService) { }

  ngOnInit() {
    this.service.getProducts().subscribe(
      data => this.products = data
    )
  }

}
