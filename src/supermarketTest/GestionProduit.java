package supermarketTest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import data.DataProduit;
import produits.Aliment;
import produits.Meuble;
import produits.Produit;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;



import java.awt.EventQueue;
import java.util.ArrayList;



import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


import personnes.Personne;

import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;



public class GestionProduit  extends JFrame implements ActionListener{

	JFrame frame = this;
	JPanel jPanelMeuble;
	JPanel jPanelAliment;
	JScrollPane scrollPaneM;
    public static JTable tableM, tableA;
    private static JTextField textNom;
    private static JTextField textCouleur;
	private static JTextField textPoids = new JTextField();

    private JLabel lblType;
    private JLabel lblPrix;
    private JLabel lblMaxHeight;
    private static JTextField textType;
    private static JTextField textPrix;
    private static JTextField textMaxHeight;
    private JTabbedPane tabsProduit;
    private JLabel lblTitre; 
    private JPanel infoPanelMeuble;
    private JPanel infoPanelAliment;

    private JLabel lblNom;
    private JLabel lblCouleur;
    private JLabel lblPoids;
    private JComboBox menuDirecteur;       
    private JButton btnSuppA;
    private JButton btnSaveA;
    private JButton BtnAddA;
    private JButton btnAddM;
    private JButton btnSuppM;
	private static ArrayList<Meuble> listeM;
	private static ArrayList<Aliment> listeA;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JLabel lblDirM;
	private static JTextField textDirM;
	private JLabel lblDirA;
    private static JFormattedTextField textDirA;
    
	public GestionProduit() {
	setTitle("Gestion des Produits");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setBounds(100, 200, 900, 600);
	
	setBackground(Color.BLUE);
	setVisible(true);
	
	
    listeA = Monmaine.archive.produit.getListeAliments();
    listeM = Monmaine.archive.produit.getListeMeuble();
	initialize();
	
	
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		/*frame.getContentPane().setBackground(new Color(128, 0, 0));
		frame.setBounds(100, 100, 542, 427);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);*/
		
		
		tabsProduit = new JTabbedPane(JTabbedPane.TOP);
		tabsProduit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//infoPanelMeuble.setVisible(false);
				//infoPanelAliment.setVisible(false);
				tableA.getSelectionModel().clearSelection();
				tableM.getSelectionModel().clearSelection();
			}
		});
		//tabsProduit.setBounds(22, 54, 298, 131);
		tabsProduit.setBounds(100, 200, 900, 600);


	    jPanelAliment = new JPanel();
		jPanelAliment.setLayout(null);
		jPanelAliment.setVisible(true);


        infoPanelAliment = new JPanel();
        infoPanelAliment.setBounds(420, 57, 232, 156);

        
        infoPanelMeuble = new JPanel();
        infoPanelMeuble.setBounds(384, 61, 232, 156);
        
        
       // frame.getContentPane().add(infoPanel);
        infoPanelAliment.setVisible(true);
        infoPanelAliment.setLayout(null);
        
        lblNom = new JLabel("Nom");
        lblNom.setBounds(10, 10, 38, 13);
        infoPanelAliment.add(lblNom);
        
        lblCouleur = new JLabel("Couleur");
        lblCouleur.setBounds(10, 39, 66, 13);
        infoPanelAliment.add(lblCouleur);
        
        lblPoids = new JLabel("Poids");
        lblPoids.setBounds(10, 68, 45, 13);
        infoPanelAliment.add(lblPoids);
		
        textNom = new JTextField();
        textNom.setBounds(120, 7, 96, 19);
        infoPanelAliment.add(textNom);
        textNom.setColumns(10);
        
        textCouleur = new JTextField();
        textCouleur.setBounds(120, 36, 96, 19);
        infoPanelAliment.add(textCouleur);
        textCouleur.setColumns(10);
        
        textPoids = new JFormattedTextField();
        textPoids.setBounds(120, 65, 96, 19);
        infoPanelAliment.add(textPoids);
        textPoids.setColumns(10);
        textPoids.setText("");
        infoPanelMeuble.setLayout(null);
        
        lblPrix = new JLabel("Prix");
        lblPrix.setBounds(10, 39, 45, 13);
        infoPanelMeuble.add(lblPrix);
        
        lblMaxHeight = new JLabel("Hauteur max");
        lblMaxHeight.setBounds(10, 68, 100, 13);
        infoPanelMeuble.add(lblMaxHeight);
        
        lblType = new JLabel("Type");
        lblType.setBounds(10, 10, 45, 13);
        infoPanelMeuble.add(lblType);
        
        textType = new JTextField();
        textType.setBounds(120, 7, 96, 19);
        infoPanelMeuble.add(textType);
        textType.setColumns(10);
        
        textPrix = new JTextField();
        textPrix.setBounds(120, 36, 96, 19);
        infoPanelMeuble.add(textPrix);
        textPrix.setColumns(10);
        
        textMaxHeight = new JTextField();
        textMaxHeight.setBounds(120, 65, 96, 19);
        infoPanelMeuble.add(textMaxHeight);
        textMaxHeight.setColumns(10);
		
      
		jPanelAliment.setLayout(null);
		jPanelAliment.add(infoPanelAliment);
		
		tabsProduit.add(jPanelAliment,"Aliments");
    	tabsProduit.setVisible(true);
        frame.getContentPane().add(tabsProduit);
            
        jPanelMeuble = new JPanel();
        jPanelMeuble.setLayout(null);
        jPanelMeuble.setVisible(true);
        jPanelMeuble.setBounds(489, 97, 300, 197);
    	jPanelMeuble.add(infoPanelMeuble);

        tabsProduit.add(jPanelMeuble, "Meubles");
  
            
        btnSaveA = new JButton("save");
        btnSaveA.setBounds(10, 125, 87, 21);
  
        btnSaveA.addMouseListener(new MouseAdapter() {
        		public void mouseClicked(MouseEvent e) {
        			
        			
        			if(verifierListSelectionNonEmpty(tableA)) {
        				 saveInfoA();
					}else {
							JOptionPane.showMessageDialog(null, "S'il vous plaît choisissez un aliment dans la liste ");
						}
        			
        		   
        		}
        	});
            
            
            
        	
            infoPanelAliment.add(btnSaveA);
            
            btnSuppA = new JButton("delete");
            btnSuppA.setBounds(129, 125, 87, 21);
            btnSuppA.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		
            		
            		if(verifierListSelectionNonEmpty(tableA)) {
                		supprimerA();
					}else {
							JOptionPane.showMessageDialog(null, "S'il vous plaît choisissez un aliment dans la liste ");
						}
            		
            	}
            });
            infoPanelAliment.add(btnSuppA);
            
            lblDirA = new JLabel("Ajoute par");
            lblDirA.setBounds(10, 102, 87, 13);
            infoPanelAliment.add(lblDirA);
            
            textDirA = new JFormattedTextField();
            textDirA.setText("");
            textDirA.setColumns(10);
            textDirA.setBounds(120, 96, 96, 19);
            infoPanelAliment.add(textDirA);
            textDirA.setEditable(false);
            //textDirA.setText(AddAliment.getComboDir().getSelectedItem().toString());
            
            BtnAddA = new JButton("Ajouter Aliments");
            BtnAddA.setBounds(21, 246, 232, 21);
            jPanelAliment.add(BtnAddA);
            
            scrollPane = new JScrollPane();
            scrollPane.setBounds(21, 43, 369, 185);
            jPanelAliment.add(scrollPane);
            tableA = new JTable();
            scrollPane.setViewportView(tableA);
            tableA.setBorder(new LineBorder(Color.DARK_GRAY, 2));
            tableA.setBackground(Color.WHITE);
            tableA.setForeground(Color.BLUE);
            tableA.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					try {
						//infoPanel.setVisible(true);
						populateTextPanelA();
						lblCouleur.setVisible(true);
						lblNom.setVisible(true);
						lblPoids.setVisible(true);
						btnSaveA.setVisible(true);
						btnSuppA.setVisible(true);
					}
					catch(ArrayIndexOutOfBoundsException exception) {
					    System.out.println("Clicking outside the selected rows");
					}
				}
			});
            
		    fillTableA(tableA,listeA);
            BtnAddA.addMouseListener(new MouseAdapter() {
            	public void mouseClicked(MouseEvent e) {
            		addA();
            	}
            });
            
            JButton btnSaveM = new JButton("save");
            btnSaveM.setBounds(10, 125, 87, 21);
       
            
      
            btnSaveM.addMouseListener(new MouseAdapter() {
        		public void mouseClicked(MouseEvent e) {
        			
        			if(verifierListSelectionNonEmpty(tableM)) {
            		    saveInfoM();
					}else {
							JOptionPane.showMessageDialog(null, "S'il vous plaît choisissez un meuble dans la liste ");
						}
        		}
        	});
            
            
            infoPanelMeuble.add(btnSaveM);
            
            btnSuppM = new JButton("delete");
            btnSuppM.setBounds(131, 125, 85, 21);
            btnSuppM.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		
            		
        			if(verifierListSelectionNonEmpty(tableM)) {
                		supprimerM();
					}else {
							JOptionPane.showMessageDialog(null, "S'il vous plaît choisissez un meuble dans la liste ");
						}
        			
            	}
            });
            infoPanelMeuble.add(btnSuppM);
            
            lblDirM = new JLabel("Ajoute par");
            lblDirM.setBounds(10, 102, 75, 13);
            infoPanelMeuble.add(lblDirM);
            
            textDirM = new JTextField();
            textDirM.setColumns(10);
            textDirM.setBounds(120, 96, 96, 19);
            infoPanelMeuble.add(textDirM);
            textDirM.setEditable(false);
         
       
            btnAddM = new JButton("Ajouter Meubles");
          
            btnAddM.setBounds(21, 264, 232, 21);
            jPanelMeuble.add(btnAddM);
            
            scrollPane_1 = new JScrollPane();
            scrollPane_1.setBounds(21, 45, 340, 179);
            jPanelMeuble.add(scrollPane_1);
            
                    
                            
    		tableM = new JTable();
    		scrollPane_1.setViewportView(tableM);
    		tableM.setBorder(new LineBorder(Color.DARK_GRAY, 2));
    		tableM.setBackground(Color.WHITE);
    		tableM.setForeground(Color.BLUE);
                    		
            tableM.addMouseListener(new MouseAdapter() {
        			public void mouseClicked(MouseEvent e) {
        				
        				try {
        					//tableM.clearSelection();
            				populateTextPanelM();
            				//infoPanel.setVisible(true);
            				lblType.setVisible(true);
            				lblPrix.setVisible(true);
            				lblMaxHeight.setVisible(true);
            				textType.setVisible(true);
            				textPrix.setVisible(true);
            				textMaxHeight.setVisible(true);
    					}
    					catch(ArrayIndexOutOfBoundsException exception) {
    					    System.out.println("Clicking outside the selected rows");
    					}
        		
        			}
        		});
        		fillTableM(tableM,listeM);
            btnAddM.addMouseListener(new MouseAdapter() {
            	public void mouseClicked(MouseEvent e) {
            		addM();
            	}
            });
            
        
  }
	
	
	
	
	public void addA() {   		
		AddAliment add = new AddAliment();

   }
	
	public Aliment buildAfromPanel() { 
		double poids = Double.parseDouble(textPoids.getText());
		Aliment newA = new Aliment (textNom.getText(), textCouleur.getText(), poids, textDirA.getText());
		clearA();
		newA.toString();
		return newA;
	}
	
	
	public void clearA() {
		textPoids.setText("");
		textCouleur.setText("");
		textNom.setText("");

	}
	public void addM() {   		
		AddMeuble add = new AddMeuble();
   }
	
	public Meuble buildMfromPanel() {
		double prix = Double.parseDouble(textPrix.getText());
		double maxheight = Double.parseDouble(textMaxHeight.getText());
		Meuble newM = new Meuble(textType.getText(), prix, maxheight, textDirM.getText());
		newM.toString();
		clearM();
		return newM;
	}
	
	static void fillTableA(JTable table, ArrayList<Aliment>listeA) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		model.setColumnCount(0);
		model.setRowCount(0);
		        
		model.addColumn("Nom");
        model.addColumn("Couleur");
        model.addColumn("Poids");
        model.addColumn("Ajout� par");



		Object rowdata[] = new Object[4];
		for (int i=0; i<listeA.size() ; i++) {
			rowdata[0] = listeA.get(i).getNom();
			rowdata[1] = listeA.get(i).getCouleur();
			rowdata[2] = listeA.get(i).getPoids();
			rowdata[3] = listeA.get(i).getAddedBy();
	
			model.addRow(rowdata);

		}
		table.setModel(model);
	}
	
	
	
	public void saveInfoA() {  
		
		if (  (textNom.getText().length() == 0) )
		{
				JOptionPane.showMessageDialog(null, "Nom est manquant");
				
				return ;
		}
		
		if (  (textCouleur.getText().length() == 0) )
		{
				JOptionPane.showMessageDialog(null, "Couleur est manquant");
				
				return ;
		}
		
		int modelIndex = tableA.convertRowIndexToModel(tableA.getSelectedRow());
		System.out.println("//////////");
		listeA.set(modelIndex, buildAfromPanel());
		System.out.println("//////////");
		fillTableA(tableA,listeA);
	}
	
	
	public void saveInfoM() {  
		
	
		if(!isValidM())
			return;
		
		int modelIndex = tableM.convertRowIndexToModel(tableM.getSelectedRow());
		System.out.println("//////////");
		
		listeM.set(modelIndex, buildMfromPanel());
		System.out.println("//////////");
		fillTableM(tableM,listeM);
		clearM();
	}
	
	public Boolean isValidM()
	{
		if (  (textType.getText().length() == 0) )
		{
				JOptionPane.showMessageDialog(null, "Type est manquant");
				
				return false;
		}
		
		if (  (textPrix.getText().length() == 0) && !(validateDouble(textPrix.getText())))
		{
				JOptionPane.showMessageDialog(null, "Prix est manquant ou Pas Valide ");
				
				return false;
		}
		if (  (textMaxHeight.getText().length() == 0) && !(validateDouble(textMaxHeight.getText())))
		{
				JOptionPane.showMessageDialog(null, "Hauteur Maximum est manquante  ou Pas Valide ");
				
				return false ;
		}
		
		return true;
	}

	
	public void clearM()
	{

		textType.setText("");
		textPrix.setText("");
		textMaxHeight.setText("");


		
	}
	static void fillTableM(JTable table, ArrayList<Meuble>listeA) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
	
		//DataProduit.afficherM();
	
		model.setColumnCount(0);
		model.setRowCount(0);
		
	//	System.out.println("size of record found =" + dataPersonne.size());
	    
		model.addColumn("Type");
	    model.addColumn("Prix");
	    model.addColumn("Max Height");
        model.addColumn("Ajout� par");
	
		Object rowdata[] = new Object[4];
		for (int i=0; i<listeM.size() ; i++) {
			rowdata[0] = listeM.get(i).getType();
			rowdata[1] = listeM.get(i).getPrix();
			rowdata[2] = listeM.get(i).getMaxHeight();
			rowdata[3] = listeM.get(i).getAddedBy();

			model.addRow(rowdata);
	
		}
		table.setModel(model);
	}
	


	public static void populateTextPanelA() {
		int column = 0;
		int row = tableA.getSelectedRow();
		String value = tableA.getModel().getValueAt(row, column).toString();
		textNom.setText(value);
		column = 1; 
		value = tableA.getModel().getValueAt(row, column).toString();
		textCouleur.setText(value);
		column = 2; 
		value = tableA.getModel().getValueAt(row, column).toString();
		textPoids.setText(value);
		column = 3;
		value = tableA.getModel().getValueAt(row, column).toString(); 
		textDirA.setText(value);

	}
	
	public static void populateTextPanelM() {
		int column = 0;
		int row = tableM.getSelectedRow();
		String value = tableM.getModel().getValueAt(row, column).toString();
		textType.setText(value);
		column = 1; 
		value = tableM.getModel().getValueAt(row, column).toString();
		textPrix.setText(value);
		column = 2; 
		value = tableM.getModel().getValueAt(row, column).toString();
		textMaxHeight.setText(value);
		column = 3;
		value = tableM.getModel().getValueAt(row, column).toString(); 
		textDirM.setText(value);
	}

	public  void supprimerA() {
		int row = tableA.getSelectedRow();
		Monmaine.archive.produit.supprimerAliment(row);
		System.out.println(listeA);
		fillTableA(tableA, listeA);
		System.out.println(listeA);
		clearA();
	}
	
	public  void supprimerM() {
		int row = tableM.getSelectedRow();
		Monmaine.archive.produit.supprimerMeuble(row);
		System.out.println(listeM);
		fillTableM(tableM, listeM);
		System.out.println(listeM);
		clearM();
	}

	public static boolean verifierListSelectionNonEmpty(JTable tbl) {
		boolean ans = false;
		
		try {
			int row = tbl.getSelectedRow();
			if(row != -1l) { 
			 ans = true;
			}
		}
		catch(Exception e) {
			
		}		
		return ans;
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
	
	public static JTable getTableM() {
		return tableM;
	}

	public static void setTableM(JTable tableM) {
		GestionProduit.tableM = tableM;
	}

	public static JTable getTableA() {
		return tableA;
	}

	public static void setTableA(JTable tableA) {
		GestionProduit.tableA = tableA;
	}

	public static JTextField getTextNom() {
		return textNom;
	}

	public static void setTextNom(JTextField textNom) {
		GestionProduit.textNom = textNom;
	}

	public static JTextField getTextCouleur() {
		return textCouleur;
	}

	public static void setTextCouleur(JTextField textCouleur) {
		GestionProduit.textCouleur = textCouleur;
	}

	public static JTextField getTextPoids() {
		return textPoids;
	}

	public static void setTextPoids(JFormattedTextField textPoids) {
		GestionProduit.textPoids = textPoids;
	}

	public JLabel getLblType() {
		return lblType;
	}

	public void setLblType(JLabel lblType) {
		this.lblType = lblType;
	}

	public JLabel getLblPrix() {
		return lblPrix;
	}

	public void setLblPrix(JLabel lblPrix) {
		this.lblPrix = lblPrix;
	}

	public JLabel getLblMaxHeight() {
		return lblMaxHeight;
	}

	public void setLblMaxHeight(JLabel lblMaxHeight) {
		this.lblMaxHeight = lblMaxHeight;
	}

	public static JTextField getTextType() {
		return textType;
	}

	public static void setTextType(JTextField textType) {
		GestionProduit.textType = textType;
	}

	public static JTextField getTextPrix() {
		return textPrix;
	}

	public static void setTextPrix(JTextField textPrix) {
		GestionProduit.textPrix = textPrix;
	}

	public static JTextField getTextMaxHeight() {
		return textMaxHeight;
	}

	public static void setTextMaxHeight(JTextField textMaxHeight) {
		GestionProduit.textMaxHeight = textMaxHeight;
	}

	public JLabel getLblTitre() {
		return lblTitre;
	}

	public void setLblTitre(JLabel lblTitre) {
		this.lblTitre = lblTitre;
	}

	public JPanel getInfoPanelMeuble() {
		return infoPanelMeuble;
	}
	
	
	public JPanel getInfoPanelAliment() {
		return infoPanelAliment;
	}

	public void setInfoPanelMeuble(JPanel infoPanel) {
		this.infoPanelMeuble = infoPanel;
	}

	public JLabel getLblNom() {
		return lblNom;
	}

	public void setLblNom(JLabel lblNom) {
		this.lblNom = lblNom;
	}

	public JLabel getLblCouleur() {
		return lblCouleur;
	}

	public void setLblCouleur(JLabel lblCouleur) {
		this.lblCouleur = lblCouleur;
	}

	public JLabel getLblPoids() {
		return lblPoids;
	}

	public void setLblPoids(JLabel lblPoids) {
		this.lblPoids = lblPoids;
	}

	public JButton getBtnSuppA() {
		return btnSuppA;
	}

	public void setBtnSuppA(JButton btnSuppA) {
		this.btnSuppA = btnSuppA;
	}

	public JButton getBtnSaveA() {
		return btnSaveA;
	}

	public void setBtnSaveA(JButton btnSaveA) {
		this.btnSaveA = btnSaveA;
	}

	public JButton getFinalBtnAddA() {
		return BtnAddA;
	}

	public void setFinalBtnAddA(JButton finalBtnAddA) {
		this.BtnAddA = finalBtnAddA;
	}

	
	public JButton getBtnAddM() {
		return btnAddM;
	}

	public void setBtnAddM(JButton btnAddM) {
		this.btnAddM = btnAddM;
	}



	public JButton getBtnSuppM() {
		return btnSuppM;
	}

	public void setBtnSuppM(JButton btnSuppM) {
		this.btnSuppM = btnSuppM;
	}
}

