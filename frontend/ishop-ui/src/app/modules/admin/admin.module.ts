import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AdminOverviewComponent } from './admin-overview/admin-overview.component';
import { AdminProductComponent } from './admin-product/admin-product.component';
import { AdminProductCategoryComponent } from './admin-product-category/admin-product-category.component';
import { AdminComponent } from './admin/admin.component';
import { NewCategoryComponent } from './admin-product-category/new-category/new-category.component';
import { NewProductComponent } from './admin-product/new-product/new-product.component';
import { UploadProductImageComponent } from './admin-product/upload-product-image/upload-product-image.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  declarations: [AdminOverviewComponent, AdminProductComponent, AdminProductCategoryComponent, AdminComponent, NewCategoryComponent, NewProductComponent, UploadProductImageComponent]
})
export class AdminModule { }
