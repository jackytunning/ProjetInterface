package com.projetInterface.View;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PageInfo extends JPanel {
	private JLabel titre;
	private JLabel nbJoue;
	private JLabel nbTerm;
	private JLabel nbAbd;
	private JLabel hScores;
	protected JButton retour;
	
	protected PageInfo(String s,View v) {
		super();
			this.titre = new JLabel(s);
			this.retour = new JButton("retour");
			this.retour.addActionListener(v);
			
		this.initInfos();
		
	}
	protected void initInfos() {
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
