import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../../services/category_services/category.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  categories : Object;

  constructor(private data: CategoryService) { }

  ngOnInit() {
    this.data.getCategories().subscribe(
      data => this.categories = data
    )
  }

}
