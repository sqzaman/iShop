import { Component, OnInit } from '@angular/core';
import {TokenStorage} from '../../../modules/authentication/components/signin/service/token.storage';
import {Router} from '@angular/router';
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
    console.log(this.userLoggedIn);
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

/*
    this.authService.attemptAuth(this.credentials).subscribe(
      (data) => {
        let token = JSON.parse(JSON.stringify(data)).accessToken;
        this.token.saveToken(token);
        window.location.reload();
        this.router.navigate(['profile']);
        //window.location.reload();
      }, (error) => {
        this.failed = true;
        error.error.errors.forEach(element => {
          this.message += element.defaultMessage + "<br/>";
        });
      }
    );
  }
  */
  }

  logout() : void {
    this.token.signOut();
    this.router.navigate(['/']);
    //window.location.href = window.location.href;
    window.location.reload();

  }
}
