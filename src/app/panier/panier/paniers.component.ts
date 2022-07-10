import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Panier } from 'src/app/model/Panier';
import { PanierService } from 'src/app/service/panier.service';

@Component({
  selector: 'app-paniers',
  templateUrl: './paniers.component.html',
  styleUrls: ['./paniers.component.css']
})
export class PaniersComponent implements OnInit {

  panier!:Panier[];

  constructor(private service: PanierService, private router: Router) { }


  ngOnInit(): void {
    this.recuperer();
  }

  recuperer() {
    this.service.getAll().subscribe
    (
      reponse => 
        this.panier = reponse
        )
  }

}


