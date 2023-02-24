package supermarketTest;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import personnes.*;


public class AddPersone extends JFrame implements ActionListener{
	
    private JTextField tF_nom;
    private JTextField tF_Prenom;
    private JFormattedTextField tF_DateNais;
    private JTextField tf_Depot;
    public JLabel lB_Nom;
    public JComboBox comboBox;
    protected DefaultComboBoxModel model;
    protected JLabel lB_emailAffich;
    JLabel lblTipeDeCompte;
	JLabel lB_prenom ;
	JLabel lB_Nom_1;
	JLabel lB_dateNais;
	JLabel lB_Fonds;
	JButton btnSave;
    
    protected Archive archive;
	
	public AddPersone() {
		
		archive = Monmaine.archive;
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Nouveau compte");
		setBackground(Color.green);
		setBounds(400, 100, 387, 281);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		tF_nom = new JTextField();
		tF_nom.setColumns(10);
		tF_nom.setBounds(182, 9, 96, 19);
		tF_nom.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				lB_emailAffich.setText(tF_nom.getText() + tF_Prenom.getText() + "@magazin.ca");
			}
		});
		tF_nom.addActionListener(this);
		getContentPane().add(tF_nom);
		
		tF_Prenom = new JTextField();
		tF_Prenom.setColumns(10);
		tF_Prenom.setBounds(182, 35, 96, 19);
		tF_Prenom.addActionListener(this);
		tF_Prenom.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				lB_emailAffich.setText(tF_nom.getText() + tF_Prenom.getText() + "@magazin.ca");
			}
		});
		getContentPane().add(tF_Prenom);
		
		tf_Depot = new JTextField();
		tf_Depot.setBounds(182, 139, 96, 19);
		getContentPane().add(tf_Depot);
		tf_Depot.setColumns(10);
		tF_Prenom.addActionListener(this);
		
		
	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		tF_DateNais = new JFormattedTextField(dateFormat);
		tF_DateNais.setColumns(10);
		tF_DateNais.setBounds(182, 66, 96, 19);
		getContentPane().add(tF_DateNais);
		tF_Prenom.addActionListener(this);
		
		JLabel lblTypeDeCompte = new JLabel("Type de compte");
		lblTypeDeCompte.setBounds(10, 95, 115, 13);
		getContentPane().add(lblTypeDeCompte);
		
		
		String[] arg_model = new String[] {"Client", "Employe", "Directeur"};
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel(arg_model));
		comboBox.setBounds(182, 97, 116, 27);
		comboBox.addActionListener((ActionListener) this);
		getContentPane().add(comboBox);
		

		lB_prenom = new JLabel("Prenom: ");
		lB_prenom.setBounds(10, 37, 65, 13);
		getContentPane().add(lB_prenom);
		
		lB_Nom_1 = new JLabel("Nom: ");
		lB_Nom_1.setBounds(10, 9, 45, 13);
		getContentPane().add(lB_Nom_1);
		
		lB_dateNais = new JLabel("Date de naissance: ");
		lB_dateNais.setBounds(10, 66, 160, 13);
		getContentPane().add(lB_dateNais);
		
		
		lB_Fonds = new JLabel("Depot initial");
		lB_Fonds.setBounds(10, 139, 89, 13);
		getContentPane().add(lB_Fonds);
		
		
		
		// Save action 
		btnSave = new JButton("Enregistrer");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Personne p : archive.listRepertoire.getRepertoire()) {
	        		if ((p.getNom().equals(tF_nom.getText())) && (p.getPrenom().equals(tF_Prenom.getText())) && 
	        			 p.getDateDeNaissance().equals(tF_DateNais.getText())) 
	        		   { 
	        			JOptionPane.showMessageDialog(null, "Le compte existe deja");
	        			return;
	        		   }
	        	}			 
		        if((tF_nom.getText().equals(""))) 
		        {
		        	JOptionPane.showMessageDialog(null, "Champs obligatoir nom pas remplis");
//		        
		        	}else if((tF_Prenom.getText().equals("")))
		        {
		        	JOptionPane.showMessageDialog(null, "Champs obligatoir prenom pas remplis");   
//
		        	}else if (tF_DateNais.getText().equals(""))
		        {
					JOptionPane.showMessageDialog(null, "Champs obligatoir date de naissance pas remplis");
		        	} else {
						JOptionPane.showMessageDialog(null, "Creation de nouveau compte avec succes");
						nouveauCompte();
						dispose();
				}  
			      
		}});
		
		
		btnSave.setBounds(123, 203, 150, 21);
		getContentPane().add(btnSave);
		
		JLabel lB_email = new JLabel("e-mail:" );
		lB_email.setBounds(16, 178, 59, 13);
		getContentPane().add(lB_email);
		
		lB_emailAffich= new JLabel();
		lB_emailAffich.setBounds(68, 178, 205, 13);
		lB_emailAffich.setText("@magasin.ca");
		getContentPane().add(lB_emailAffich);
		
		JLabel lB_dateNais_1 = new JLabel("aaaa/mm/jj");
		lB_dateNais_1.setBounds(288, 68, 93, 13);
		getContentPane().add(lB_dateNais_1);
		setVisible(true);
			
		
	}
	
	// on cree une nouvelle personne a partir des informations entrees lors
	// de la creation du compte
	  public Personne nouveauCompte(){
		    Personne newp = null;
		    String nom = tF_nom.getText();
			String prenom = tF_Prenom.getText();;
			String datenec = tF_DateNais.getText();
			
			// creation d'un client
			if (comboBox.getSelectedItem().toString() == "Client") {
				tf_Depot.setEditable(true);
				newp = new Client(nom, prenom, datenec);
				if (tf_Depot.getText() != "") {
					if (validateDouble(tf_Depot.getText())) {
						double montant = Double.parseDouble(tf_Depot.getText());
						newp.compte.addArgent(montant);
					}
				}

			}
			// creation d'un employe
			else if(comboBox.getSelectedItem().toString() == "Employe") 
			{
				tf_Depot.setEditable(true);
				newp = new Employe(nom,prenom,datenec);
				if (tf_Depot.getText() != "") {
					if (validateDouble(tf_Depot.getText())) {
						double montant = Double.parseDouble(tf_Depot.getText());
						newp.compte.addArgent(montant);
					}
				}
			}
			
			// creation d'un directeur
			else if (comboBox.getSelectedItem().toString() == "Directeur") 
			{
				tf_Depot.setEditable(true);
				newp = new Directeur(nom,prenom,datenec);
				if (tf_Depot.getText() != "") {
					if (validateDouble(tf_Depot.getText())) {
						double montant = Double.parseDouble(tf_Depot.getText());
						newp.compte.addArgent(montant);
					}
				}
			}
			
			this.archive.listRepertoire.enregistrerPersonne(newp);
			Monmaine.archive = this.archive;
			
			BienvenueFrame.temporalRepertoir.repertoire = this.archive.listRepertoire.repertoire;
			
			BienvenueFrame.filltable(BienvenueFrame.table,BienvenueFrame.temporalRepertoir.repertoire);
			System.out.println(this.archive.listRepertoire.repertoire);
		
	  return newp;
	  }

	  
	// verifier que l'annee est un int
	public boolean validateYear(String c) {  
				try {
					int num = Integer.parseInt(c);
					if(num > 1900) {
					 return true;
					 }
				}
				catch(Exception e) {
				}	
				return false;	
			}
		  
    // verifier que le montant est un double
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
		if(e.getSource()== comboBox ) { 
			if (comboBox.getSelectedItem().toString() == "Directeur") {
				tf_Depot.setEnabled(true);
			}
			
		}
		
		if(e.getSource()== tF_nom ) {
		 lB_emailAffich.setText(tF_nom.getText() + "." + tF_Prenom.getText() + "@magasin.ca" );

		}	 
	 
	}
}
