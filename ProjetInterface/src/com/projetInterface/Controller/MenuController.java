package com.projetInterface.Controller;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class MenuController {
	public static void clicJeux(CardLayout c,JPanel conteneur) {
		c.show(conteneur, "panelJeux");
	}
	public static void clicUtilisateurs(CardLayout c, JPanel conteneur) {
		c.show(conteneur,"panelUtilisateurs");
	}
}
