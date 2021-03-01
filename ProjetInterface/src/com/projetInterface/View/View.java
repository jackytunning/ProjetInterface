package com.projetInterface.View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class View extends JFrame implements ActionListener{
	//conteneur des menus
	private JPanel menus;
	private JPanel menuNav;
		//boutons menu navigation
		private JButton boutonJeux;
		private JButton boutonUtilisateurs;
		
	private JPanel menuJeu;
		//contenu menu en jeu
	
	//conteneur de toutes les pages
	private JPanel contenu;
	
	private JPanel panelJeux;
	private JLabel labelJeux;
		//ajouter les jeux
	private JPanel panelJeu;
	private JLabel labelJeu;
		//contenu info jeu
	//liste des utilisateurs
	private JPanel utilisateurs;
		//tableau?qui contient les utilisateurs(affichage)
		private JLabel labelUtilisateurs;
	private JPanel utilisateur;
		//infos de l'utilsateur
	
	CardLayout card;
	//conteneur general
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
			panel.add(menus);
			panel.add(contenu);
			this.getContentPane().add(panel);
	}
	//initialise les menus (en jeu, navigation et les regroupe dans leur conteneur)
	private void initMenu() {
		this.boutonJeux= new JButton("Jeux");
		this.boutonJeux.addActionListener(this);
		this.boutonUtilisateurs= new JButton("Utilisateurs");
		this.boutonUtilisateurs.addActionListener(this);
		this.menus = new JPanel();
		this.menus.setBounds(0,0,290,800);
		this.menus.setBackground(Color.yellow);
		this.menus.setLayout(new GridLayout(2,1));
		this.menus.add(boutonJeux);
		this.menus.add(boutonUtilisateurs);
		
	}
	//initialise toutes les pages
	private void initContenu() {
		this.contenu = new JPanel();
		this.panelJeu = new JPanel();
		this.panelJeux= new JPanel();
		this.utilisateur = new  JPanel();
		this.utilisateurs= new JPanel();
		
		
		this.boutonTemp= new JButton("Jeu");
		this.boutonTemp.addActionListener(this);
		
		this.boutonTemp2= new JButton("random user");
		this.boutonTemp2.addActionListener(this);
		
		//labels
		this.labelJeux = new JLabel("Jeux");
		this.panelJeux.add(labelJeux);
		this.labelJeu = new JLabel("Jeu");
		this.panelJeu.add(labelJeu);
		this.labelUtilisateurs = new JLabel("Utilisateurs");
		this.utilisateurs.add(labelUtilisateurs);
		this.labelUtilisateur = new JLabel("Utilisateur");
		this.utilisateur.add(labelUtilisateur);
		
		this.panelJeux.add(boutonTemp);
		this.utilisateurs.add(boutonTemp2);
		
		
		this.contenu.setBounds(290,0,980,800);
		this.card = new CardLayout();
		this.contenu.setLayout(card);
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
		}
		if(e.getSource()==this.boutonTemp2) {
			this.card.show(this.contenu, "panelUtilisateur");
		}
		
	}
}
