package supermarketTest;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.DataProduit;
import personnes.*;
import produits.Aliment;
import produits.Meuble;

public class AddAliment extends JFrame implements ActionListener{
	
    private JTextField tF_nom;
	private JTextField tF_couleur = new JTextField();
	private JFormattedTextField tF_poids = new JFormattedTextField();

	private JLabel lB_nom;
	private JLabel lB_couleur;
	private JLabel lB_poids;
    private JButton btnSave; 
    
    
    protected Archive archive;
    private  JComboBox comboDir;
    private JLabel lblNewLabel;
	
	public AddAliment() {
		
		archive = Monmaine.archive;
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Nouveau Aliment");
		setBackground(Color.green);
		setBounds(400, 100, 387, 280);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		tF_nom = new JTextField();
		tF_nom.setColumns(10);
		tF_nom.setBounds(155, 6, 96, 19);
		tF_nom.addActionListener((ActionListener) this);
		getContentPane().add(tF_nom);
		
		tF_couleur.setColumns(10);
		tF_couleur.setBounds(155, 37, 96, 19);
		tF_couleur.addActionListener((ActionListener) this);

		getContentPane().add(tF_couleur);
		
		tF_poids.setBounds(155, 68, 96, 19);
		tF_poids.setValue(0.0);

		getContentPane().add(tF_poids);
		tF_poids.setColumns(10);
		
		
	    lB_nom = new JLabel("Nom: ");
		lB_nom.setBounds(6, 10, 65, 13);
		getContentPane().add(lB_nom);
		
		lB_couleur = new JLabel("Couleur: ");
		lB_couleur.setBounds(6, 41, 103, 13);
		getContentPane().add(lB_couleur);
		
		lB_poids = new JLabel("Poids ");
		lB_poids.setBounds(6, 70, 115, 13);
		getContentPane().add(lB_poids);
		
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						        
				if (!(newAliment() == null))
					dispose();
			}
		});
		
		btnSave.setBounds(155, 185, 128, 21);
		getContentPane().add(btnSave);
		
				
		ArrayList<Personne> dirList = Monmaine.archive.listRepertoire.chercherParRang("Directeur");
		ArrayList<String> nomDir = new ArrayList<String>();
		for (Personne p : dirList) {
			nomDir.add(p.getNom());
		}

		comboDir = new JComboBox(nomDir.toArray());
		comboDir.setBounds(155, 112, 94, 21);
		getContentPane().add(comboDir);

		
		lblNewLabel = new JLabel("Ajoute par");
		lblNewLabel.setBounds(6, 116, 83, 13);
		getContentPane().add(lblNewLabel);
		
		
		setVisible(true);
			
		
	}
	
	  // methode pour ajouter un aliment
	  public Aliment newAliment() {
		    Aliment newa = null;
		    String nom = tF_nom.getText();
		    String couleur = tF_couleur.getText();
			double poids = (((Number)tF_poids.getValue()).doubleValue());

			if (  (tF_nom.getText().length() == 0) )
			{
					JOptionPane.showMessageDialog(null, "Nom est manquant");
					
					return null;
			}
			
			if (  (tF_couleur.getText().length() == 0) )
			{
					JOptionPane.showMessageDialog(null, "Couleur est manquant");
					
					return null;
			}
			newa = new Aliment(nom, couleur, poids, comboDir.getSelectedItem().toString());

			Monmaine.archive.produit.getListeAliments().add(newa);
			Monmaine.archive = this.archive;
			GestionProduit.fillTableA(GestionProduit.tableA,this.archive.produit.getListeAliments() );
			System.out.println(this.archive.listRepertoire.repertoire);
		
	  return newa;
	  }

	

	public  JComboBox getComboDir() {
		return comboDir;
	}

	public void setComboDir(JComboBox comboDir) {
		this.comboDir = comboDir;
	}

	public boolean validateDouble(String c) {
			try {
				double num = Double.parseDouble(c);		
				return true;
			}
			catch(Exception e) {
			}	
			return false;	
		}
	  
	  
	@Override
	
	public void actionPerformed(ActionEvent e) {
	 
	}
}
