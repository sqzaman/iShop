import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import {TokenStorage} from './modules/authentication/components/signin/service/token.storage';

const TOKEN_HEADER_KEY = 'Authorization';

@Injectable({
    providedIn: 'root'
  })
export class JwtInterceptor implements HttpInterceptor {
    userLoggedIn: boolean;
    accessToken: string = '';
    constructor(private token: TokenStorage ) {   
        this.accessToken = token.getToken()
        this.userLoggedIn =  this.accessToken != null;
    }
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // add authorization header with jwt token if available
        if (this.userLoggedIn && this.accessToken) {
            request = request.clone({
                setHeaders: { 
                    Authorization: `Bearer ${this.accessToken}`
                }
            });
        }

        return next.handle(request);
    }
}