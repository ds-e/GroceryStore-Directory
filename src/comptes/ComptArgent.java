package comptes;

import javax.swing.JOptionPane;

public class ComptArgent {
	
	public double montant;
	
	public ComptArgent(double depot) {
		this.montant = depot;
			
	}
	
	 
	public double getMontant() {
		return montant;
	}


	public void setMontant(double montant) {
		this.montant = montant;
	}

	
	public void addArgent(double add) {
		this.montant = montant + add;
	}
	

	public void retirerArgent(double argent) {	
		if(argent > this.montant) {
			JOptionPane.showMessageDialog(null, "Solde insuffisant");
		} else {
		 this.montant = montant - argent;
		}
	}


	public String getMontantString() {
		String ans = "";
		double fond =getMontant();
		ans = ans + fond;
		return ans;
	}
	
	

}
