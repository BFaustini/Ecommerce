import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Produit } from 'src/app/model/Produit';
import { ProduitService } from 'src/app/service/produit.service';

@Component({
  selector: 'app-modifproduit',
  templateUrl: './modifproduit.component.html',
  styleUrls: ['./modifproduit.component.css']
})
export class ModifproduitComponent implements OnInit {

  idc!:number;
  pro!:Produit;

  constructor(private service:ProduitService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.pro= new Produit();
    this.idc=+this.route.snapshot.params['id'];
    this.ChargerCategorie(this.idc);
  }


  ChargerCategorie(id:number)
  {
    this.service.getProduit(id).subscribe(
      response=>{
        this.pro=response
      }
    )
  }

  modifiercategorie()
  {
    this.service.modif(this.pro).subscribe(
      response=>
      this.router.navigateByUrl('categorie')
    )
  }

}
