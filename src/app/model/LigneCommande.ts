import { Categorie } from "./Categorie";
import { Commande } from "./Commande";
import { Produit } from "./Produit";

export class LigneCommande
{
    idLigneCommande!:number;
    produit!:Produit;
    img!:string;
    quantite!:number;

    commande!:Commande;





}
