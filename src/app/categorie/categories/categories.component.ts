import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


import { Location } from '@angular/common';
import { Categorie } from 'src/app/model/Categorie';
import { CategorieService } from 'src/app/service/Categorie.service';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  categories!: Categorie[];

  constructor(private service: CategorieService, private router: Router, private location: Location) { }


  ngOnInit(): void {
    this.recuperer();
  }

  recuperer() {
    this.service.getAll().subscribe
    (
      reponse => 
      {
           for (let i = 0; i < reponse.length; i = i + 1) {

        this.service.getbycategorie(reponse[i].idCategorie).subscribe(
          response2 =>
            reponse[i].produits = response2
        )
      };
        this.categories = reponse
    }
        )
  }


  mod(id: number): void {
    this.router.navigateByUrl('modifcategorie/' + id)
  }

  del(id: number): void {
    this.service.DeleteCategorie(id).subscribe()
    const myTimeout = setTimeout(this.a, 1000);
  }
  a(){
    location.reload();
  }

  ajout() {
    this.router.navigateByUrl('savecategorie');
  }


  

}

