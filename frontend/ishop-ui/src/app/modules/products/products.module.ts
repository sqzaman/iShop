import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { CategoriesComponent } from './components/categories/categories.component';
import { ProductsListComponent } from './components/products-list/products-list.component';
import { ProductsComponent } from './components/products/products.component';
import { Globals } from '../../shared/config/globals.service';
import { ProductComponent } from './components/product/product.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    Globals
  ],
  declarations: [CategoriesComponent, ProductsListComponent, ProductsComponent, ProductComponent]
})
export class ProductsModule { }
