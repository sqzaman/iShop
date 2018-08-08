import { Component, OnInit } from '@angular/core';
import { CategoriesService } from '../../services/categories/categories.service';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  categories : Object;

  constructor(private service: CategoriesService) { }

  ngOnInit() {
    this.service.getCategories().subscribe(
      data => this.categories = data
    )
  }

}
