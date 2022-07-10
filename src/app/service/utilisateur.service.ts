import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Utilisateur } from '../model/Utilisateur';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  constructor(private http: HttpClient,private router:Router) { }






getUtilisateur(login:string)
{ 
  return this.http.get<Utilisateur>('http://localhost:8030/Utilisateur/'+login);
}


insUtilisateur(utilisateur:Utilisateur)
{
  return this.http.post<Utilisateur>('http://localhost:8030/insUtilisateur',utilisateur)
}


//******************************************************************************************* */



  getAll()
{
  return this.http.get<Utilisateur[]>('http://localhost:8030/admin/afficherUtilisateur')
}


DeleteUtilisateur(id:number){
  return this.http.delete('http://localhost:8030/admin/SupprimerUtilisateur/'+id);
}


saveUtilisateur(utilisateur:Utilisateur,role:String)
{
  console.log("save")
  return this.http.post<Utilisateur>('http://localhost:8030/admin/SaveUtilisateur/'+role,utilisateur)
}


modif(utilisateur:Utilisateur)
{
  return this.http.put<Utilisateur>('http://localhost:8030/admin/UpdateUtilisateur',utilisateur)
}


}
