import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { SignupComponent } from './components/signup/signup.component';
import { SigninComponent } from './components/signin/signin.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ProfileEditComponent } from './components/profile/profile-edit/profile-edit.component';
import { ProfileOverviewComponent } from './components/profile/profile-overview/profile-overview.component';

@NgModule({
  imports: [
    FormsModule,
    CommonModule,
    RouterModule
  ],
  declarations: [SignupComponent, SigninComponent, ProfileComponent, ProfileEditComponent, ProfileOverviewComponent]
})
export class AuthenticationModule { }