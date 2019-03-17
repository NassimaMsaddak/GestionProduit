package web;
import java.util.ArrayList;

import metier.Produit;

public class ProduitBeans {
	    //  les attributs
		private Produit produit = new Produit();
		private ArrayList<Produit>  liste= new ArrayList<Produit>();
		
		// generate getters and setters
		// from menu en haut --> Source --> generate getters and setters
		
		public Produit getProduit(){
			return produit;
		}
		
		public void setProduit( Produit produit){
			this.produit=produit;
		}
			
		public ArrayList<Produit> getListe(){
			return liste;
		}
		
		public void setListe(ArrayList<Produit> arrayList){
			this.liste=arrayList;
		}
		// end of getters and setters
	}
