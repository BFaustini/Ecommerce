import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { LignePanier } from '../model/LignePanier';

@Injectable({
  providedIn: 'root'
})
export class LignepanierService {

  constructor(private http: HttpClient,private router:Router) { }


  getpanierentier(id:number)
{ 
  return this.http.get<LignePanier[]>('http://localhost:8030/afficherPaniereniter/'+id)
}


insUtilisateur(quantite:number,id:number)
{
  return this.http.post<LignePanier>('http://localhost:8030//misepanier/'+id,quantite)
}

Delete(id:number){
  return this.http.delete('http://localhost:8030/SupprLignePanier/'+id);
}

modif(quantite:number,id:number, ligne: LignePanier)
{
  return this.http.put<LignePanier>('http://localhost:8030/ModifLignePanier/'+id +'/'+quantite,ligne)
}
/*******************************************************************************************/

savelignepanier(LignePanier:LignePanier)
{
  return this.http.post<LignePanier>('http://localhost:8030/admin/SaveLignePanier',LignePanier)
}



  getAll()
{
  return this.http.get<LignePanier[]>('http://localhost:8030/admin/afficherLignePanier')
}





}
