import { Component, OnInit } from '@angular/core';
import { Address } from '../model/address';
import { UserProfileService } from '../service/user-profile.service';

@Component({
  selector: 'app-profile-billing',
  templateUrl: './profile-billing.component.html',
  styleUrls: ['./profile-billing.component.css']
})
export class ProfileBillingComponent implements OnInit {


  billingAddress: Address = new Address();
  submitted: boolean = false;
  success: boolean = false;
  failed: boolean = false;
  message: string = "";   

 
  constructor(private userProfileService: UserProfileService) { }


  ngOnInit() {
    this.userProfileService.getProfile().subscribe(
      (data) => {
        let address = JSON.parse(JSON.stringify(data)).billingAddress ;
        console.log(this.billingAddress);
        if(address != null) {
          this.billingAddress = address;
          console.log(this.billingAddress);
        }
      }, (error) => {
          console.log(error);
      }
    );
  }

  save() {
    this.billingAddress.addressType = 1; // billing address
    this.userProfileService.updateBillingAddress(this.billingAddress)
      .subscribe((data) => {
        console.log(data);
        this.success = JSON.parse(JSON.stringify(data)).ok;
        this.message = JSON.parse(JSON.stringify(data)).message;
      }, (error) => {

        this.failed = !JSON.parse(JSON.stringify(error.error)).ok;
        error.error.errors.forEach(element => {
          this.message += element.defaultMessage + "<br/>";
        });
      });
      if(this.success){
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


}
