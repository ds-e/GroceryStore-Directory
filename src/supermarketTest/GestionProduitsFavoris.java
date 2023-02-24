package supermarketTest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import personnes.Personne;
import produits.Aliment;
import produits.Meuble;


public class GestionProduitsFavoris extends JFrame implements ActionListener{
    protected ArrayList<Aliment> listeAlimentsleClient;
    protected ArrayList<Aliment> listeAlimentDispo;
    
    protected ArrayList<Meuble> listeMeublesleClient;
    protected ArrayList<Meuble> listeMeublesDispo;
    
	protected Personne leClient; 
	protected JTable table;
    protected Personne pers;
    protected JComboBox<String> productChoice;
    protected JTable table_ProdDispo;
	protected JLabel lbl_TypeProdDisp;
	protected JLabel lbl_produitDispo;
    
    public static int index;
	
	public GestionProduitsFavoris() { 
		
		leClient = new Personne(null,null,null);
		leClient = GestionComptes.laPersonne;
		
		listeAlimentsleClient = leClient.produiPref.getListeAliments();
		listeMeublesleClient = leClient.produiPref.getListeMeuble();
		
		listeAlimentDispo = Monmaine.archive.produit.getListeAliments();
		listeMeublesDispo = Monmaine.archive.produit.getListeMeuble();
		
	
		setTitle("Preferences du client(e)");
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 200, 900, 600);
		setBackground(Color.BLUE);
		getContentPane().setLayout(null);
		setVisible(true);	
		
		
		JLabel lbl_nom = new JLabel();
		lbl_nom.setText("Personne : ");
		lbl_nom.setBounds(28,18,70,30);
		getContentPane().add(lbl_nom);
		
		JLabel lbl_LeNomEtPrenom = new JLabel();
		String nomPrenom = "";
		nomPrenom = leClient.getPrenom() + " " + leClient.getNom();
		lbl_LeNomEtPrenom.setText(nomPrenom);
		lbl_LeNomEtPrenom.setBounds(110,18,150,30);
		getContentPane().add(lbl_LeNomEtPrenom);
		
		productChoice = new JComboBox<String>();
		productChoice.setModel(new DefaultComboBoxModel(new String[] {"Aliments", "Meubles"}));
		productChoice.setBounds(23, 96, 330, 30);
		getContentPane().add(productChoice);
		productChoice.addActionListener(this);
		
		table = new JTable();
		table.setForeground(Color.BLUE);
		table.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		table.setBackground(Color.WHITE);
		table.setBounds(512, 157, 349, 324);
		getContentPane().add(table);
		filltableAliment(table,listeAlimentsleClient);
		
		JLabel lbl_nom_1 = new JLabel();
		lbl_nom_1.setText("Sélectionner le type de produit ");
		lbl_nom_1.setBounds(32, 69, 228, 30);
		getContentPane().add(lbl_nom_1);
		
		table_ProdDispo = new JTable();
		table_ProdDispo.setForeground(Color.BLUE);
		table_ProdDispo.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		table_ProdDispo.setBackground(Color.WHITE);
		table_ProdDispo.setBounds(23, 157, 349, 324);
		getContentPane().add(table_ProdDispo);
		filltableAliment(table_ProdDispo,listeAlimentDispo );
		
		
	    lbl_produitDispo = new JLabel();
		lbl_produitDispo.setText("Aliments disponibles :");
		lbl_produitDispo.setBounds(23, 130, 157, 30);
		getContentPane().add(lbl_produitDispo);
		
		lbl_TypeProdDisp = new JLabel();
		lbl_TypeProdDisp.setBounds(534, 130, 157, 30);
		getContentPane().add(lbl_TypeProdDisp);
		lbl_TypeProdDisp.setText("Aliments préférés:");
		
		JButton btn_addToClient = new JButton("ajouter");
		btn_addToClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = table_ProdDispo.getSelectedRow();
				if(verifierListSelectionNonEmpty(table_ProdDispo)) {
					if(productChoice.getSelectedItem() == "Aliments") 
					{
						   if(!(listeAlimentsleClient.contains(listeAlimentDispo.get(index)))) { 
							   
							   (Monmaine.archive.listRepertoire.chercherParIDString (leClient.getIDString())).addAlimentPref(listeAlimentDispo.get(index));
							   
							   filltableAliment(table,listeAlimentsleClient );
							   
						   }else {
								JOptionPane.showMessageDialog(null, "L'élément sélectionné est déjà dans la liste");
						   }
					}else if(productChoice.getSelectedItem() == "Meubles") { 
						   if(!(listeMeublesleClient.contains(listeMeublesDispo.get(index)))) { 
							   
							   ( Monmaine.archive.listRepertoire.chercherParIDString (leClient.getIDString())).addMeublePref(listeMeublesDispo.get(index));
						   
							   filltableMeuble(table,listeMeublesleClient);
						   }else {
								JOptionPane.showMessageDialog(null, "L'élément sélectionné est déjà dans la liste");
						   }
					}
					}
				
				else {
					JOptionPane.showMessageDialog(null, "Assurez vous de selectioner un produit disponible");
				}	
			
				//updatesListes(); 
			}});
		
		btn_addToClient.setBounds(399, 255, 83, 29);
		getContentPane().add(btn_addToClient);
		
		JButton btn_removeFromClient = new JButton("enlever");
		btn_removeFromClient.setBounds(399, 294, 83, 29);
		getContentPane().add(btn_removeFromClient);
		
		btn_removeFromClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = table.getSelectedRow();
			if(verifierListSelectionNonEmpty(table)) {
				if(productChoice.getSelectedItem() == "Aliments") {
				   (Monmaine.archive.listRepertoire.chercherParIDString (leClient.getIDString())).removeAlimentPref(listeAlimentsleClient.get(index));
						   filltableAliment(table,listeAlimentsleClient); 
					   
				}else if(productChoice.getSelectedItem() == "Meubles") {
					     (Monmaine.archive.listRepertoire.chercherParIDString (leClient.getIDString())).removeMeublePref(listeMeublesleClient.get(index));
						   filltableMeuble(table,listeMeublesleClient);
					   
				}
		    }
			
			else {
				JOptionPane.showMessageDialog(null, "Assurez vous de selectionner un produit");
			}	
			
			}
			
			
		});
	
	}
	
	
	
	public void filltableMeuble(JTable table, ArrayList<Meuble> listProduit) {
		
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setColumnCount(0);
			model.setRowCount(0);
	
			model.addColumn("Type");
		    model.addColumn("Prix CAD");
		    model.addColumn("Houteur cm");
		    
			Object rowdata[] = new Object[3];
			for (int i=0; i< listProduit.size() ; i++) {
				
				rowdata[0]=listProduit.get(i).getType();
				
				rowdata[1]= listProduit.get(i).getPrix();
				
				rowdata[2]= listProduit.get(i).getMaxHeight();
				
				model.addRow(rowdata);
	
			}
			table.setModel(model);

	}

	
	public void filltableAliment(JTable table, ArrayList<Aliment> listAliment) {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setColumnCount(0);
		model.setRowCount(0);
	   
		model.addColumn("Nom");
	    model.addColumn("Couleur");
	    model.addColumn("Poids");
	    
		Object rowdata[] = new Object[3];
		for (int i=0; i< listAliment.size() ; i++) {
			
			rowdata[0]= listAliment.get(i).getNom();
			rowdata[1]= listAliment.get(i).getCouleur();
			rowdata[2]= listAliment.get(i).getPoids();
			
			model.addRow(rowdata);
	
		}
		table.setModel(model);
		
	}

	public boolean verifierListSelectionNonEmpty(JTable table) {
		
		try {
			int row = table.getSelectedRow();
			if(row != -1l) { 
			 return true;
			}
		}
		catch(Exception e) {		
		}		
		return false;
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == productChoice) {
			if(productChoice.getSelectedItem() == "Aliments") 
			{
				lbl_TypeProdDisp.setText("Aliments préférés");
				lbl_produitDispo.setText("Aliments Disponibles");
				filltableAliment(table,listeAlimentsleClient );
				filltableAliment(table_ProdDispo,listeAlimentDispo );
			} 
			else if(productChoice.getSelectedItem() == "Meubles")
			{
				lbl_TypeProdDisp.setText("Meubles préférés");
				lbl_produitDispo.setText("Meubles Disponibles");
				filltableMeuble(table,listeMeublesleClient);
				filltableMeuble(table_ProdDispo,listeMeublesDispo);
			}
		}
	}


}
