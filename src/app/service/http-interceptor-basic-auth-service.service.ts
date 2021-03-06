import { HttpClient, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorBasicAuthServiceService {

  authenticated = false;

  constructor(private http: HttpClient) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

   // let username='test1';
   //let password='1234';
    //let basicchaine='Basic '+window.btoa(username+':'+password);

    let basicchaine=sessionStorage.getItem('token');
if(basicchaine)
{
    req=req.clone({
      setHeaders:{
        Authorization: basicchaine
      }
    })
}


    return next.handle(req);
  }

  
}
