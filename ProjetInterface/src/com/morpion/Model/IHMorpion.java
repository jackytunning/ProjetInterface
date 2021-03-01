package com.morpion.Model;
import java.awt.*;
import java.awt.event.*;

import com.morpion.Controller.ConsoleMorpion;
import com.morpion.View.Visu;

public class IHMorpion extends Frame implements ActionListener
{
	private ConsoleMorpion ConMorp;
	private Visu		   visu;
	
	private TextField joueur1;
	private TextField joueur2;

	private Label  l;
	private Button b;
	
	private boolean un = false;
   
	public IHMorpion()
	{
		setTitle("Morpion");
		setSize(450,450);
	
		this.ConMorp = new ConsoleMorpion("Joueur 1", "Joueur 2", 1);
		
		joueur1 = new TextField("Joueur 1");
		joueur2 = new TextField("Joueur 2");
		
		Panel p2 = new Panel(new GridLayout(1,2));
		Panel p3 = new Panel(new GridLayout(1,2));
		b = new Button("New game");
		b.addActionListener(this);
		p2.add(b);
		l = new Label(ConMorp.getJoueurAct() + " / " + ConMorp.getforme());
		p2.add(l);
		
		add(p2, BorderLayout.SOUTH);
	
		visu = new Visu(this, ConMorp);
		add(visu);
	
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				System.exit(0);
			}
		} );
	
		setVisible(true); 
	}
	
	public void setLabel(String str)
	{
		l.setText(str);
	}
	
	public void setUn()
	{
		this.un = true;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == joueur1 )
		{
			ConMorp.setJoueur1(joueur1.getText());
			this.setLabel(ConMorp.getJoueurAct() + " / " + ConMorp.getforme());
		}
		else if(e.getSource() == joueur2 )
		{
			ConMorp.setJoueur2(joueur2.getText());
			this.setLabel(ConMorp.getJoueurAct() + " / " + ConMorp.getforme());
		}
		else 
		{
			Button b1 = (Button)e.getSource();
			
			if(b1.getLabel().equals("New game"))
			{
				ConMorp.init();
				ConMorp.setforme(1);
				ConMorp.setJoueurAct(joueur1.getText());
				this.setLabel(ConMorp.getJoueurAct() + " / " + ConMorp.getforme());
				this.un = false;
			}
         
			if(!this.un)
			{
				if(b1.getLabel().equals("1 joueur"))
				{
					ConMorp.setJoueur2(joueur2.getText());
					this.setLabel(ConMorp.getJoueurAct() + " / " + ConMorp.getforme());
				}
			}
		}
	}
	
	public static void AppelJeux() 
	{
		new IHMorpion();
	}
}