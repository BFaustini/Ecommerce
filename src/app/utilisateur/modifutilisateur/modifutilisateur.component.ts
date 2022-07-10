import { Component, OnInit } from '@angular/core';
import { Utilisateur } from 'src/app/model/Utilisateur';

@Component({
  selector: 'app-modifutilisateur',
  templateUrl: './modifutilisateur.component.html',
  styleUrls: ['./modifutilisateur.component.css']
})
export class ModifutilisateurComponent implements OnInit {

  uti!: Utilisateur;


  constructor() { }

  ngOnInit(): void {
  }



  modif(){

  }
}
