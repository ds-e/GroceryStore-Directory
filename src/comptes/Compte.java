package comptes;

import java.util.ArrayList;

//import personnes.*;
import produits.Aliment;
import produits.Meuble;


public class Compte {
	
	protected String nom;
	protected String prenom;
	protected String dateDeNaissance;
	protected String rang;
	protected String mail;
	protected String comptNumb;
	
	private double fondsDisponibles;
	protected static double newBalance;
	protected ArrayList<Aliment> favorisA = new ArrayList<Aliment>() ;
	protected ArrayList<Meuble> favorisM = new ArrayList<Meuble>() ;

	
	public  Compte (String n, String p, String d) {
		this.nom = n;
		this.prenom = p;
		this.dateDeNaissance = d;			
		
		//this.fondsDisponibles = f;
	}

	
	
	
	public void setFavorisMeuble (Meuble m) {
		 this.favorisM.add(m);
	 }
	 public ArrayList<Meuble> getFavorisMeuble() {
		    for (Meuble m: favorisM) { System.out.println(m);}
			return favorisM;
		}
	 
	 public void setFavorisAliment (Aliment a) {
		 this.favorisA.add(a);
	 }
	 
	 public ArrayList<Aliment> getFavorisAliment() {
		    for (Aliment a: favorisA) { System.out.println(a);}
			return favorisA;
		}
	 
	
	 
	 // getters and setters
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public double getFondsDisponibles() {
		System.out.println(fondsDisponibles);
		return this.fondsDisponibles;
	}

	public void setFondsDisponibles(double fondsDisponibles) {
		this.fondsDisponibles = fondsDisponibles;
	}


	public String getComptNumb() {
		return comptNumb;
	}


	public void setComptNumb(String comptNumb) {
		this.comptNumb = comptNumb;
	}
			
}
