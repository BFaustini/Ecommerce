import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Panier } from '../model/Panier';

@Injectable({
  providedIn: 'root'
})
export class PanierService {

  constructor(private http: HttpClient,private router:Router) { }




  getAll()
{
  return this.http.get<Panier[]>('http://localhost:8030/admin/afficherPanier')
}



}
