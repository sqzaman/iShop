import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { SignupComponent } from './components/signup/signup.component';
import { SigninComponent } from './components/signin/signin.component';
import { ProfileComponent } from './components/profile/profile.component';

@NgModule({
  imports: [
    FormsModule,
    CommonModule
  ],
  declarations: [SignupComponent, SigninComponent, ProfileComponent]
})
export class AuthenticationModule { }