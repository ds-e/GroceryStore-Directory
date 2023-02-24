package produits;



public class Aliment {
	protected String nom;
	protected String couleur;
	protected String produit;
	protected double poids;
	protected String addedBy;
	
	
	public Aliment (String n, String c, double p, String a) {
		this.nom = n;
		this.couleur = c;
		this.poids = p;
		this.produit = "Aliment";
		this.addedBy = a;
	}

	
   public String getAddedBy() {
		return addedBy;
	}


	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}


	// afficher l'aliment
	public String toString() {
		return "Aliment  " + "nom: " + this.nom + "  ~  couleur: " + this.couleur 
				+ "  ~  poids: " + this.poids; 
	}
	
	
	
	// getters et setters

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getCouleur() {
		return couleur;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public double getPoids() {
		return poids;
	}


	public void setPoids(double poids) {
		this.poids = poids;
	}


	
}
