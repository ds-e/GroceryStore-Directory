package personnes;

public class Client extends Personne {
	
	public Client(String n, String p, String d) {
		super(n, p, d);
		this.rang = "Client";
		Personne.ID = Personne.ID +1;	
		this.IDString = "1"+ Personne.ID;
		
		
	}
	
}
