import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';




@Injectable({
  providedIn: 'root'
})
export class BasicAuthentificationService {

  constructor(private http: HttpClient,private router:Router) { }

authentification(username:string,password:string)
{
  console.log("username")
  console.log(username)
  console.log(password)

    return this.http.post<any>('http://localhost:8030/verification',{username,password})
}

/*
username!: string;
password!: string;

errorMessage = 'login pass incorrect'
decoMessage = 'deconnecte'

invalidelogin = false
deco = false
*/




logout() {

    sessionStorage.removeItem('token')
    this.router.navigateByUrl('login');
    /*
    this.invalidelogin = false;
    this.deco=true;
    */
      
    
}





}