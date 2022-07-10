import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Commande } from '../model/Commande';

@Injectable({
  providedIn: 'root'
})
export class CommandeService {

  constructor(private http: HttpClient,private router:Router) { }




  getAll()
{
  return this.http.get<Commande[]>('http://localhost:8030/afficherCommande')
}

Delete(id:number){
  return this.http.delete('http://localhost:8030/admin/SupprimerCommande'+id);
}


ajout(commandes:Commande)
{
  return this.http.post<Commande>('http://localhost:8030/admin/SaveCommande',commandes)
}

modif(commandes:Commande)
{
  return this.http.put<Commande>('http://localhost:8030/admin/UpdateCommande',commandes)
}


}
