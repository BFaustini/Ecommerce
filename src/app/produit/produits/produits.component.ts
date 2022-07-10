import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Produit } from 'src/app/model/Produit';
import { ProduitService } from 'src/app/service/produit.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css']
})
export class ProduitsComponent implements OnInit {

  produit!: Produit[];

  constructor(private service: ProduitService, private router: Router, private location: Location) { }

  ngOnInit(): void {
    this.recuperer();
  }


  //C:\Users\F.R.I.D.A.Y\Desktop\testangu\ecommerce\src\app\imagesproduits\bag1.jpg

  recuperer() {
    this.service.getAll().subscribe
    (
      reponse => {
      console.log(reponse[0].img)

      /*
      for (let i = 0; i < reponse.length; i = i + 1) {
        reponse[i].img="C:\Users\F.R.I.D.A.Y\Desktop\testangu\ecommerce\src\app"+reponse[i].img
      }
      */
        this.produit = reponse
      }

        )
  }

  del(id: number): void {

    this.service.DeleteProduit(id).subscribe()
    const myTimeout = setTimeout(this.a, 1000);
  }
  a(){
    location.reload();
  }

  ajout() {
    this.router.navigateByUrl('savecategorie');
  }

}
