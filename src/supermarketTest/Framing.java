package supermarketTest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;


public class Framing extends JFrame implements ActionListener{
	public JButton bienvenueButton;
	public JButton gestionComptes;
	public JButton gestionProduit;
	
	public static BienvenueFrame welcomeFrame;
	public static GestionComptes gestionComptsFrame;
	public static GestionProduit gestionProductFrame;

	public Framing() {
		
		setTitle("MON EPICERIE");
		setBackground(Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,900, 100);
		
		JPanel contenant = new JPanel();
		contenant.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenant.setLayout(null);
		setContentPane(contenant);
	
		
		//frames
		
		gestionComptsFrame = new GestionComptes();
		gestionComptsFrame.setVisible(false);
		gestionProductFrame = new GestionProduit(); 
		gestionProductFrame.setVisible(false);
	
		
		welcomeFrame = new BienvenueFrame();
		welcomeFrame.setVisible(false);
		
		
		// Buttons
	
		bienvenueButton = new JButton("Gestion des Personnes"); // Affichage
		bienvenueButton.setToolTipText("Interface pour chercher / gerer l'enregistrement des personnes (directeur, employes, clients)");
		bienvenueButton.setBounds(6, 6, 173, 42);
		contenant.add(bienvenueButton);
		bienvenueButton.setEnabled(true);
		bienvenueButton.addActionListener(this);
		
		
		gestionComptes = new JButton("Gestion des Comptes");
		gestionComptes.setToolTipText("interface pour gerer les comptes (+/- argent, produits favoris, suppression de compte)");
		gestionComptes.setBounds(342, 6, 173, 42);
		contenant.add(gestionComptes);
		gestionComptes.setEnabled(true);
		gestionComptes.addActionListener(this);
		gestionProduit = new JButton("Gestion des Produits");   // Gestion des produits
		gestionProduit.setToolTipText("interface pour les directeurs: ajouter ou enlever des produits");
		gestionProduit.setBounds(687, 6, 173, 42);
		contenant.add(gestionProduit);
		gestionProduit.setEnabled(true);
		gestionProduit.addActionListener(this);
		
	
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== bienvenueButton) {
			welcomeFrame.setVisible(true);
		}else if(e.getSource()== gestionComptes) { gestionComptsFrame.setVisible(true);} 
		else if(e.getSource()== gestionProduit) {gestionProductFrame.setVisible(true);}
		gestionComptsFrame.comboBox.setSelectedIndex(0);


	}
}
