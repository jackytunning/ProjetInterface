package com.projetInterface.View;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PageInfo extends JPanel implements I_View {
	private JLabel titre;
	private JLabel nbJoue;
	private JLabel nbTerm;
	private JLabel nbAbd;
	private JLabel hScores;
	public JButton retour;
	
	protected PageInfo(String s,ActionListener a) {
		super();
			this.titre = new JLabel(s);
			this.retour = new JButton("retour");
			this.retour.addActionListener(a);
			
		this.init();
		
	}
	protected void init() {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.nbJoue = new JLabel("0 joue");
		this.nbTerm = new JLabel("0 termine");
		this.nbAbd = new JLabel("0 abandonées");
		this.hScores = new JLabel("0 pts");
		this.add(this.nbJoue);
		this.add(this.nbTerm);
		this.add(this.nbAbd);
		this.add(this.hScores);
		
		
		this.add(this.retour);
	}
}
