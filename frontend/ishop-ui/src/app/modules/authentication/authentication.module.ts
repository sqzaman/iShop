import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { SignupComponent } from './components/signup/signup.component';

@NgModule({
  imports: [
    FormsModule,
    CommonModule
  ],
  declarations: [SignupComponent]
})
export class AuthenticationModule { }