package data;

import java.util.ArrayList;

import produits.Aliment;
import produits.Meuble;

public class DataProduit {
	public ArrayList<Aliment> listeAliments;
	public ArrayList<Meuble> listeMeuble;
	
	public DataProduit(){
	
	listeAliments = new  ArrayList<Aliment>();
    listeMeuble = new 	ArrayList<Meuble>();
	
	}
	
	
	// Methodes Aliments
	public void ajouterAliment(Aliment al) {
		listeAliments.add(al);
     }  
	
	public void supprimerAliment(Aliment al) {
		listeAliments.remove(al);
     }  
	
	public ArrayList<Aliment> getListeAliments() {
		return listeAliments;}
	
	
    // methodes Meubles
	public void ajouterMeuble(Meuble me) {
		listeMeuble.add(me);
     }  
	
	public void supprimerMeuble(Meuble me) {
		listeMeuble.remove(me);
     }  
	
	public ArrayList<Meuble> getListeMeuble() {
		return listeMeuble;}
	
	
	public  void supprimerAliment (int row) {
		listeAliments.remove(row);
	}
	public  void supprimerMeuble (int row) {
		listeMeuble.remove(row);
	}
}
