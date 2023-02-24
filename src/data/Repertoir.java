package data;
import java.util.ArrayList;

import personnes.*;

public class Repertoir {
	
	public ArrayList<Personne> repertoire;

	public Repertoir() {
	
	   repertoire = new  ArrayList<Personne>();
       
	}
    
	public static void afficherRepertoire (ArrayList<Personne> repertoire) {
	    System.out.println("-------------------------------------------------------------------------------------");
	    for (Personne p: repertoire) { System.out.println(p);}
        System.out.println("-------------------------------------------------------------------------------------");
	}
	
	public void enregistrerPersonne(Personne p) {
		repertoire.add(p);
	}

	public void supprimerPersonne(Personne p) {
		repertoire.remove(p);
	}

	public String chercherPersonne(Personne p) {
		if (repertoire.contains(p)) {
			System.out.println("cette personne est actuelement dans le repertoire");
			System.out.println(p);
			return p.toString();
		}
		System.out.println("cette personne n'est pas dans le repertoire");
		return "Cette personne n'est pas dans le repertoire";
	}

	public ArrayList<Personne> chercherParRang (String rang) {
		ArrayList<Personne> repRang = new  ArrayList<Personne>();
		
		if (rang == "Client" || rang == "Employe" || rang == "Directeur" ) {
			
			for (Personne p : repertoire) {
		         if (p.getRang().equals(rang)) {
		        	 repRang.add(p);
		        	 }    
		    }
			
		} else {

		    repRang = repertoire;
		}
		return repRang;
	}
	
	
	public ArrayList<Personne> chercherParLettreOuNom (String lettre) {
		ArrayList<Personne> repLettre = new ArrayList<Personne>();

		for ( Personne p : repertoire) {
	    	char firstLetter = p.getNom().charAt(0);
	    	String StrFirstLetter = Character.toString(firstLetter);  

	    	if (StrFirstLetter.equals(lettre)) {
		    	//System.out.println(p.toString());  
		    	repLettre.add(p);
	    	}	
	    	else {if (lettre.contentEquals(p.getNom())) {
	    		repLettre.add(p);}
	    	}
	    }	
		return repLettre;
	}
	
	
	
	public Personne chercherParIDString (String IDString) {
		
		Personne pers = new Personne(null,null,null);

		for ( Personne p : repertoire) {
	    	
	    	String ID =  p.getIDString();  

	    	if (ID.equals(IDString)) {
		    	//System.out.println(p.toString());  
		    	pers = p;
	    	}		    	
	    }	
		return pers;
	}
	
	
	
	// getters and setters
	public ArrayList<Personne> getRepertoire() {
		return repertoire;
	}
	
	public void setRepertoire(ArrayList<Personne> repertoire) {
		this.repertoire = repertoire;
	}

	 
}
