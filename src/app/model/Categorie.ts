import { Produit } from "./Produit";

export class Categorie
{
    idCategorie!:number;
    nomCategorie!:string;
    description!:string;

    produits!: Produit[];

/*
    constructor( idCategorie:number, nomCategorie:string, description:string)
    {
        this.idCategorie=idCategorie;
        this.nomCategorie=nomCategorie;
        this.description=description;
    }
*/
}
