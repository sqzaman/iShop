import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {TokenStorage} from '../../../modules/authentication/components/signin/service/token.storage';
import {Role} from "../model/role";
import {AuthService} from '../../../modules/authentication/components/signin/service/auth.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  userLoggedIn: boolean;
  roles: Object;
  isAdmin: boolean;

  constructor(private router: Router, private token: TokenStorage, private authService: AuthService,) { 

    this.userLoggedIn = token.isUserLoggedIn();
  }

  ngOnInit() {
    //console.log(this.userLoggedIn);
    this.authService.getRole().subscribe(
      (data) => {
        this.roles = data;
        for(var k in this.roles) {
          if(this.roles[k].authority.includes("ADMIN")){
            this.isAdmin = true;
            break;
          }
       }
        //console.log(this.roles)
      }, (error) => {
        console.log(error)
      }
  );
  }

  logout() : void {
    this.token.signOut();
    this.router.navigate(['/home']);
    //window.location.href = window.location.href;
    window.location.reload();

  }
}
