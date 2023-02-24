package supermarketTest;

import java.awt.Color;
import java.awt.Component;
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
import produits.Meuble;

public class AddMeuble extends JFrame implements ActionListener{
    private JTextField tF_type;
	private JFormattedTextField tF_prix = new JFormattedTextField();
	private JFormattedTextField tF_maxheight = new JFormattedTextField();

    public JLabel lB_type;
    public JLabel lB_prix;
    public JLabel lB_maxheight;
    private JButton btnSave;
    private JComboBox comboDir;
    protected Archive archive;
    private JLabel lblAddedBy;

    
    
	public AddMeuble() {
		
		archive = Monmaine.archive;
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Nouveau Meuble");
		setBackground(Color.green);
		setBounds(400, 100, 387, 243);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		tF_type = new JTextField();
		tF_type.setColumns(10);
		tF_type.setBounds(103, 6, 96, 19);
		tF_type.addActionListener((ActionListener) this);
		getContentPane().add(tF_type);
		
		tF_prix.setColumns(10);
		tF_prix.setBounds(103, 37, 96, 19);
		tF_prix.addActionListener((ActionListener) this);
		tF_prix.setValue(0.0);
		

		getContentPane().add(tF_prix);
		
		tF_maxheight.setBounds(103, 68, 96, 19);
		tF_maxheight.setValue(0.0);

		getContentPane().add(tF_maxheight);
		tF_maxheight.setColumns(10);
		
		
		lB_type = new JLabel("Type: ");
		lB_type.setBounds(6, 10, 65, 13);
		getContentPane().add(lB_type);
		
		lB_prix = new JLabel("Prix: ");
		lB_prix.setBounds(6, 41, 45, 13);
		getContentPane().add(lB_prix);
		
		lB_maxheight = new JLabel("Max Height :");
		lB_maxheight.setBounds(6, 70, 115, 13);
		getContentPane().add(lB_maxheight);
		
		ArrayList<Personne> dirList = Monmaine.archive.listRepertoire.chercherParRang("Directeur");
		ArrayList<String> nomDir = new ArrayList<String>();
		for (Personne p : dirList) {
			nomDir.add(p.getNom());
		}

		comboDir = new JComboBox(nomDir.toArray());
		comboDir.setBounds(103, 103, 94, 21);
		getContentPane().add(comboDir);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						        
				if (!(newMeuble() == null))
					dispose();
			}
		});
		
		btnSave.setBounds(103, 152, 128, 21);
		getContentPane().add(btnSave);
		
		lblAddedBy = new JLabel("Ajoute par");
		lblAddedBy.setBounds(6, 107, 76, 13);
		getContentPane().add(lblAddedBy);
		
		
		setVisible(true);
			
		
	}
	
	
	// methode pour ajouter un meuble
	  public Meuble newMeuble(){
		    Meuble newm = null;
		    String type = tF_type.getText();
			double prix = (((Number)tF_prix.getValue()).doubleValue());
			double maxheight = (((Number)tF_maxheight.getValue()).doubleValue());

			if (  (tF_type.getText().length() == 0) )
			{
					JOptionPane.showMessageDialog(null, "Type est manquant");
					
					return null;
			}
		
			
			newm = new Meuble(type, prix, maxheight, comboDir.getSelectedItem().toString());

			Monmaine.archive.produit.getListeMeuble().add(newm);
			Monmaine.archive = this.archive;
			GestionProduit.fillTableM(GestionProduit.tableM,this.archive.produit.getListeMeuble() );
			System.out.println(this.archive.listRepertoire.repertoire);
		
	  return newm;
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
	  
	  
	
	public void actionPerformed(ActionEvent e) {
	 
	}
	
	
}
