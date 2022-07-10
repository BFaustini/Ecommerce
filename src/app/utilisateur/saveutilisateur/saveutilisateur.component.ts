import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Utilisateur } from 'src/app/model/Utilisateur';
import { UtilisateurService } from 'src/app/service/utilisateur.service';

@Component({
  selector: 'app-saveutilisateur',
  templateUrl: './saveutilisateur.component.html',
  styleUrls: ['./saveutilisateur.component.css']
})
export class SaveutilisateurComponent implements OnInit {


  uti!: Utilisateur;

  role!:string

  constructor(private service:UtilisateurService,private router:Router) { }

  ngOnInit(): void {

    this.uti=new Utilisateur();
    this.role= "";
  
  }

saveUtil(){

this.service.saveUtilisateur(this.uti,this.role).subscribe(
  response=>
  this.router.navigateByUrl('utilisateur')
)
}



}
