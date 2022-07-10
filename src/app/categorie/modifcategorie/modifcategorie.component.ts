import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from 'src/app/model/Categorie';
import { CategorieService } from 'src/app/service/Categorie.service';

@Component({
  selector: 'app-modifcategorie',
  templateUrl: './modifcategorie.component.html',
  styleUrls: ['./modifcategorie.component.css']
})
export class ModifcategorieComponent implements OnInit {

  idc!:number;
  cate!:Categorie;
  

  constructor(private service:CategorieService,private router:Router ,private route:ActivatedRoute ) { }

  ngOnInit(): void {

    this.cate= new Categorie();
    //this.cate= new Categorie(0,"","");
    this.idc=+this.route.snapshot.params['id'];
    this.ChargerCategorie(this.idc);
  }


  ChargerCategorie(id:number)
  {
    this.service.getCategorie(id).subscribe(
      response=>{
        this.cate=response
      }
    )
  }

  modifiercategorie()
  {
    this.service.modif(this.cate).subscribe(
      response=>
      this.router.navigateByUrl('categorie')
    )
  }

}
