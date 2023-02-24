package personnes;


public class Employe extends Personne {
	
	public Employe(String n, String p, String d) {
		super(n, p, d);
		this.rang = "Employe";
		Personne.ID = Personne.ID +1;	
		this.IDString = "2"+ Personne.ID;
		
			
	}
	
	
	
	
	
}
