import { Component, OnInit } from '@angular/core';
import { UserProfileService } from '../service/user-profile.service';

@Component({
  selector: 'app-profile-overview',
  templateUrl: './profile-overview.component.html',
  styleUrls: ['./profile-overview.component.css']
})
export class ProfileOverviewComponent implements OnInit {

  userProfile: any;
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

}
