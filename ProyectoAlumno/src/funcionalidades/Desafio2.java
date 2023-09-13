package funcionalidades;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.BasicStroke;
import java.awt.Stroke;



public class Desafio2 extends JPanel{

	private JLabel [] puntosP = new JLabel[2];
	private JLabel [][] balas = new JLabel[2][10];  //CAMBIAR
	private DefaultTimerD2 dtO,dtV;
	private Image img;
	private JLabel nino1, nino2, continuar;
	private JLabel fondoO,fondoV,hit,miss;
	private Boolean opacoHit = false, opacoMiss = false;

    Integer puntajeO = 0, puntajeV = 0;
    int randNumb = 0;
    int squareWidth = 25;
    int squareHeight = 25;
    int squareYLocation = -squareHeight;
    boolean numberCreated = false;

   //Categorias: 1. Frutas || 2. Lacteos || 3.Legumbres || 4. Carnes || 5. Semillas || 6.Procesados 
    
	public Desafio2(int alto, int ancho, ListenerD2 list){

		setLayout(null);
		//System.out.println("Alto: "+alto+" Ancho: "+ancho);
		
		int altoFixDos = (alto - 14) / 2;
		
		int altoBarra = alto / 5;
		
		int heightBtn = altoBarra/2;
				
		int anchoImg = (ancho-14)/6;
		int altoImg = alto/6;
		
		//  Border lineaBorde = BorderFactory.createLineBorder(Color.gray);
		//	BasicStroke strokePersonalizado = new BasicStroke(3.0f);
		//	Border lineaBorde3 = BorderFactory.createStrokeBorder(strokePersonalizado, Color.BLACK);
		
		//Agregar Botones "Comenzar" para ambos jugadores
			
		continuar = new JLabel("", SwingConstants.CENTER);
		continuar.setOpaque(false);
		continuar.setBackground(new Color(0,0,0,0));
		continuar.setForeground(Color.white);
		continuar.setBounds(ancho/2-(ancho/6/2)-7, alto-100, ancho/6, heightBtn/2);
		add(continuar);	
		
		hit = new JLabel();
		hit.setBounds(-300,-300, anchoImg, altoImg);
		Icon hit1 = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/hitSymbol.png")).getImage()
				.getScaledInstance(hit.getWidth(), hit.getHeight(), 0));
		hit.setOpaque(false);
		hit.setIcon(hit1);
		hit.setBackground(new Color(0,0,0,0));
		add(hit);
		
		miss = new JLabel();
		miss.setBounds(-300,-300, anchoImg, altoImg);
		Icon miss1 = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/missSymbol.png")).getImage()
				.getScaledInstance(miss.getWidth(), miss.getHeight(), 0));
		miss.setOpaque(false);
		miss.setIcon(miss1);
		miss.setBackground(new Color(0,0,0,0));
		add(miss);
		

		
		//CAÑON 1
	    nino1 = new JLabel();
		nino1.setOpaque(false);
	    //imagen1.setBackground(Color.black);
		nino1.setBounds(0, altoFixDos, anchoImg, altoImg);
		add(nino1);
		
		//CAÑON 2
		nino2 = new JLabel();
		nino2.setOpaque(false);
		//imagen2.setBackground(Color.blue);
		nino2.setBounds(1024-anchoImg, altoFixDos, anchoImg, altoImg);
		add(nino2);
		
		for (int i=0; i<10; i++) {  			//CAMBIAR
			balas[0][i] = new JLabel();
			balas[1][i] = new JLabel();
			balas[0][i].setBounds(-300, -300, anchoImg/2, altoImg/2);
			add(balas[0][i]);
			balas[1][i].setBounds(-300, -300, anchoImg/2, altoImg/2);
			add(balas[1][i]);
		}
		
		dtO = new DefaultTimerD2(list,new Color(159, 0, 255),0);
		dtO.setOpaque(true);
		dtO.setBackground(Color.black);
		dtO.setBounds(1024/2 - 28, 10, ancho/6+52, heightBtn/2);
		//dtO.stop();
		add(dtO);
		
		dtV = new DefaultTimerD2(list, Color.orange,763);  //Color Violeta
		dtV.setOpaque(true);
		dtV.setBackground(Color.black);
		dtV.setBounds(1024/2-28, 680, ancho/6+52, heightBtn/2);
		dtV.stop();
		add(dtV);

		fondoO = new JLabel("", SwingConstants.CENTER);
		fondoO.setBackground(new Color(255,175,65, 100));
		fondoO.setForeground(Color.white);
		fondoO.setBounds(0-14 + 63, 0, 240, alto); //240 + 63 = 303
		fondoO.setOpaque(true);
		add(fondoO);	
		
		fondoV = new JLabel("", SwingConstants.CENTER);
		fondoV.setBackground(new Color(205, 115, 255, 100));
		fondoV.setForeground(Color.white);
		fondoV.setBounds(1024 - 303, 0, 240, alto); //303
		fondoV.setOpaque(true);
		add(fondoV);
	}
	
	public void paint(Graphics g) {
		
		img = new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/fondoDesafio2.png")).getImage();
		
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		
		setOpaque(false);
		
		setBackground(new Color(0,0,0,0));
		
		super.paint(g);
			
	}
	
	public int getSeconds(ListenerD2 list) {
		if (list.getContadoresFin() == 0)
			return dtO.getSeconds();
		return dtV.getSeconds();
	}
	
	public void arrancarTimer() {
		
		dtV.start();
	}
	
/*	public void pintarBorde(JLabel bordesAmmo,int cant, ListenerD2 list) {
		int anchoFix = (1024 - 14);
		int altoBtn = 768/10-11;
		int anchoBtn = 1024/32;
		BasicStroke strokePersonalizado = new BasicStroke(3.0f);
		Border lineaBorde3 = BorderFactory.createStrokeBorder(strokePersonalizado, Color.BLACK);
		
		
		if (list.getContadoresFin() == 0)
			bordesAmmo.setBounds((cant/3)*anchoBtn*3, altoBtn - 110, anchoBtn*3, altoBtn);
		else 
			bordesAmmo.setBounds((anchoFix-anchoBtn*3)-(cant/3)*anchoBtn*3, altoBtn - 110, anchoBtn*3, altoBtn);
		bordesAmmo.setOpaque(false);
	}*/
	
	public void ubicarBala(String path, float coordY,int alto, int ancho) {
		
	}
	
	public JLabel getHit() {
		return hit;
	}
	
	public JLabel getMiss() {
		return miss;
	}
	
	public void drawHit(int x, int y) {
		
		int anchoImg = (1024-14)/6;
		int altoImg = 768/6;
	
		hit.setBounds(x,y, anchoImg, altoImg);
		hit.setOpaque(true);
		opacoHit = true;
	}
	
	public void drawMiss(int x, int y) {
		
		int anchoImg = (1024-14)/6;
		int altoImg = 768/6;
	
		miss.setBounds(x,y, anchoImg, altoImg);
		miss.setOpaque(true);
		opacoMiss = true;
	}
	
	public void transparentarHit(JLabel j) {
		
		int anchoImg = (1024-14)/6;
		int altoImg = 768/6;
		
		if (opacoHit == true) {
			hit.setOpaque(false);
			hit.setBounds(-300,-300, anchoImg, altoImg);
			opacoHit = false;
		}
	}
	
	public void transparentarMiss(JLabel j) {
		
		int anchoImg = (1024-14)/6;
		int altoImg = 768/6;
		
		if (opacoMiss == true) { 
			miss.setOpaque(false);
			miss.setBounds(-300,-300, anchoImg, altoImg);
			opacoMiss = false;
		}
	}
	
	public void reubicarImgO(String path, float coordY,int alto, int ancho) {
		
		int altoImg = alto/6;
		int anchoImg = (ancho-14)/6;
		int posY = (int)(coordY * alto) - 100;
		
		nino1.setBounds(0, posY, anchoImg, altoImg);
		
		
		paintImgO(path);
		
	}
	
	public void reubicarImgV(String path, float coordY,int alto, int ancho) {
		
		int altoImg = alto/6;
		int anchoImg = (ancho-14)/6;
		int posY = (int)(coordY * alto) - 100;
		
		nino2.setBounds(1024-anchoImg, posY, anchoImg, altoImg);
		
		paintImgV(path);
		
	}
	
	public void paintImgO(String path) {
		
		Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
				.getScaledInstance(nino1.getWidth()-14, nino1.getHeight()-14, 1));
		
		nino1.setIcon(img);
	}
	
	//        Height 128  |||  Width 168
	
	public void paintImgV(String path) {
		
		Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
				.getScaledInstance(nino2.getWidth()-14, nino2.getHeight()-14, 1));
		
		nino2.setIcon(img);
	}
	
	public void paintProd(int m, int n, String path) {
		
		Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
						.getScaledInstance(balas[m][n].getWidth(), balas[m][n].getHeight(), 0));
				
		balas[m][n].setIcon(img);		
	}
	
	public JLabel getPjO() {
		return nino1;
	}
	
	public JLabel getPjV() {
		return nino2;
	}
	
	public int getSecondsO() {
		return dtO.getSeconds();
	}
	
	public int getSecondsV() {
		return dtV.getSeconds();
	}
	
	public JLabel getBalaO(int j) {
		return balas[0][j];
	}
	
	public JLabel getBalaV(int j) {
		return balas[1][j];
	}
	
	public int TotalTimeO() {

		return dtO.getTotalTime();
	}
	
	public int getTotalTimerO() {
		return this.dtO.getTotalTime();
	}
	
	/*public JLabel getPEquipoO() {
		return progreso[0];
	}

	
	public JLabel getPEquipoV() {
		return progreso[1];
	}*/
    
	
	public void continuar() {
		continuar.setText("Continuar");
		continuar.setOpaque(true);
		continuar.setBackground(Color.black);
	}
	public void termine() {
		//Detengo el timer
		dtO.stop();
	}
}