package personnes;

import data.DataProduit;

public class Directeur  extends Personne {

	public Directeur (String n, String p, String d) {
		super(n, p, d);
		this.rang = "Directeur";
		Personne.ID = Personne.ID +1;	
		this.IDString = "3"+ Personne.ID;
		this.produiPref  = new DataProduit(); 
		
	}
}
