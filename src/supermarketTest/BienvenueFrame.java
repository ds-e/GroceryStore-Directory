package supermarketTest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import data.Repertoir;
import personnes.Personne;

public class BienvenueFrame extends JFrame implements ActionListener{
	
	public static JTable table;
	private JTextField textprenom;
	private JTextField textdatedenaissance;
	private JTextField textnom;
	private JTextField textfonds;
	private JTextField searchcriteria;
	private JTextField textrang;
    protected static Archive archive;
    protected ArrayList<Personne> dataPersonne; 
    protected JComboBox<String> comboBox;
    protected Personne laPersonne; 
    static Repertoir temporalRepertoir;
    private JTextField textId;
    private JTextField textemail;
    private JScrollPane scrollPane;
      
    public BienvenueFrame() {
		
    	    archive = Monmaine.archive;
    	     
    	    this.dataPersonne = archive.listRepertoire.getRepertoire();
    	     
    	    temporalRepertoir = new  Repertoir();
    	    temporalRepertoir.repertoire = this.dataPersonne;
    	   
    	    
    	    setTitle("BIENVENUE!");
    	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setBounds(100, 200, 900, 600);
			setBackground(Color.BLUE);
			setVisible(true);
    	    
			//getContentPane().setBackground(new Color(102, 51, 102));
			getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Chercher par \r\ninitial/nom :");
			lblNewLabel.setForeground(Color.black);
			lblNewLabel.setBounds(393, 29, 145, 26);
			getContentPane().add(lblNewLabel);
			
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(27, 96, 369, 258);
			getContentPane().add(scrollPane);
			
			
			table = new JTable();
			scrollPane.setViewportView(table);
			
			table.setBorder(new LineBorder(Color.DARK_GRAY, 2));
			filltable(table,dataPersonne);
			
						table.setBackground(Color.WHITE);
						table.setForeground(Color.BLUE);
						table.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								
								populateTextPanel();
							}
						});
			
			final JPanel panel = new JPanel();
			panel.setBounds(428, 93, 342, 261);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			textnom = new JTextField();
			textnom.setEditable(false);
			textnom.setBounds(165, 41, 96, 19);
			panel.add(textnom);
			textnom.setColumns(10);
			
			textprenom = new JTextField();
			textprenom.setEditable(false);
			textprenom.setBounds(165, 72, 96, 19);
			panel.add(textprenom);
			textprenom.setColumns(10);
			
			textdatedenaissance = new JTextField();
			textdatedenaissance.setEditable(false);
			textdatedenaissance.setBounds(165, 103, 96, 19);
			panel.add(textdatedenaissance);
			textdatedenaissance.setColumns(10);
			
			JLabel labelNom = new JLabel("Nom:");
			labelNom.setBounds(6, 45, 65, 13);
			panel.add(labelNom);
			
			JLabel labe = new JLabel("Prenom: ");
			labe.setBounds(6, 78, 65, 13);
			panel.add(labe);
			
			JLabel lblDateNaiss = new JLabel("Date de naissance: ");
			lblDateNaiss.setBounds(6, 107, 147, 13);
			panel.add(lblDateNaiss);
			
			textfonds = new JTextField();
			textfonds.setEditable(false);
			textfonds.setBounds(165, 206, 96, 19);
			panel.add(textfonds);
			textfonds.setColumns(10);
			
			JLabel lblFonds = new JLabel("Fonds Disponibles: ");
			lblFonds.setBounds(6, 209, 136, 13);
			panel.add(lblFonds);
			
			textrang = new JTextField();
			textrang.setEditable(false);
			textrang.setColumns(10);
			textrang.setBounds(165, 134, 96, 19);
			panel.add(textrang);
			
			JLabel lblrang = new JLabel("Rang:");
			lblrang.setBounds(6, 136, 115, 13);
			panel.add(lblrang);
			
			JLabel lblIdentifiantDeCompte = new JLabel("ID:");
			lblIdentifiantDeCompte.setBounds(6, 20, 146, 13);
			panel.add(lblIdentifiantDeCompte);
			
			textId = new JTextField();
			textId.setBounds(164, 13, 96, 19);
			panel.add(textId);
			textId.setColumns(10);
			textId.setEditable(false);
			
			JLabel lblCourriel = new JLabel("Courriel:");
			lblCourriel.setBounds(6, 171, 136, 13);
			panel.add(lblCourriel);
			
			textemail = new JTextField();
			textemail.setEditable(false);
			textemail.setColumns(10);
			textemail.setBounds(165, 165, 171, 19);
			panel.add(textemail);
			
			searchcriteria = new JTextField();
			searchcriteria.setBounds(538, 30, 130, 26);
			getContentPane().add(searchcriteria);
			searchcriteria.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Select");
			lblNewLabel_1.setBackground(UIManager.getColor("CheckBox.background"));
			lblNewLabel_1.setForeground(Color.BLACK);
			lblNewLabel_1.setBounds(27, 37, 61, 16);
			getContentPane().add(lblNewLabel_1);
			
			
			// Search
			JButton btnSearch = new JButton("Chercher");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					///   Je suis ici.. Je travail pour fair funcioner la recherche..
					temporalRepertoir.repertoire = archive.listRepertoire.chercherParLettreOuNom(searchcriteria.getText());
					filltable(table, temporalRepertoir.repertoire);
				}
			});
		
			btnSearch.setBounds(678, 32, 92, 21);
			getContentPane().add(btnSearch);
			
			
			// add btn
			JButton btnadd = new JButton("Nouveau Compte");
			btnadd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddPersone add = new AddPersone();
				}
			});
			btnadd.setBounds(27, 384, 203, 29);
			getContentPane().add(btnadd);
			
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tous les comptes", "Compte Client", "Compte Employe", "Compte Directeur"}));
			comboBox.setBounds(82, 30, 203, 27);
			getContentPane().add(comboBox);
			comboBox.addActionListener(this);
			
			

		}
		
    
    
		
		public static void filltable(JTable table, ArrayList<Personne> dataPersonne) {
			
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

		
		public int[] getRowElmts() {
		    int[] selection = table.getSelectedRows();
		    for (int i = 0; i < selection.length; i++) {
		         selection[i] = table.convertRowIndexToModel(selection[i]);
		        return selection;
		   }
			return null;
		}
		
		
		public void populateTextPanel() {
			//int column = 0;
			int row = table.getSelectedRow();
			this.laPersonne = temporalRepertoir.repertoire.get(row); 
			// cleaning champs  
			textnom.setText("");
			textprenom.setText("");
			textrang.setText("");
			textfonds.setText("");
			textdatedenaissance.setText("");
			
			//if((table.getModel().getValueAt(row, 2).toString())=="Directeur") {
			textnom.setText(this.laPersonne.getNom());
			textprenom.setText(laPersonne.getPrenom());
			textrang.setText(laPersonne.getRang());
			textemail.setText(laPersonne.getMail());
			String fond = laPersonne.compte.getMontantString();
			textfonds.setText(fond);
			textdatedenaissance.setText(laPersonne.getDateDeNaissance()); 
			textId.setText(laPersonne.getIDString());
			
			//}
				
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
			
			filltable(table, temporalRepertoir.repertoire);
			

		}
	}
}
