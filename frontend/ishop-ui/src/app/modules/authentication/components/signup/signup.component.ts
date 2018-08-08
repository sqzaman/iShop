import { Component, OnInit } from '@angular/core';
import { User } from './model/user';
import { Error } from './model/error';
import { UserService } from './service/user.service';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  user: User = new User();
  submitted: boolean = false;
  success: boolean = false;
  failed: boolean = false;
  message: string = "";
   

 
  constructor(private userService: UserService) { }


  ngOnInit() {
  }

  newUser(): void {
    this.submitted = false;
    this.user = new User();
  }
 
  save() {
    this.user.username = this.user.email;
    if(this.user.password !=  this.user.confirmPassword){
      this.message = "Password should be matched!"
      this.failed = true;
      return false;
    }
    this.userService.createUser(this.user)
      .subscribe((data) => {
        console.log(data);
        this.success = JSON.parse(JSON.stringify(data)).ok;
        this.message = JSON.parse(JSON.stringify(data)).message;
        this.user = new User();
      }, (error) => {
      //  this.response = new Response(error);
       // this.response = error;
        //console.log(error.error.errors);

        this.failed = !JSON.parse(JSON.stringify(error.error)).ok;

        error.error.errors.forEach(element => {
          this.message += element.defaultMessage + "<br/>";
        });
        //this.message = JSON.parse(JSON.stringify(error.error)).message;
      });
     // console.log("========================");
      //console.log( this.errors);
     // console.log("========================");
      if(this.success){
        this.submitted = true;
        this.user = new User();
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
