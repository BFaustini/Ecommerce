import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from 'src/app/model/Categorie';
import { CategorieService } from 'src/app/service/Categorie.service';

@Component({
  selector: 'app-savecategorie',
  templateUrl: './savecategorie.component.html',
  styleUrls: ['./savecategorie.component.css']
})
export class SavecategorieComponent implements OnInit {

  cat!: Categorie;

  constructor(private service:CategorieService,private router:Router) { }

  ngOnInit(): void {

    this.cat= new Categorie();
    //this.cat= new Categorie(0,"","");
  }


  Ajouter()
  {
    this.service.ajout(this.cat).subscribe(
      response=>
      this.router.navigateByUrl('categorie')
    )
  }

}
