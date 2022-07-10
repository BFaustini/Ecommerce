import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Utilisateur } from 'src/app/model/Utilisateur';
import { UtilisateurService } from 'src/app/service/utilisateur.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-utilisateurs',
  templateUrl: './utilisateurs.component.html',
  styleUrls: ['./utilisateurs.component.css']
})
export class UtilisateursComponent implements OnInit {

  utilisateurs!: Utilisateur[];

  test!: boolean

  constructor(private service:UtilisateurService,private router:Router,private location: Location) { }

  ngOnInit(): void {

    this.recuperer();
  }

  recuperer() {
    this.service.getAll().subscribe
    (
      reponse => 
        this.utilisateurs = reponse
    
        )
  }


  mod(id: number): void {
    this.router.navigateByUrl('modifcategorie/' + id)
  }

  del(id: number): void {
    this.test= false
    this.service.DeleteUtilisateur(id).subscribe();

    console.log("1")
     const myTimeout = setTimeout(this.a, 1000);
  }
  a(){
    location.reload();
  }

  ajout() {
    this.router.navigateByUrl('saveutilisateur');
  }

}


