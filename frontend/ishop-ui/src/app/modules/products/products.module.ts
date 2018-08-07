import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CategoriesComponent } from './components/categories/categories.component';
import { ProductsListComponent } from './components/products-list/products-list.component';
import { ProductsComponent } from './components/products/products.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [CategoriesComponent, ProductsListComponent, ProductsComponent]
})
export class ProductsModule { }
