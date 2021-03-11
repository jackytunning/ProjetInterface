package com.projetInterface.Controller;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.projetInterface.View.Navigation;
import com.projetInterface.View.PageInfo;

public class NavigationController {
	public static void clicJeux(CardLayout c, Navigation n) {
		c.show(n, "panelJeu");
	}
	public static void clicInfoJeu(CardLayout c, Navigation  n) {
		n.panelInfoJeu.add(n.panelInfoJeu.retour);
		c.show(n, "panelInfoJeu");
	}
	
	public static void clicUtilisateur(CardLayout c, Navigation  n) {
		c.show(n, "panelUtilisateur");
	}
	public static void clicLancer(CardLayout c, Navigation  n) {
		n.panelLancerPartie.add(n.panelInfoJeu.retour);
		c.show(n, "panelLancerPartie");
	}
	public static void clicRetour(CardLayout c, Navigation  n) {
		c.show(n, "panelJeu");
	}
	public static void nonImplemente(CardLayout c,Navigation n) {
		n.panelNI.add(n.panelInfoJeu.retour);
		c.show(n,"nonImp");
	}
}
