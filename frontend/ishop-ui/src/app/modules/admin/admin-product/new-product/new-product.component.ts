import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { Product } from '../../model/product';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-new-product',
  templateUrl: './new-product.component.html',
  styleUrls: ['./new-product.component.css']
})
export class NewProductComponent implements OnInit {

  product: any = new Product();
  submitted: boolean = false;
  success: boolean = false;
  failed: boolean = false;
  message: string = "";
  productId: number = null;
  pageHeading: string = "New Product";
  productCategories: Object;
  sub;

  constructor(private adminService: AdminService, public route: ActivatedRoute) {
    this.sub = this.route.url.subscribe(params => {
      if (params[1].path == 'edit') {
        this.productId = Number.parseInt(params[2].path);
        this.pageHeading = "Update Product";
      }

    })
  }

  ngOnInit() {
    if (this.productId != null) {
      this.adminService.getProduct(this.productId).subscribe(
        (data) => {
          this.product = data;
        }, (error) => {
        }
      )
    }
    this.adminService.getCategories().subscribe(
      (data) => {
          this.productCategories = data;
      }, (error) => {
          console.log(error);
      }
    )

  }

  save() {

    this.adminService.saveProduct(this.product, this.productId)
      .subscribe((data) => {

        let retObj = JSON.parse(JSON.stringify(data));
        this.success = retObj.ok != undefined ? retObj.ok : retObj.success;
        this.message = JSON.parse(JSON.stringify(data)).message;
        this.product = new Product()
      }, (error) => {
        let errorObject = JSON.parse(JSON.stringify(error.error));
        this.failed = !errorObject.ok;
        if (errorObject.message) {
          this.message = errorObject.message;
        } else {

          error.error.errors.forEach(element => {
            this.message += element.defaultMessage + "<br/>";
          });
        }

      });
    if (this.success) {
      this.submitted = true;
    }

  }

  onSubmit() {
    //this.submitted = true;
    this.success = false;
    this.failed = false;
    this.message = "";
    this.save();
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

}
