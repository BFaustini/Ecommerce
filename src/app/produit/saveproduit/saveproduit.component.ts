import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Produit } from 'src/app/model/Produit';
import { ProduitService } from 'src/app/service/produit.service';

@Component({
  selector: 'app-saveproduit',
  templateUrl: './saveproduit.component.html',
  styleUrls: ['./saveproduit.component.css']
})
export class SaveproduitComponent implements OnInit {

  pro!: Produit;

  constructor(private service:ProduitService,private router:Router) { }

  ngOnInit(): void {
    this.pro= new Produit();
  }

  Ajouter()
  {
    this.service.ajout(this.pro).subscribe(
      response=>
      this.router.navigateByUrl('produit')
    )
  }

}
