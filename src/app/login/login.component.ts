import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Utilisateur } from '../model/Utilisateur';
import { BasicAuthentificationService } from '../service/basic-authentification.service';
import { UtilisateurService } from '../service/utilisateur.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  utilisateur!: Utilisateur;

  username!: string;
  password!: string;

  errorMessage = 'login pass incorrect'
  decoMessage = 'deconnecte'

  invalidelogin = false
  deco = false

  constructor(private router: Router, private basicauthenservice: BasicAuthentificationService, private service: UtilisateurService) { }

  ngOnInit(): void {
    this.utilisateur = new Utilisateur();
  }

  login() {
    this.deco = false

    this.basicauthenservice.authentification(this.username, this.password)
      .subscribe(
        data => {
          sessionStorage.setItem('token', 'Bearer ' + data.jwt)
          this.invalidelogin = false;
          console.log(sessionStorage.getItem('token'))
          this.service.getUtilisateur(this.username).subscribe(
            reponse => {
              sessionStorage.setItem('user', JSON.stringify(reponse));
            }
          )
          this.router.navigateByUrl('landing');

          // sessionStorage.setItem('utilisateurrole', this.username)
          /*
          this.service.getUtilisateur(this.username).subscribe(
            reponse=>
            {
             this.utilisateur= reponse
             sessionStorage.setItem('utilisateurrole', reponse.role.librole)
             //console.log(sessionStorage.getItem('utilisateurrole'))
            }
             */
        },
        error => {
          this.invalidelogin = true;
        }
      )
  }

  logout() {

    sessionStorage.removeItem('token');
    sessionStorage.removeItem('utilisateurrole');
    this.router.navigateByUrl('login');
    this.invalidelogin = false;
    this.deco = true;


  }

}




