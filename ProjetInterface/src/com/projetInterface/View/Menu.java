package com.projetInterface.View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.projetInterface.Controller.MenuController;

public class Menu extends JPanel implements ActionListener,I_View{
	private JButton boutonJeux;
	private JButton boutonUtilisateurs;
	private View v;
	//private CardLayout cardMenu;
	
	Menu(View p){
		super();
		this.v = p;
		this.init();
	}
	private void init() {
		this.boutonJeux= new JButton("Jeux");
		this.boutonJeux.addActionListener(this);
		this.boutonUtilisateurs= new JButton("Utilisateurs");
		this.boutonUtilisateurs.addActionListener(this);
		this.setBounds(0,0,290,800);
		this.setBackground(Color.yellow);
		this.setLayout(new GridLayout(2,1));
		this.add(boutonJeux);
		this.add(boutonUtilisateurs);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.boutonJeux) {
			MenuController.clicJeux(this.v.nav.card,this.v.nav);  //voir pour recup le card du contenu
		}
		if(e.getSource()==this.boutonUtilisateurs) {
			MenuController.clicUtilisateurs(this.v.nav.card,this.v.nav);
		
		}
	}
}
