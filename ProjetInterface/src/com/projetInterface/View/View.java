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
		private CardLayout card;
		private JPanel panelJeux;
			private Box[] boxJeux;
			//ajouter les jeux
		private JPanel panelJeu;
			private JLabel labelJeu;
			private JButton lancer;
			private JButton bInfoJeu;
		private PageInfo panelInfoJeu;
		private JPanel panelLancerPartie;
			private JButton bCharger;
			private JButton bNvPartie;
			
		private JPanel utilisateurs;
			//liste des utilisateurs
			//tableau?qui contient les utilisateurs(affichage)
			private JLabel labelUtilisateurs;
		private JPanel utilisateur;
			private JLabel labelUtilisateur;
			//infos de l'utilsateur
	
		
	//conteneur general
	private JPanel panel;
	
	private JButton boutonTemp2;
	
	private JButton boutonEx[] = new JButton[10];
	private int i=0;
	
	
	
	
	
	
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
			this.setAlwaysOnTop(true);
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
	private void initPanelJeux() {
		this.panelJeux= new JPanel();
		int i;
		Box boite[];
		this.boxJeux = new Box[6];
		for(i=0;i<6;i++) {
			this.boxJeux[i]= new Box(String.valueOf(i));
			this.boxJeux[i].addActionListener(this);
			this.panelJeux.add(this.boxJeux[i]);
			
		}
		this.panelJeux.setLayout(new GridLayout(2,3));
	}
	
	private void initPanelJeu() {
		this.panelJeu = new JPanel();
		this.labelJeu = new JLabel("Jeu");
		this.panelJeu.add(labelJeu);
		this.lancer= new JButton("Lancer une partie");
		this.lancer.addActionListener(this);
		this.panelJeu.add(this.lancer);
		this.bInfoJeu= new JButton("Voir les infos du jeu");
		this.bInfoJeu.addActionListener(this);
		this.panelJeu.add(this.bInfoJeu );
	}
	
	private void initPanelInfoJeu() {
		this.panelInfoJeu= new PageInfo("jeu",this);
		
	}
	private void initLancerPartie() {
		this.panelLancerPartie = new JPanel();
		this.panelLancerPartie.setLayout(new BoxLayout(this.panelLancerPartie,BoxLayout.Y_AXIS));
		this.bCharger = new JButton("Charger une partie");
		this.bNvPartie = new JButton("Lancer une nouvelle partie");
		this.panelLancerPartie.add(this.bNvPartie);
		this.panelLancerPartie.add(this.bCharger);
		this.panelLancerPartie.add(this.panelInfoJeu.retour);
	}
	
	private void initPanelUtilisateurs() {
		this.utilisateurs= new JPanel();
		this.utilisateurs.setLayout(new GridLayout(2,3));
		this.boutonTemp2= new JButton("random user");
		JButton boutonTemp3 = new JButton("nouvel user");
		this.boutonTemp2.addActionListener(this);
		this.labelUtilisateurs = new JLabel("Utilisateurs");
		this.utilisateurs.add(labelUtilisateurs);
		this.utilisateurs.add(boutonTemp3);
		this.utilisateurs.add(boutonTemp2);
	}
	
	private void initPanelUtilisateur() {
		this.utilisateur = new  JPanel();
		this.labelUtilisateur = new JLabel("Utilisateur");
		this.utilisateur.add(labelUtilisateur);		
	}
	
	//initialise toutes les pages
	private void initContenu() {
		this.contenu = new JPanel();
		this.initPanelUtilisateurs();
		this.initPanelJeu();
		this.initPanelJeux();
		this.initPanelUtilisateur();
		this.initPanelInfoJeu();
		this.initLancerPartie();
		this.contenu.setBounds(290,0,980,800);
		this.card = new CardLayout();
		this.contenu.setLayout(card);
		this.card.addLayoutComponent(this.panelJeux,"panelJeux");
		this.card.addLayoutComponent(this.panelJeu,"panelJeu");
		this.card.addLayoutComponent(this.utilisateur,"panelUtilisateur");
		this.card.addLayoutComponent(this.utilisateurs,"panelUtilisateurs");
		this.card.addLayoutComponent(this.panelInfoJeu, "panelInfoJeu");
		this.card.addLayoutComponent(this.panelLancerPartie,"panelLancerPartie");
		this.contenu.add(this.panelJeux);
		this.contenu.add(this.panelJeu);
		this.contenu.add(this.panelInfoJeu);
		this.contenu.add(this.utilisateur);
		this.contenu.add(this.utilisateurs);
		this.contenu.add(this.panelLancerPartie);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.boutonJeux) {
			this.card.show(this.contenu, "panelJeux");
		}
		if(e.getSource()==this.boutonUtilisateurs) {
				this.card.show(this.contenu, "panelUtilisateurs");
		}
		if(e.getSource()==this.boxJeux[0]) {
			this.card.show(this.contenu, "panelJeu");
		}
		if(e.getSource()==this.bInfoJeu) {
			this.panelInfoJeu.add(this.panelInfoJeu.retour);
			this.card.show(this.contenu, "panelInfoJeu");
		}
		if(e.getSource()==this.boutonTemp2) {
			this.card.show(this.contenu, "panelUtilisateur");
		}
		if(e.getSource()==this.lancer) {
			this.panelLancerPartie.add(this.panelInfoJeu.retour);
			this.card.show(this.contenu, "panelLancerPartie");
		}
		if(e.getSource()==this.panelInfoJeu.retour) {
			this.card.show(this.contenu, "panelJeu");
		}
		
		
	}
}
