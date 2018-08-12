import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';

@Component({
 // selector: 'app-profile-edit',
  templateUrl: './profile-edit.component.html',
  //styleUrls: ['./profile-edit.component.css']
})
export class ProfileEditComponent implements OnInit {

  constructor(private _Activatedroute:ActivatedRoute,
    private _router:Router ){
}


  ngOnInit() {
  }

}
