import { Commande } from "./Commande";
import { Panier } from "./Panier";
import { Produit } from "./Produit";
import { Role } from "./Role";

export class Utilisateur
{
    id!:number;
    nom!:string;
    prenom!:string;
    dateNaissance!: string;
    login!:string;
    password!:string;

    role!:Role;

    commandes!:Commande[];

    panier!:Panier;


}
