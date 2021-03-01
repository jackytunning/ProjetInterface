package com.projetInterface.View;
 

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.morpion.Model.*;

@SuppressWarnings("serial")
public class View extends JFrame implements ActionListener{
	private JPanel menu;
	private JPanel menu1;
	private JPanel menu2;
	
	private JPanel contenu;
	//private JPanel menuJeu;
	private JPanel panelJeux;
	private JPanel panelJeu;
	private JPanel utilisateurs;
	private JPanel utilisateur;
	private JButton boutonJeux;
	private JButton boutonUtilisateurs;
	CardLayout card;
	
	private JPanel panel;
	
	private JButton boutonTemp;
	private JButton boutonTemp2;
	
	
	
	
	
	
	public View() {
		super();
		setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		initialize();
		
	}
	public JFrame getFrame() {
		return this;
	}
	private void initialize() {
			this.getContentPane().setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 17));
			this.getContentPane().setBackground(new Color(245, 222, 179));
			this.setBounds(100, 100, 1280, 800);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("interface");
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			this.initMenu();
			this.initContenu();
			panel = new JPanel();
			panel.setSize(new Dimension(1280, 800));
			panel.setLayout(null);
			panel.setOpaque(false);
			panel.add(menu);
			panel.add(contenu);
			this.getContentPane().add(panel);
	}
	
	private void initMenu() {
		this.boutonJeux= new JButton("Jeux");
		this.boutonJeux.addActionListener(this);
		this.boutonUtilisateurs= new JButton("Utilisateurs");
		this.boutonUtilisateurs.addActionListener(this);
		this.menu = new JPanel();
		this.menu.setBounds(0,0,290,800);
		this.menu.setBackground(Color.yellow);
		this.menu.setLayout(new GridLayout(2,1));
		this.menu.add(boutonJeux);
		this.menu.add(boutonUtilisateurs);
		
	}
	private void initContenu() {
		this.contenu = new JPanel();
		this.panelJeu = new JPanel();
		this.panelJeux= new JPanel();
		this.utilisateur = new  JPanel();
		this.utilisateurs= new JPanel();
		
		
		this.boutonTemp= new JButton("Jeu");
		this.boutonTemp.addActionListener(this);
		this.panelJeux.add(boutonTemp);
		this.boutonTemp2= new JButton("random user");
		this.boutonTemp2.addActionListener(this);
		this.utilisateurs.add(boutonTemp2);
		
		
		this.contenu.setBounds(290,0,980,800);
		this.card = new CardLayout();
		this.contenu.setLayout(card);
		this.panelJeu.setBackground(Color.pink);
		this.panelJeux.setBackground(Color.red);
		this.utilisateur.setBackground(Color.gray);
		this.utilisateurs.setBackground(Color.LIGHT_GRAY);
		this.card.addLayoutComponent(this.panelJeux,"panelJeux");
		this.card.addLayoutComponent(this.panelJeu,"panelJeu");
		this.card.addLayoutComponent(this.utilisateur,"panelUtilisateur");
		this.card.addLayoutComponent(this.utilisateurs,"panelUtilisateurs");
		this.contenu.add(this.panelJeux);
		this.contenu.add(this.panelJeu);
		this.contenu.add(this.utilisateur);
		this.contenu.add(this.utilisateurs);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.boutonJeux) {
			this.card.show(this.contenu, "panelJeux");
			
		}
		if(e.getSource()==this.boutonUtilisateurs) {
				this.card.show(this.contenu, "panelUtilisateurs");
		}
		if(e.getSource()==this.boutonTemp) {
			this.card.show(this.contenu, "panelJeu");
			com.morpion.Model.IHMorpion.AppelJeux();
		}
		if(e.getSource()==this.boutonTemp2) {
			this.card.show(this.contenu, "panelUtilisateur");
		}
		
	}
}
