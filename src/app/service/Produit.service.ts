import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Produit } from '../model/Produit';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  constructor(private http: HttpClient,private router:Router) { }


  getAll()
  {
    return this.http.get<Produit[]>('http://localhost:8030/admin/afficherProduit')
  }
  
  getProduit(id:number)
  { 
    return this.http.get<Produit>('http://localhost:8030/admin/Categorie/'+id);
  }
  
  DeleteProduit(id:number){
    return this.http.delete('http://localhost:8030/admin/SupprimerProduit/'+id);
  }
    
  ajout(produit:Produit)
  {
    return this.http.post<Produit>('http://localhost:8030/admin/SaveProduit',produit)
  }
  
  modif(produit:Produit)
  {
    return this.http.put<Produit>('http://localhost:8030/admin/UpdateProduit',produit)
  }



  
}
