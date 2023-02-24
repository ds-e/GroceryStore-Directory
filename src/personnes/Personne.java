package personnes;

import java.util.ArrayList;

import comptes.ComptArgent;
import data.*;
import produits.Aliment;
import produits.Meuble;

public class Personne implements Comparable<Personne> {
	
	protected String nom;
	protected String prenom;
	protected String dateDeNaissance;
	public String rang;
	protected String mail;
	static int ID = 1000;
	protected String IDString;
	

	public ComptArgent compte;
	public DataProduit produiPref;
	
	
	

	public Personne (String n, String p, String d ) {
		this.nom = n;
		this.prenom = p;
		this.dateDeNaissance = d;
		setMail(this.nom, this.prenom);
		
		this.compte = new ComptArgent(0);
		this.compte.setMontant(0);
		
		this.produiPref  = new DataProduit();
		
		
	}

	
		 public String setMail (String nom, String prenom) {
			this.mail = this.nom + this.prenom + "@magasin.ca";
			return this.mail;
		}
		
		// afficher personne
		public String toString (){
			return "nom: " + this.nom + "  ~  prenom: " + this.prenom 
					+ "  ~  date de naissance :" + this.dateDeNaissance 
					+ "  ~  rang :" + this.rang;
		}


		// aliments preferes 
		public ArrayList<Aliment> getAlimentPref() {
			return produiPref.getListeAliments();
		}
		
		public void addAlimentPref(Aliment Al) {
			this.produiPref.listeAliments.add(Al);
		}
		
		public void removeAlimentPref(Aliment Al) {
			this.produiPref.listeAliments.remove(Al);
		}
		
		//Meubles preferes
		
		public ArrayList<Meuble> getMeublesPref() {
			return produiPref.getListeMeuble();
		}
	
		public void addMeublePref(Meuble Al) {
			this.produiPref.listeMeuble.add(Al);
		}
		
		public void removeMeublePref(Meuble Al) {
			this.produiPref.listeMeuble.remove(Al);
		}

		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		
		
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		
		
		public String getDateDeNaissance() {
			return dateDeNaissance;
		}
		public void setDateDeNaissance(String dateDeNaissance) {
			this.dateDeNaissance = dateDeNaissance;
		}
		
		
		public String getRang() {
			return rang;
		}
		public void setRang(String rang) {
			this.rang = rang;
		}
		

		public static int getID() {
			return ID;
		}


		public static void setID(int iD) {
			ID = iD;
		}

		public String getMail() {
			return mail;
		}
		
		public String getIDString() {
			return IDString;
		}

		//argent
		public ComptArgent getCompte() {
			return compte;
		}


		public void setCompte(ComptArgent compte) {
			this.compte = compte;
		}

		public int compareTo(Personne p) {
			int ans = 0;
			ans = this.getNom().compareTo(p.getNom());
			return ans;
			
		}


}
