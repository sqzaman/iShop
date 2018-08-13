import { Component, OnInit } from '@angular/core';
import { Address } from '../model/address';
import { UserProfileService } from '../service/user-profile.service';

@Component({
  selector: 'app-profile-shipping',
  templateUrl: './profile-shipping.component.html',
  styleUrls: ['./profile-shipping.component.css']
})
export class ProfileShippingComponent implements OnInit {

 
  shiipingAddress: Address = new Address();
  submitted: boolean = false;
  success: boolean = false;
  failed: boolean = false;
  message: string = "";   

 
  constructor(private userProfileService: UserProfileService) { }


  ngOnInit() {
    this.userProfileService.getProfile().subscribe(
      (data) => {
        let address = JSON.parse(JSON.stringify(data)).shiipingAddress ;
        console.log(this.shiipingAddress);
        if(address != null) {
          this.shiipingAddress = address;
          console.log(this.shiipingAddress);
        }
      }, (error) => {
          console.log(error);
      }
    );
  }

  save() {
    this.shiipingAddress.addressType = 0; // shipping address
    this.userProfileService.updateBillingAddress(this.shiipingAddress)
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
