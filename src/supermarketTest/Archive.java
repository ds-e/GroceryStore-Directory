package supermarketTest;

import java.util.ArrayList;

import javax.swing.JList;

import comptes.*;
import produits.*;
import personnes.*;
import data.*;


public class Archive {
	public Repertoir  listRepertoire; 
	public Repertoir  temporalRepertoire;   

	public DataProduit produit;
	
	public Archive() { 
		
		listRepertoire = new Repertoir(); 
		temporalRepertoire = new Repertoir();
		
		produit = new DataProduit();  
		
	    // repertoir de depart
	    Client c1 = new Client ("George", "Alexa", "1997/01/01");
        Client c2 = new Client ("Mikkie", "Mickey", "2001/06/01");
        Employe e1 = new Employe("Danniel", "Dan", "2000/05/01") ; 
        Employe e2 = new Employe("Carlos", "Charlie", "1989/01/08") ;
        e2.compte.setMontant(18.5);
        
        Directeur d1 = new Directeur ("Alicia", "Alicia", "1959/10/07");
        Directeur d2 = new Directeur ("Tommy", "Tommy",  "1999/11/06");
        
        listRepertoire.enregistrerPersonne(c1);
        listRepertoire.enregistrerPersonne(c2);
        listRepertoire.enregistrerPersonne(e1);
        listRepertoire.enregistrerPersonne(e2);
        listRepertoire.enregistrerPersonne(d1);
        listRepertoire.enregistrerPersonne(d2);
	     
		// Liste produits de depart
		
		Aliment a1 = new Aliment("pomme", "rouge", 0.1,"Alexa");
        Aliment a2 = new Aliment("poire", "verte", 0.1, "Alexa");
        Meuble m1 = new Meuble("armoire", 150, 200, "Tommy");
        Meuble m2 = new Meuble("lit", 100, 30, "Tommy");

        produit.ajouterAliment(a1); 
        produit.ajouterAliment(a2);    
        produit.ajouterMeuble(m1);
        produit.ajouterMeuble(m2);
        
        c1.produiPref.ajouterAliment(new Aliment("pomme","Yelow", 0.23,"Alicia"));
        c1.produiPref.ajouterMeuble(new Meuble("lit", 100, 30, "Alicia"));
	     
	 	}


}
