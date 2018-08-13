import { Component, OnInit } from '@angular/core';
import { UserProfileService } from '../service/user-profile.service';
/*import { Router,ActivatedRoute } from '@angular/router';*/

@Component({
 // selector: 'app-profile-edit',
  templateUrl: './profile-edit.component.html',
  //styleUrls: ['./profile-edit.component.css']
})
export class ProfileEditComponent implements OnInit {

  /*
  constructor(private _Activatedroute:ActivatedRoute,
    private _router:Router ){
}
*/

userProfile: any;
submitted: boolean = false;
success: boolean = false;
failed: boolean = false;
message: string = "";
constructor(private userProfileService: UserProfileService){
}

  ngOnInit() {
    this.userProfileService.getProfile().subscribe(
      (data) => {
        this.userProfile = data;
        //this.router.navigate(['profile']);

      }, (error) => {
          console.log(error);
      }
    );
  }


  save() {
    this.userProfileService.updateProfile(this.userProfile)
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
