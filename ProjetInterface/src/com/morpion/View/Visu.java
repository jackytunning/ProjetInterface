package com.morpion.View;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.morpion.Controller.ConsoleMorpion;
import com.morpion.Model.IHMorpion;

public class Visu extends Panel implements MouseListener
{
	private ConsoleMorpion ConMorp;
	private IHMorpion      ihm;

	private Image blanc;
	private Image croix;
	private Image rond;
	
	public Visu(IHMorpion ihm, ConsoleMorpion ConMorp)
	{
		this.ihm      = ihm;
		this.ConMorp = ConMorp;
		
		addMouseListener(this);
	}

	public void initImage()
	{
		//blanc = Toolkit.getDefaultToolkit().getImage("images/vide.gif");
		//rond  = Toolkit.getDefaultToolkit().getImage("images/rond.gif");
		//croix = Toolkit.getDefaultToolkit().getImage("images/croix.gif");
		/*try {
			blanc = ImageIO.read(new File("images/vide.png"));
			rond  = ImageIO.read(new File("images/rond.png"));
			croix = ImageIO.read(new File("images/croix.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		try {
			blanc = ImageIO.read(getClass().getResource("vide.png"));
			rond  = ImageIO.read(getClass().getResource("rond.png"));
			croix = ImageIO.read(getClass().getResource("croix.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g) 
	{
		int posX = 0;
 		int posY = 0;
	
		for(int i=0;i<3;i++)
		{
			posX = 0;
		
			for(int j=0;j<3;j++)
			{
				this.initImage();
				
				if(ConMorp.getTab(i,j).equals("1"))
				{
					g.drawImage(croix, posX, posY, this.getWidth()/3, this.getHeight()/3, null);
				}
				else if(ConMorp.getTab(i,j).equals("2"))
				{
					g.drawImage(rond, posX, posY, this.getWidth()/3, this.getHeight()/3, null);
				}
				else
					g.drawImage(blanc, posX, posY, this.getWidth()/3, this.getHeight()/3, null);
				
				posX += getWidth()/3;
			}
			posY += getHeight()/3;
		}
		
		repaint();
	}
	
	public void getTabStock(int x, int y)
	{
		int posX = 0;
 		int posY = 0;
		
		for(int i=0;i<3;i++)
		{
			posX = 0;
		
			for(int j=0;j<3;j++)
			{
				if(posX<=x && posY<=y && (posX + getWidth()/3)>=x && (posY + getHeight()/3)>=y)
				{
					ConMorp.placeForme(i,j);
				}
				posX += getWidth()/3;
			}
			posY += getHeight()/3;
		}
	}
	
	public void update(Graphics g)
    {
        Graphics offgc;
        Image offscreen = null;
        Dimension d = getSize();

        offscreen = createImage(d.width, d.height);
        offgc = offscreen.getGraphics();
        offgc.setColor(getBackground());
        offgc.fillRect(0, 0, d.width, d.height);
        offgc.setColor(getForeground());
        paint(offgc);
        g.drawImage(offscreen, 0, 0, this);
    }
	
	public void mouseClicked(MouseEvent e)  
	{
		if(!ConMorp.getGagne())
		{
			this.getTabStock(e.getX(), e.getY());
			repaint();
			ihm.setLabel(ConMorp.getJoueurAct() + " / " + ConMorp.getforme());
			
			if(ConMorp.getGagne()) ihm.setLabel("Bravo, " + ConMorp.getJoueurAct() + " a gagne"); 
			ihm.setUn();
		}
		
		if(ConMorp.remplie()) {
			ihm.setLabel("Match nul, recommencez !");
			if(ConMorp.getGagne()) ihm.setLabel("Bravo, " + ConMorp.getJoueurAct() + " a gagne"); 
		}
	}
	
	public void mouseEntered(MouseEvent e)  {}
	public void mousePressed(MouseEvent e)  {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e)   {}
	
}