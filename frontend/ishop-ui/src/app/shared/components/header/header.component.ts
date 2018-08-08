import { Component, OnInit } from '@angular/core';
import {TokenStorage} from '../../../modules/authentication/components/signin/service/token.storage';
import {Router} from '@angular/router';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  userLoggedIn: boolean;
  constructor(private router: Router, private token: TokenStorage ) { 

    this.userLoggedIn = token.isUserLoggedIn();
  }

  ngOnInit() {
    console.log(this.userLoggedIn);
  }

  logout() : void {
    this.token.signOut();
    this.router.navigate(['/']);
    //window.location.href = window.location.href;
    window.location.reload();

  }
}
