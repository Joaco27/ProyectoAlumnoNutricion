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
	private JLabel [][] carteles = new JLabel [2][6];
	private RotatedLabel [][] balas = new RotatedLabel[2][10];  //CAMBIAR
	private DefaultTimerD2 dtO,dtV;
	private Image img;
	private JLabel nino1, nino2, cargaCO, cargaCV, continuar;
	private JLabel rachaFondoV,rachaFondoO,fondoO,fondoV,hit,miss;
	private RotatedLabel numRachaV, numRachaO;
	private Boolean opacoHit = false, opacoMiss = false, catDrawV = false, catDrawO = false;
	private int catV,catO;

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
		
		//CARGAS DE CAÑON
		cargaCV = new JLabel();
		cargaCV.setOpaque(false);
		cargaCV.setBounds(1024-anchoImg, altoFixDos, anchoImg, altoImg);
		add(cargaCV);
		
		cargaCO = new JLabel();
		cargaCO.setOpaque(false);
		cargaCO.setBounds(1024-anchoImg, altoFixDos, anchoImg, altoImg);
		add(cargaCO);
		
		for (int i=0; i<10; i++) {  			//CAMBIAR
			balas[0][i] = new RotatedLabel(-300, -300, anchoImg/2, altoImg/2, 0);
			balas[1][i] = new RotatedLabel(-300, -300, anchoImg/2, altoImg/2, 0);
			balas[0][i].setRotation(270.0f); // Rotar a 270 grados  
			balas[1][i].setRotation(90.0f); // Rotar a 90 grados  
			add(balas[0][i]);
			add(balas[1][i]);
		}
		
		for (int i=0; i<6; i++) {
			carteles[0][i] = new JLabel();
			carteles[1][i] = new JLabel(); 
			carteles[0][i].setBounds(-3000, -3000, 720/5, 1165/5);
			add(carteles[0][i]);
			carteles[0][i].setOpaque(false);
			carteles[1][i].setBounds(-3000, -3000, 720/5, 1165/5);
			add(carteles[1][i]);
			carteles[1][i].setOpaque(false);
		}
		
        catO = (int) (Math.random() * 6)+1;
        catV = (int) (Math.random() * 6)+1;
		
		dtO = new DefaultTimerD2(list,Color.orange,0,catV-1);
		//dtO.stop();
		add(dtO);
		
		dtV = new DefaultTimerD2(list,new Color(159, 0, 255),763,catO-1);  //Color Violeta
		dtV.stop();
		add(dtV);		
		
        numRachaO = new RotatedLabel("0",0,17,384/4,512/4,(float)0.7);
        numRachaO.setRotation(90.0f); // Rotar a 90 grados        
        add(numRachaO);
        
        numRachaV = new RotatedLabel("0",(ancho-60) - 52,(alto-52)-(512/4),384/4,512/4,(float)0.7);
        numRachaV.setRotation(270.0f); // Rotar a 270 grados
        add(numRachaV);
		
		rachaFondoO = new JLabel();
		rachaFondoO.setBounds(0,5,384/4,512/4);
		Icon rachaFO = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/RachaNaranja.png")).getImage()
				.getScaledInstance(rachaFondoO.getWidth(), rachaFondoO.getHeight(), 0));
		rachaFondoO.setIcon(rachaFO);
		add(rachaFondoO);
		
		rachaFondoV = new JLabel();
		rachaFondoV.setBounds((ancho-17)-(384/4),(alto-40)-(512/4),384/4,512/4);
		Icon rachaFV = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/RachaVioleta.png")).getImage()
				.getScaledInstance(rachaFondoV.getWidth(), rachaFondoV.getHeight(), 0));
		rachaFondoV.setIcon(rachaFV);
		add(rachaFondoV);

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
	
	public void ubicarBala(String path, float coordY,int alto, int ancho) {
		
	}
	
	public JLabel getHit() {
		return hit;
	}
	
	public JLabel getMiss() {
		return miss;
	}
	
	public JLabel getCartel(int m, int n) {
		return carteles[m][n];
	}
	
	public void drawHit(int x, int y) {
		
		int anchoImg = (1024-14)/6;
		int altoImg = 768/6;
	
		hit.setBounds(x,y-108, anchoImg, altoImg);
		hit.setOpaque(true);
		opacoHit = true;
	}
	
	public void drawMiss(int x, int y) {
		
		int anchoImg = (1024-14)/6;
		int altoImg = 768/6;
	
		miss.setBounds(x,y-108, anchoImg, altoImg);
		miss.setOpaque(true);
		opacoMiss = true;
	}
	
	public void drawCatV(int n) {
		
		carteles[1][n].setBounds(((1024-14)/2+100)-720/10, ((768)/2)-1165/10-20, 720/5, 1165/5);
		carteles[1][n].setOpaque(true);
		catDrawV = true;  
	}
	
	public void drawCatO(int n) {
		
		carteles[0][n].setBounds(((1024-14)/2-100)-720/10, ((768)/2)-1165/10-20, 720/5, 1165/5);
		carteles[0][n].setOpaque(true);
		catDrawO = true;  
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
	
	public void transparentarCartelV(int n) {
		
		int anchoImg = (1024-14)/5;
		int altoImg = 768/5;
		
		if (catDrawV == true) { 
			carteles[1][n].setOpaque(false);
			carteles[1][n].setBounds(-300,-300, altoImg, anchoImg);
			catDrawV = false;
		}
	}
	public void transparentarCartelO(int n) {
		
		int anchoImg = (1024-14)/5;
		int altoImg = 768/5;
		
		if (catDrawO == true) { 
			carteles[0][n].setOpaque(false);
			carteles[0][n].setBounds(-300,-300, altoImg, anchoImg);
			catDrawO = false;
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
	
	public void reubicarCargaO(String path, float coordY,int alto, int ancho) {
		
		int altoCarga = alto/6;
		int anchoCarga = (ancho-14)/6;
		int posY = (int)(coordY * alto) - 100;
		
		nino1.setBounds(0, posY, anchoCarga, altoCarga);
		
		
		paintCargaO(path);
		
	}
	
	public void reubicarCargaV(String path, float coordY,int alto, int ancho) {
		
		int altoCarga = alto/6;
		int anchoCarga = (ancho-14)/6;
		int posY = (int)(coordY * alto) - 100;
		
		nino2.setBounds(1024-anchoCarga, posY, anchoCarga, altoCarga);
		
		paintCargaV(path);
		
	}
	
	public void paintImgO(String path) {
		
		Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
				.getScaledInstance(cargaCO.getWidth()-14, cargaCO.getHeight()-14, 1));
		
		nino1.setIcon(img);
	}
	
	//        Height 128  |||  Width 168
	
	public void paintImgV(String path) {
		
		Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
				.getScaledInstance(cargaCV.getWidth()-14, cargaCV.getHeight()-14, 1));
		
		nino2.setIcon(img);
	}
	
	public void paintCargaO(String path) {
		
		Icon Carga = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
				.getScaledInstance(nino1.getWidth()-14, nino1.getHeight()-14, 1));
		
		nino1.setIcon(Carga);
	}
	
	//        Height 128  |||  Width 168
	
	public void paintCargaV(String path) {
		
		Icon Carga = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
				.getScaledInstance(nino2.getWidth()-14, nino2.getHeight()-14, 1));
		
		nino2.setIcon(Carga);
	}
	
	public void updateRachaO(int n) {
        numRachaO.setStrike(n);
	}
	
	public void updateRachaV(int n) {
		numRachaV.setStrike(n);
	}
	
	public void paintProd(int m, int n, String path) {
		
		Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
						.getScaledInstance(balas[m][n].getWidth(), balas[m][n].getHeight(), 0));
				
		balas[m][n].setIcon(img);		
	}
	
	public void paintCartel(int m, int n, String path) {
		
		Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
						.getScaledInstance(carteles[m][n].getWidth(), carteles[m][n].getHeight(), 0));
				
		carteles[m][n].setIcon(img);		
	}
	
	public int getCatO() {
		return catO;
	}
	public int getCatV() {
		return catV;
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