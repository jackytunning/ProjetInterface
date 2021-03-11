package com.projetInterface.View;


import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.projetInterface.Controller.NavigationController;

import java.awt.event.*;

public class Navigation extends JPanel implements I_View,ActionListener{
	
	
	public CardLayout card;
	private JPanel panelJeux;
		private Box[] boxJeux;
		//ajouter les jeux
	private JPanel panelJeu;
		private JLabel labelJeu;
		private JButton lancer;
		private JButton bInfoJeu;
	public PageInfo panelInfoJeu;
	public JPanel panelLancerPartie;
		private JButton bCharger;
		private JButton bNvPartie;
		
	private JPanel utilisateurs;
		//liste des utilisateurs
		//tableau?qui contient les utilisateurs(affichage)
		private JLabel labelUtilisateurs;
	private PageInfo utilisateur;
		private JLabel labelUtilisateur;
		//infos de l'utilsateur
		
		
	private JButton boutonTemp2,boutonTemp3;
	public JPanel panelNI;
	
	
	
	
	
		
		Navigation(){
			super();
			this.init();
		}

		private void initPanelJeux() {
			this.panelJeux = new JPanel();
			int i;
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
			this.bCharger.addActionListener(this);
			this.bNvPartie = new JButton("Lancer une nouvelle partie");
			this.bNvPartie.addActionListener(this);
			this.panelLancerPartie.add(this.bNvPartie);
			this.panelLancerPartie.add(this.bCharger);
			this.panelLancerPartie.add(this.panelInfoJeu.retour);
		}
		
		private void initPanelUtilisateurs() {
			this.utilisateurs= new JPanel();
			this.utilisateurs.setLayout(new GridLayout(2,3));
			
			
			
			this.boutonTemp2= new JButton("random user");
			this.boutonTemp3 = new JButton("nouvel user");		
			this.boutonTemp2.addActionListener(this);
			this.boutonTemp3.addActionListener(this);
			
			
			this.labelUtilisateurs = new JLabel("Utilisateurs");
			this.utilisateurs.add(labelUtilisateurs);
			this.utilisateurs.add(boutonTemp3);
			this.utilisateurs.add(boutonTemp2);
		}
		
		private void initPanelUtilisateur() {
			this.utilisateur = new  PageInfo("Utilisateur",this);	
		}
		
		//initialise toutes les pages
		private void init() {
			this.initPanelUtilisateurs();
			this.initPanelJeu();
			this.initPanelJeux();
			this.initPanelUtilisateur();
			this.initPanelInfoJeu();
			this.initLancerPartie();
			
			
			
			this.setBounds(290,0,980,800);
			this.card = new CardLayout();
			this.setLayout(card);
			this.card.addLayoutComponent(this.panelJeux,"panelJeux");
			this.card.addLayoutComponent(this.panelJeu,"panelJeu");
			this.card.addLayoutComponent(this.utilisateur,"panelUtilisateur");
			this.card.addLayoutComponent(this.utilisateurs,"panelUtilisateurs");
			this.card.addLayoutComponent(this.panelInfoJeu, "panelInfoJeu");
			this.card.addLayoutComponent(this.panelLancerPartie,"panelLancerPartie");
			this.add(this.panelJeux);
			this.add(this.panelJeu);
			this.add(this.panelInfoJeu);
			this.add(this.utilisateur);
			this.add(this.utilisateurs);
			this.add(this.panelLancerPartie);
			
			
			this.panelNI = new JPanel();
			this.panelNI.add(new JLabel("Fonctionalité non implementée"));//a Modifier
			this.card.addLayoutComponent(this.panelNI, "nonImp");
			this.add(this.panelNI);
			
			
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==this.boxJeux[0]) {
				NavigationController.clicJeux(card,this);
			}
			if(e.getSource()==this.bInfoJeu) {
				NavigationController.clicInfoJeu(card,this);
			}
			if(e.getSource()==this.boutonTemp2) {
				NavigationController.clicUtilisateur(card,this);
			}
			if(e.getSource()==this.lancer) {
				NavigationController.clicLancer(card, this);
			}
			if(e.getSource()==this.panelInfoJeu.retour) {
				NavigationController.clicRetour(card, this);
			}
			if(e.getSource()==(this.bCharger)) {
				NavigationController.nonImplemente(card, this);
			}
			if(e.getSource()==(this.bNvPartie)) {
				NavigationController.nonImplemente(card, this);
			}
			if(e.getSource()==(this.boutonTemp3)) {
				NavigationController.nonImplemente(card, this);
			}
			
		}






}
