import { Component, OnInit } from '@angular/core';
import { CategoriesService } from '../../products/services/categories/categories.service';

@Component({
  selector: 'app-admin-product-category',
  templateUrl: './admin-product-category.component.html',
  styleUrls: ['./admin-product-category.component.css']
})
export class AdminProductCategoryComponent implements OnInit {

  categories : Object;

  constructor(private service: CategoriesService) { }

  ngOnInit() {
    this.service.getCategories().subscribe(
      data => this.categories = data
    )
  }

}
