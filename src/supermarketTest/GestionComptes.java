package supermarketTest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import produits.Aliment;
import produits.Meuble;
import data.*;
import personnes.Client;
import personnes.Personne;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.SystemColor;


public class GestionComptes extends JFrame implements ActionListener{
	protected static Archive archive;
	protected ArrayList<Personne> dataPersonne; 
    protected static Personne laPersonne;
    static Repertoir temporalRepertoir;
    protected GestionProduitsFavoris CP_Frame;
    
    protected static JComboBox<String> comboBox;
    private JTextField tF_nom;
    private JTextField tF_prenom;
    private JTextField tF_DateNaiss;
    private JTextField FondDispo;
    private JTextField tf_Rang;
    private JTextField ajouterArgent;
    private JTextField textField_3;
    private JTextField tF_IDString;
    private static JTable table;
	protected JButton btn_retirerMoney;
    
	protected static int index;
    
    private String identifiant;
    private JTextField tf_retirerArgent;
    private JTextField tf_Mail;
    private JTextField cursor;
    
	
	
	
	public GestionComptes() {
		   
		    archive = Monmaine.archive;
		     
		    this.dataPersonne = archive.listRepertoire.getRepertoire();
		    
		    laPersonne = new Personne(null,null,null);
		    
		    temporalRepertoir = new  Repertoir();
		    temporalRepertoir.repertoire = this.dataPersonne;
    	    
			setTitle("Gestion des Comptes");

			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setBounds(100, 200, 900, 600);
			setBackground(Color.BLUE);
			setVisible(true);
			
			JPanel contenant = new JPanel();
			contenant.setBackground(UIManager.getColor("Button.background"));
			contenant.setBorder(new EmptyBorder(5, 5, 5, 5));
			contenant.setLayout(null);
			setContentPane(contenant);
			
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(457, 96, 372, 340);
			contenant.add(panel);
			
			tF_IDString = new JTextField();
			tF_IDString.setEditable(false);
			tF_IDString.setColumns(10);
			tF_IDString.setBounds(178, 6, 112, 19);
			panel.add(tF_IDString);
			
			ajouterArgent = new JTextField();
			ajouterArgent.setColumns(10);
			ajouterArgent.setBounds(182, 304, 96, 19);
			panel.add(ajouterArgent);
			
			tf_retirerArgent = new JTextField();
			tf_retirerArgent.setColumns(10);
			tf_retirerArgent.setBounds(182, 273, 96, 19);
			panel.add(tf_retirerArgent);
			
			FondDispo = new JTextField();
			FondDispo.setEditable(false);
			FondDispo.setColumns(10);
			FondDispo.setBounds(182, 243, 96, 19);
			panel.add(FondDispo);
			
			JLabel lblFonds = new JLabel("fonds disponibles: ");
			lblFonds.setBounds(6, 244, 121, 13);
			panel.add(lblFonds);
			
			JLabel lblCompteArgent = new JLabel("Compte argent");
			lblCompteArgent.setBounds(6, 207, 129, 13);
			panel.add(lblCompteArgent);
			
			// add et retirer l'Argent
			
			btn_retirerMoney = new JButton("Retirer montant");
			btn_retirerMoney.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String IDString = laPersonne.getIDString();
					String montant = tf_retirerArgent.getText();
					if(validateMontant(montant)) {
						if(verifierListSelectionNonEmpty()) {
							double add = Double.parseDouble(montant);
							Personne pers = new Personne(null,null,null);
							pers = Monmaine.archive.listRepertoire.chercherParIDString (laPersonne.getIDString());
							Monmaine.archive.listRepertoire.chercherParIDString (laPersonne.getIDString()).compte.retirerArgent(add);
							updatesListes();
							tf_retirerArgent.setText("");
							String fond = laPersonne.compte.getMontantString();
							FondDispo.setText(fond);
							table.setRowSelectionInterval((Integer.parseInt(cursor.getText())), (Integer.parseInt(cursor.getText())));

							
						} 
						else {
							JOptionPane.showMessageDialog(null, "S'il vous plaît choisissez une personne dans la liste ");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Assurez vous que le montant est bien un numero");
					}
				}
			});
			btn_retirerMoney.setBounds(6, 269, 129, 21);
			panel.add(btn_retirerMoney);
			
			
			JButton btn_AddMoney = new JButton("Ajouter montant");
			btn_AddMoney.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String IDString = laPersonne.getIDString();
					String montant = ajouterArgent.getText();
					if(validateMontant(montant)) {
						if(verifierListSelectionNonEmpty()) {
							double add = Double.parseDouble(montant);
							Personne pers = new Personne(null,null,null);
							pers = Monmaine.archive.listRepertoire.chercherParIDString (laPersonne.getIDString());
							Monmaine.archive.listRepertoire.chercherParIDString (laPersonne.getIDString()).compte.addArgent(add);
							updatesListes();
							ajouterArgent.setText("");
							String fond = laPersonne.compte.getMontantString();
							FondDispo.setText(fond);
							table.setRowSelectionInterval((Integer.parseInt(cursor.getText())), (Integer.parseInt(cursor.getText())));

							
						} 
						else {
							JOptionPane.showMessageDialog(null, "S'il vous plaît choisissez une personne dans la liste ");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Assurez vous que le montant est bien un numero");
					}
				}
			});
			btn_AddMoney.setBounds(6, 302, 129, 21);
			panel.add(btn_AddMoney);
			
		
			JLabel IDString = new JLabel("ID:");
			IDString.setBounds(6, 9, 115, 13);
			panel.add(IDString);
			
			tF_nom = new JTextField();
			tF_nom.setBounds(178, 37, 112, 19);
			panel.add(tF_nom);
			tF_nom.setColumns(10);
			tF_nom.setEditable(false);
			
			tF_prenom = new JTextField();
			tF_prenom.setBounds(178, 63, 112, 19);
			panel.add(tF_prenom);
			tF_prenom.setColumns(10);
			tF_prenom.setEditable(false);
			
			tF_DateNaiss = new JTextField();
			tF_DateNaiss.setBounds(178, 94, 112, 19);
			panel.add(tF_DateNaiss);
			tF_DateNaiss.setColumns(10);
			tF_DateNaiss.setEditable(false);
			
			tf_Rang = new JTextField();
			tf_Rang.setBounds(178, 125, 112, 19);
			panel.add(tf_Rang);
			tf_Rang.setEditable(false);
			tf_Rang.setColumns(10);
			
			
			JLabel labelNom = new JLabel("Nom: ");
			labelNom.setBounds(6, 37, 45, 13);
			panel.add(labelNom);
			
			JLabel labe = new JLabel("Prenom: ");
			labe.setBounds(6, 66, 65, 13);
			panel.add(labe);
			
			JLabel lblDateNaiss = new JLabel("Date de naissance: ");
			lblDateNaiss.setBounds(6, 95, 141, 13);
			panel.add(lblDateNaiss);
			
			JLabel lblrang = new JLabel("Rang:");
			lblrang.setBounds(6, 124, 115, 13);
			panel.add(lblrang);
			
			tf_Mail = new JTextField();
			tf_Mail.setEditable(false);
			tf_Mail.setColumns(10);
			tf_Mail.setBounds(178, 157, 188, 19);
			panel.add(tf_Mail);
			
			JLabel lblCourriel = new JLabel("Courriel:");
			lblCourriel.setBounds(6, 156, 115, 13);
			panel.add(lblCourriel);
			
			cursor = new JTextField();
			cursor.setBounds(199, 201, 27, 26);
			panel.add(cursor);
			cursor.setVisible(false);
			
			
			JLabel lblNewLabel_1 = new JLabel("Select");
			lblNewLabel_1.setForeground(Color.BLACK);
			lblNewLabel_1.setBackground(SystemColor.window);
			lblNewLabel_1.setBounds(40, 49, 61, 16);
			contenant.add(lblNewLabel_1);
			
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tous les comptes", "Compte Client", "Compte Employe", "Compte Directeur"}));
			comboBox.setBounds(94, 44, 203, 27);
			contenant.add(comboBox);
			comboBox.addActionListener(this);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(37, 96, 369, 258);
			getContentPane().add(scrollPane);
			
			
			table = new JTable();
			scrollPane.setViewportView(table);
			
			table.setBorder(new LineBorder(Color.DARK_GRAY, 2));
			filltable1(table,dataPersonne);
			
						table.setBackground(Color.WHITE);
						table.setForeground(Color.BLUE);
						table.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								
								populateTextPanel();
							}
						});
			
			JButton btn_PreferenceClient = new JButton("Produits favoris de la personne");
			btn_PreferenceClient.setBounds(37, 420, 249, 21);
			contenant.add(btn_PreferenceClient);
			

			JButton btnEffacerLeCompte = new JButton("Effacer le compte");
			btnEffacerLeCompte.setBounds(37, 378, 192, 21);
			contenant.add(btnEffacerLeCompte);
			btnEffacerLeCompte.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						if(verifierListSelectionNonEmpty()) {
							Monmaine.archive.listRepertoire.supprimerPersonne(laPersonne);	
							updatesListes();
						} 
						else {
							JOptionPane.showMessageDialog(null, "S'il vous plaît choisissez une personne dans la liste ");
						}
				}
	
			});
			btn_PreferenceClient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(verifierListSelectionNonEmpty()) {
						  CP_Frame = new GestionProduitsFavoris();
						  CP_Frame.leClient = (Personne) laPersonne;
					  	  
					}else 
						JOptionPane.showMessageDialog(null, "Assurez vous de choisir une personne");
					
				}
			
			});
			
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					index = table.getSelectedRow();
					laPersonne = temporalRepertoir.repertoire.get(index);
					populateTextPanel();
							
				}

			});
				
		}
	

	public static void filltable1(JTable table, ArrayList<Personne> dataPersonne) {
		
		temporalRepertoir.afficherRepertoire(dataPersonne);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setColumnCount(0);
		model.setRowCount(0);
	

		System.out.println("size of record found =" + dataPersonne.size());

        
		model.addColumn("Nom");
        model.addColumn("Prenom");
        model.addColumn("Rang");
        
         
		Object rowdata[] = new Object[4];
		for (int i=0; i< dataPersonne.size() ; i++) {
			System.out.println("i =" + i);
			rowdata[0]=dataPersonne.get(i).getNom();
			System.out.println("rowdata[0] =" + dataPersonne.get(i).getNom());
			rowdata[1]= dataPersonne.get(i).getPrenom();
			System.out.println("rowdata[1] =" + dataPersonne.get(i).getPrenom());
			rowdata[2]= dataPersonne.get(i).getRang();
			System.out.println("rowdata[2] =" + dataPersonne.get(i).getRang());
			System.out.println(rowdata[1]);
			model.addRow(rowdata);

		}
		
		table.setModel(model);

	}
	
	private void updatesListes() {
		 
		GestionComptes.archive = Monmaine.archive;
		this.dataPersonne = archive.listRepertoire.getRepertoire();
		GestionComptes.temporalRepertoir.repertoire = this.dataPersonne;
		BienvenueFrame.temporalRepertoir.repertoire = this.dataPersonne;
		filltable1(table, temporalRepertoir.repertoire);
		filltable1(BienvenueFrame.table, BienvenueFrame.temporalRepertoir.repertoire);
		
	}
	
	
	public void populateTextPanel() {
		
		//this.laPersonne = temporalRepertoir.repertoire.get(row); 
		// cleaning champs  
		tF_nom.setText("");
		tF_prenom.setText("");
		tf_Rang.setText("");
		tf_Mail.setText("");

		FondDispo.setText("");
		tF_DateNaiss.setText("");
		
		//if((table.getModel().getValueAt(row, 2).toString())=="Directeur") {
		tF_nom.setText(this.laPersonne.getNom());
		tF_prenom.setText(laPersonne.getPrenom());
		tf_Rang.setText(laPersonne.getRang());
		tf_Mail.setText(laPersonne.getMail());

		String fond = laPersonne.compte.getMontantString();
		FondDispo.setText(fond);
		tF_DateNaiss.setText(laPersonne.getDateDeNaissance()); 
		tF_IDString.setText(laPersonne.getIDString());
		cursor.setText(index+"");
		
		//}
			
	}
	
	
	public boolean validateMontant(String c) {  // validate year as integer
		try {
			double num = Double.parseDouble(c);
			 return true;
		}
		catch(Exception e) {
		}	
		return false;	
	}
	
	public static boolean verifierListSelectionNonEmpty() {
		boolean ans = false;
		
		try {
			int row = table.getSelectedRow();
			if(row != -1l) { 
			 ans = true;
			}
		}
		catch(Exception e) {
			
		}		
		return ans;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== comboBox) {
			
			if(comboBox.getSelectedItem() == "Compte Client") 
			{
				temporalRepertoir.repertoire = archive.listRepertoire.chercherParRang("Client");
				
			}
			else if(comboBox.getSelectedItem() == "Compte Employe") 
			{
				temporalRepertoir.repertoire = archive.listRepertoire.chercherParRang("Employe");
		
			}
			else if (comboBox.getSelectedItem() == "Compte Directeur") 
			{
				temporalRepertoir.repertoire = archive.listRepertoire.chercherParRang("Directeur");
	
			}
			else {
				
				temporalRepertoir.repertoire = this.dataPersonne;
			}
			
			filltable1(table, temporalRepertoir.repertoire);
			

		}
	}
		
	
}


