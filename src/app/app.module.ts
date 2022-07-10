import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HttpInterceptorBasicAuthServiceService } from './service/http-interceptor-basic-auth-service.service';
import { MainComponent } from './main/main.component';
import { FooterComponent } from './footer/footer.component';
import { CategoriesComponent } from './categorie/categories/categories.component';
import { SavecategorieComponent } from './categorie/savecategorie/savecategorie.component';
import { ModifcategorieComponent } from './categorie/modifcategorie/modifcategorie.component';
import { ProduitsComponent } from './produit/produits/produits.component';
import { SaveproduitComponent } from './produit/saveproduit/saveproduit.component';
import { ModifproduitComponent } from './produit/modifproduit/modifproduit.component';
import { UtilisateursComponent } from './utilisateur/utilisateurs/utilisateurs.component';
import { SaveutilisateurComponent } from './utilisateur/saveutilisateur/saveutilisateur.component';
import { ModifutilisateurComponent } from './utilisateur/modifutilisateur/modifutilisateur.component';
import { PaniersComponent } from './panier/panier/paniers.component';
import { LignespaniersComponent } from './lignespanier/lignespaniers/lignespaniers.component';
import { SavelignespanierComponent } from './lignespanier/savelignespanier/savelignespanier.component';
import { ModiflignespanierComponent } from './lignespanier/modiflignespanier/modiflignespanier.component';
import { CommandesComponent } from './commande/commandes/commandes.component';
import { SavecommandeComponent } from './commande/savecommande/savecommande.component';
import { ModifcommandeComponent } from './commande/modifcommande/modifcommande.component';
import { LignecommandesComponent } from './lignecommande/lignecommandes/lignecommandes.component';
import { SavelignecommandeComponent } from './lignecommande/savelignecommande/savelignecommande.component';
import { ModiflignecommandeComponent } from './lignecommande/modiflignecommande/modiflignecommande.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MainComponent,
    FooterComponent,
    CategoriesComponent,
    SavecategorieComponent,
    ModifcategorieComponent,
    ProduitsComponent,
    SaveproduitComponent,
    ModifproduitComponent,
    UtilisateursComponent,
    SaveutilisateurComponent,
    ModifutilisateurComponent,
    PaniersComponent,
    LignespaniersComponent,
    SavelignespanierComponent,
    ModiflignespanierComponent,
    CommandesComponent,
    SavecommandeComponent,
    ModifcommandeComponent,
    LignecommandesComponent,
    SavelignecommandeComponent,
    ModiflignecommandeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    {provide:HTTP_INTERCEPTORS,useClass:HttpInterceptorBasicAuthServiceService,multi:true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
