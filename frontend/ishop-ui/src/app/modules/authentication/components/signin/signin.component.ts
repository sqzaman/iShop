import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from './service/auth.service';
import {TokenStorage} from './service/token.storage';
import { Credentials } from './model/credentials';


@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  credentials: Credentials = new Credentials();
  success: boolean = false;
  failed: boolean = false;
  message: string = "";

  constructor(private router: Router, private authService: AuthService, private token: TokenStorage) {
  }

  ngOnInit() {
  }

  login(): void {
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
}
