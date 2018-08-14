import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { ProductCategory } from '../../model/product-category';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-new-category',
  templateUrl: './new-category.component.html',
  styleUrls: ['./new-category.component.css']
})
export class NewCategoryComponent implements OnInit {

  category: any = new ProductCategory();
  submitted: boolean = false;
  success: boolean = false;
  failed: boolean = false;
  message: string = "";
  categoryId: number = null;
  pageHeading: string = "New Category";
  sub;

  constructor(private adminService: AdminService, public route: ActivatedRoute) {
    this.sub = this.route.url.subscribe(params => {
      if (params[1].path == 'edit') {
        this.categoryId = Number.parseInt(params[2].path);
        this.pageHeading = "Update Category";
      }

    })
  }

  ngOnInit() {
    if (this.categoryId != null) {
      this.adminService.getCategory(this.categoryId).subscribe(
        (data) => {
          this.category = data;
        }, (error) => {
        }
      )
    }
  }

  save() {

    this.adminService.saveCategory(this.category, this.categoryId)
      .subscribe((data) => {

        let retObj = JSON.parse(JSON.stringify(data));
        this.success = retObj.ok != undefined ? retObj.ok : retObj.success;
        this.message = JSON.parse(JSON.stringify(data)).message;
        this.category = new ProductCategory()
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
