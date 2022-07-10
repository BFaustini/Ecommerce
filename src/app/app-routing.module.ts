import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoriesComponent } from './categorie/categories/categories.component';
import { ModifcategorieComponent } from './categorie/modifcategorie/modifcategorie.component';
import { SavecategorieComponent } from './categorie/savecategorie/savecategorie.component';
import { CommandesComponent } from './commande/commandes/commandes.component';
import { ModifcommandeComponent } from './commande/modifcommande/modifcommande.component';
import { SavecommandeComponent } from './commande/savecommande/savecommande.component';
import { LignecommandesComponent } from './lignecommande/lignecommandes/lignecommandes.component';
import { ModiflignecommandeComponent } from './lignecommande/modiflignecommande/modiflignecommande.component';
import { SavelignecommandeComponent } from './lignecommande/savelignecommande/savelignecommande.component';


import { LoginComponent } from './login/login.component';
import { MainComponent } from './main/main.component';
import { PaniersComponent } from './panier/panier/paniers.component';
import { ModifproduitComponent } from './produit/modifproduit/modifproduit.component';
import { ProduitsComponent } from './produit/produits/produits.component';
import { SaveproduitComponent } from './produit/saveproduit/saveproduit.component';
import { ModifutilisateurComponent } from './utilisateur/modifutilisateur/modifutilisateur.component';
import { SaveutilisateurComponent } from './utilisateur/saveutilisateur/saveutilisateur.component';
import { UtilisateursComponent } from './utilisateur/utilisateurs/utilisateurs.component';



export const appRouteList: Routes = [

    { path: 'landing',component: MainComponent},
    { path: 'login',component: LoginComponent},

    { path: 'categorie',component: CategoriesComponent},
    { path: 'savecategorie',component: SavecategorieComponent},
    { path: 'modifcategorie/:id',component: ModifcategorieComponent},

    { path: 'produit',component: ProduitsComponent},
    { path: 'saveproduit',component: SaveproduitComponent},
    { path: 'modifproduit/:id',component: ModifproduitComponent},

    { path: 'commande',component: CommandesComponent},
    { path: 'savecommande',component: SavecommandeComponent},
    { path: 'modifcommande/:id',component: ModifcommandeComponent},

    { path: 'lignecommande',component: LignecommandesComponent},
    { path: 'savelignecommande',component: SavelignecommandeComponent},
    { path: 'modiflignecommande/:id',component: ModiflignecommandeComponent},

    { path: 'panier',component: PaniersComponent},

    { path: 'lignepanier',component: LignecommandesComponent},
    { path: 'savelignepanier',component: SavelignecommandeComponent},
    { path: 'modiflignepanier/:id',component: ModiflignecommandeComponent},

    { path: 'utilisateur',component: UtilisateursComponent},
    { path: 'saveutilisateur',component: SaveutilisateurComponent},
    { path: 'modifutilisateur/:id',component: ModifutilisateurComponent},


    //a mettre en dernier car les paths sont prioritaires sur les suivants
    { path: '**', redirectTo: 'landing'}


];

@NgModule({
    exports: [RouterModule],
    imports: [RouterModule.forRoot(appRouteList)]
})
export class AppRoutingModule {
}

