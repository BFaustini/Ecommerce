import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Categorie } from '../model/Categorie';
import { Commande } from '../model/Commande';
import { LignePanier } from '../model/LignePanier';
import { Utilisateur } from '../model/Utilisateur';
import { CategorieService } from '../service/Categorie.service';
import { CommandeService } from '../service/commande.service';
import { LignepanierService } from '../service/lignepanier.service';
import { UtilisateurService } from '../service/utilisateur.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})


export class MainComponent implements OnInit {

  uti!:Utilisateur
  //role!:string

  admi!:boolean
  clien!:boolean

  categorie!: Categorie[];

  commande!: Commande[];

  lignepanier!: LignePanier[];
  quantite!:number

  constructor(private router:Router,  private service: UtilisateurService, private caservice: CategorieService, private coservice: CommandeService, private lpservice: LignepanierService) { }

  ngOnInit(): void {
    var obj = JSON.parse(sessionStorage['user']);
  if (obj)
  {
    console.log(obj)

    this.uti=obj;
  }

    this.admi=this.uti.role.librole==="admin"
    this.clien=this.uti.role.librole==="client"




    console.log(this.clien)

    if(this.clien)
    {
      console.log(this.clien)
      this.recuperer();
      console.log(this.clien)
      this.recuperer2();
      console.log(this.clien)
      this.recuperer3();
      console.log(this.clien)
      //this.quantite=0;


    }

}







recuperer() {
  this.caservice.getAll().subscribe
  (
    reponse => 
      this.categorie = reponse
  )
      
}

recuperer2() {
  this.coservice.getAll().subscribe
  (
    reponse => 
      this.commande = reponse
  )
}

recuperer3() {
  this.lpservice.getpanierentier(this.uti.panier.idPanier).subscribe
  (
    reponse => 
      this.lignepanier = reponse
  )
}



/* #####################################################################################################*/

modifierligne(id:number)
{
  this.lpservice.modif(this.quantite,id,this.lignepanier[0]).subscribe(
    response=> {
      const myTimeout = setTimeout(this.a, 500);
    }
  )
}


del(id: number): void {
  this.lpservice.Delete(id).subscribe()
  const myTimeout = setTimeout(this.a, 500);
}
a(){
  location.reload();
}



// REDIRECTION

  categories()
  {
    this.router.navigateByUrl('categorie');
  }
  produit()
  {
    this.router.navigateByUrl('produit');
  }
  commandes()
  {
    this.router.navigateByUrl('commande');
  }
  lignecommandes()
  {
    this.router.navigateByUrl('lignecommande');
  }
  paniers()
  {
    this.router.navigateByUrl('panier');
  }
  lignepaniers()
  {
    this.router.navigateByUrl('lignepanier');
  }
  utilisateurs()
  {
    this.router.navigateByUrl('utilisateur');
  }


}
