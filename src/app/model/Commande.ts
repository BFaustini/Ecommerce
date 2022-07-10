import { LigneCommande } from "./LigneCommande";
import { Utilisateur } from "./Utilisateur";


export class Commande
{
    idCommande!:number;
    dateCommande!:string;
    description!:string;

    user!: Utilisateur;

    ligneCommandes!:LigneCommande[];

}
