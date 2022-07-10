import { Categorie } from "./Categorie";

export class Produit
{
    idProduit!:number;
    nomProduit!:string;
    img!:string;
    quantite!:number;

    categorie!:Categorie;


/*
    constructor( idCategorie:number, nomCategorie:string, img:string, quantite:number, categorie:Categorie)
    {
        this.idProduit=idCategorie;
        this.nomProduit=nomCategorie;
        this.img=img;
        this.quantite=quantite;
        this.categorie=categorie;
    }*/

}
