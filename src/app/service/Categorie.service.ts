import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Categorie } from '../model/Categorie';
import { Produit } from '../model/Produit';


@Injectable({
  providedIn: 'root'
})
export class CategorieService {

  constructor(private http: HttpClient,private router:Router) { }

categories!: Categorie[];


getAll()
{
  console.log(sessionStorage.getItem('token'))
  return this.http.get<Categorie[]>('http://localhost:8030/afficherCategorie')
}

getCategorie(id:number)
{ 
  return this.http.get<Categorie>('http://localhost:8030/admin/Categorie/'+id);
}


DeleteCategorie(id:number){
  return this.http.delete('http://localhost:8030/admin/SupprimerCategorie/'+id);
}



ajout(categorie:Categorie)
{
  return this.http.post<Categorie[]>('http://localhost:8030/admin/SaveCategorie',categorie)
}

modif(categorie:Categorie)
{
  return this.http.put<Categorie>('http://localhost:8030/admin/UpdateCategorie',categorie)
}


getbycategorie(id:number)
{
  return this.http.get<Produit[]>('http://localhost:8030/AffCategorie/'+id);
}


}
