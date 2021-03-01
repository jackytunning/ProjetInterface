package com.morpion.Controller;
import java.util.*;
import java.io.*;

public class ConsoleMorpion 
{
	private int    forme; //croix si 1 / rond si 2
	
	private String joueur1;
	private String joueur2;
	private String joueurAct;
	
	private boolean gagne = false;
	
	private String[][] tabPuiss;

	public ConsoleMorpion(String joueur1, String joueur2, int n)
	{
		tabPuiss = new String[3][3];
	
		this.joueurAct = this.joueur1 = joueur1;
		this.joueur2   = joueur2;
		this.forme = n;
		
		this.init();
	}

	public void init()
	{
		for(int i=0;i<this.tabPuiss.length;i++)
			for(int j=0;j<this.tabPuiss[0].length;j++)
				tabPuiss[i][j] = "0";
      
      this.gagne = false;
	}
	
	public void placeForme(int posX, int posY)
	{
		if(tabPuiss[posX][posY].equals("0"))
		{
			tabPuiss[posX][posY] = Integer.toString(this.forme); 
			this.gagne = this.gagne();
			if(this.gagne!=true) this.changeJoueur();
		}
	}
	
	public void changeJoueur()
	{
		if(forme==1) 
		{
			this.joueurAct = joueur2; 
			forme = 2;
		}
		else 
		{
			this.joueurAct = joueur1; 
			forme = 1;
		}
	}
	
	public boolean gagne()
	{
		int i, j;
		i = j = 0;
	
		//test horizontal
		for(i=0;i<this.tabPuiss.length;i++)
		{
			if(tabPuiss[i][j].equals("1") && tabPuiss[i][j+1].equals("1") && tabPuiss[i][j+2].equals("1")) return true;
			if(tabPuiss[i][j].equals("2") && tabPuiss[i][j+1].equals("2") && tabPuiss[i][j+2].equals("2")) return true;
		}
		
		i = j = 0;
		//test vertical
		for(j=0;j<this.tabPuiss[0].length;j++)
		{
			if(tabPuiss[i][j].equals("1") && tabPuiss[i+1][j].equals("1") && tabPuiss[i+2][j].equals("1") ) return true;
			if(tabPuiss[i][j].equals("2") && tabPuiss[i+1][j].equals("2") && tabPuiss[i+2][j].equals("2") ) return true;
		}
		
		i = j = 0;
		//test diagonal droite haut/bas
		if(tabPuiss[i][j].equals("1") && tabPuiss[i+1][j+1].equals("1") && tabPuiss[i+2][j+2].equals("1") ) return true;
		if(tabPuiss[i][j].equals("2") && tabPuiss[i+1][j+1].equals("2") && tabPuiss[i+2][j+2].equals("2") ) return true;
	
		i = 0;
		j = 2;
		//test diagonal gauche 
		if(tabPuiss[i][j].equals("1") && tabPuiss[i+1][j-1].equals("1") && tabPuiss[i+2][j-2].equals("1") ) return true;
		if(tabPuiss[i][j].equals("2") && tabPuiss[i+1][j-1].equals("2") && tabPuiss[i+2][j-2].equals("2") ) return true;
		
		
		return false;
	}
	
	public boolean remplie()
	{
		int nb=0;
		
		for(int i=0;i<this.tabPuiss.length;i++)
			for(int j=0;j<this.tabPuiss[0].length;j++)
				if(!tabPuiss[i][j].equals("0")) nb++;
	
		if(nb==(3*3)) return true;
		return false;
	}
	
	public boolean getGagne()
	{
		return this.gagne;
	}
	
	public String getTab(int i, int j)
	{
		return tabPuiss[i][j];
	}
	
	public String getJoueurAct()
	{
		return this.joueurAct;
	}
	
	public String getforme()
	{
		if(this.forme==1) return "croix";
		
		return "rond";
	}
	
	public void setforme(int n)
	{
		this.forme = n;
	}
	
	public void setJoueurAct(String str)
	{
		this.joueurAct = str;
	}
	
	public void setJoueur1(String str)
	{
		this.joueur1 = str;
		if(this.forme==1) this.setJoueurAct(str);
	}
   
	public void setJoueur2(String str)
	{
		this.joueur2 = str;
		if(this.forme==2) this.setJoueurAct(str);
	}
   
	public String toString()
	{
		String str = this.joueurAct + " | " + (this.forme==1?"croix":"rond") + "\n\n";
		
		for(int i=0;i<this.tabPuiss.length;i++)
		{	
			str += "\n" + " | ";
		
			for(int j=0;j<this.tabPuiss[0].length;j++)
			{
				if(!tabPuiss[i][j].equals("0"))
					str += tabPuiss[i][j] + " | ";
				else
					str += " " + " | ";
			}
		}
		
		str += "\n";
	
		return str;
	}
	
	public static void AppelJeux() 
	{
		int posX = 0;
		int posY = 0;
		
		ConsoleMorpion ConMorp4 = new ConsoleMorpion("Joueur 1", "Joueur 2", 1);
		System.out.println(ConMorp4);
		
		Scanner sc = new Scanner(System.in);
		
		while(!ConMorp4.getGagne())
		{
			System.out.print("donne posX :");
			posX = sc.nextInt();
			System.out.print("donne posY :");
			posY = sc.nextInt();
			
			ConMorp4.placeForme(posX,posY);
			System.out.println(ConMorp4);
		}
	}
	
	

}