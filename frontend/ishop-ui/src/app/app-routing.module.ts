import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LandingPageComponent } from './modules/home/components/landing-page/landing-page.component';
import { ProductsComponent } from './modules/products/components/products/products.component';
import { OrdersComponent } from './modules/orders/components/orders/orders.component';
import { SignupComponent } from './modules/authentication/components/signup/signup.component'
import { SigninComponent } from './modules/authentication/components/signin/signin.component'
import { ProfileComponent } from './modules/authentication/components/profile/profile.component'
const routes: Routes = [
    {
        path: '',
        component: LandingPageComponent
    },
    {
        path: 'products',
        component: ProductsComponent
    },
    {
        path: 'orders',
        component: OrdersComponent
    },
    {
        path: 'signup',
        component: SignupComponent
    },
    {
        path: 'signin',
        component: SigninComponent
    }
    ,
    {
        path: 'profile',
        component: ProfileComponent
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }