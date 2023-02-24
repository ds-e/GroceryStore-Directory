package produits;

public class Meuble {

	protected String produit;
	private String type;  // ex: table,chaise...
	private double prix;
	private double maxHeight;  // en cm
	private String directeur;
	protected String addedBy;
	
	public Meuble(String t, double p, double m, String a) {
		this.type = t;
		this.prix = p;
		this.maxHeight = m;
		this.produit = "Meuble";
		this.addedBy = a;
	}
    

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	// afficher le meuble
	public String toString() {
		return "Meuble  " + "type: " + this.type + "  ~  prix: " + this.prix 
					+ "  ~  hauteur maximale: " + this.maxHeight; 
	}
	
	
	
	// getters et setters
	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public double getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(float maxHeight) {
		this.maxHeight = maxHeight;
	}
		

	public String getDirecteur() {
		return directeur;
	}

	public void setDirecteur(String directeur) {
		this.directeur = directeur;
	}

	
}
	
	

	
