package com.projetInterface.View;
import javax.swing.JButton;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Box extends JButton implements ActionListener{

	
	public Box(String s) {
		super(s);
		this.setPreferredSize(new Dimension(239,319));
		this.setBackground(Color.DARK_GRAY);
		this.setForeground(Color.WHITE);
		this.addActionListener(this);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.getBackground()==Color.DARK_GRAY) {
			this.setBackground(Color.GRAY);
		}
		else {
			this.setBackground(Color.DARK_GRAY);
		}
	}

}
