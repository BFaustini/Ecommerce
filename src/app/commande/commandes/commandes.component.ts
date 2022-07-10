import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Commande } from 'src/app/model/Commande';
import { CommandeService } from 'src/app/service/commande.service';

@Component({
  selector: 'app-commandes',
  templateUrl: './commandes.component.html',
  styleUrls: ['./commandes.component.css']
})
export class CommandesComponent implements OnInit {


  commandes!:Commande[];

  constructor(private service: CommandeService, private router: Router, private location: Location) { }


  ngOnInit(): void {
    this.recuperer();
  }

  recuperer() {
    this.service.getAll().subscribe
    (
      reponse => 
        this.commandes = reponse
    
        )
  }


  del(id: number): void {
    this.service.Delete(id).subscribe()
    const myTimeout = setTimeout(this.a, 1000);
  }
  a(){
    location.reload();
  }




}
