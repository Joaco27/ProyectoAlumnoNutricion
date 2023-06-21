package funcionalidades;
import funcionalidades.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.*;


public class Desafio2 extends JPanel{

	
	private JLabel [] progreso = new JLabel[2];
	private int pActualO = 0, pActualV = 0;
	private DefaultTimer dt;
	private Image img;
	private JLabel nino1, nino2, caido1, caido2, continuar;

    Integer puntajeO = 0, puntajeV = 0;
    int randNumb = 0;
    int squareWidth = 25;
    int squareHeight = 25;
    int squareYLocation = -squareHeight;
    boolean numberCreated = false;

	public Desafio2(int alto, int ancho ){

		setLayout(null);
		//System.out.println("Alto: "+alto+" Ancho: "+ancho);
		
		
		int anchoBarra = ancho / 8;
		int altoBarra = alto / 5;
		int altoImg = alto/2;
		int anchoImg = (ancho-anchoBarra*2)/2;
		
		int heightBtn = altoBarra/2;
		
		dt = new DefaultTimer();
		dt.setOpaque(false);
		dt.setBackground(new Color(0,0,0,0));
		dt.setBounds(ancho/2-(ancho/6/2)-10, 10, ancho/6, heightBtn/2);
		add(dt);
		
		continuar = new JLabel("", SwingConstants.CENTER);
		continuar.setOpaque(false);
		continuar.setBackground(new Color(0,0,0,0));
		continuar.setForeground(Color.white);
		continuar.setBounds(ancho/2-(ancho/6/2)-7, alto-100, ancho/6, heightBtn/2);
		add(continuar);
		
		int anchoB = anchoBarra/4;	
		int derechaB = anchoB/4;
		
		progreso[0] = new JLabel(puntajeV.toString(), SwingConstants.CENTER);
		progreso[0].setForeground(Color.WHITE);
		progreso[0].setOpaque(true);
		progreso[0].setBackground(new Color(159, 0, 255));
		progreso[0].setBounds(derechaB, altoBarra/4, anchoB, altoBarra);
		add(progreso[0]);
		
		progreso[1] = new JLabel(puntajeO.toString(), SwingConstants.CENTER);
		progreso[1].setForeground(Color.BLACK);
		progreso[1].setOpaque(true); 
		progreso[1].setBackground(Color.orange);
		progreso[1].setBounds(derechaB, altoBarra, anchoB, altoBarra);
		add(progreso[1]);
		
	    nino1 = new JLabel("IMG-1", SwingConstants.CENTER);
		nino1.setOpaque(false);
	    //imagen1.setBackground(Color.black);
		nino1.setBounds(anchoBarra-anchoB-20, alto/3+200, anchoImg, altoImg);
		add(nino1);
		
		/*nino2 = new JLabel("IMG-2", SwingConstants.CENTER);
		nino2.setOpaque(false);
		//imagen2.setBackground(Color.blue);
		nino2.setBounds(derechaImg+anchoB+20, alto/3-10, anchoImg, altoImg);
		add(nino2);*/
		
		//podria hacerlos en un arreglo
		caido1 = new JLabel("IMG-C1", SwingConstants.CENTER);
		caido1.setOpaque(false);
	    //imagen1.setBackground(Color.black);
		caido1.setBounds(anchoBarra-anchoB-20, alto, anchoImg, altoImg);
		add(caido1);
		
		caido2 = new JLabel("IMG-C2", SwingConstants.CENTER);
		caido2.setOpaque(false);
	    //imagen1.setBackground(Color.black);
		caido2.setBounds(anchoBarra-anchoB-20, alto, anchoImg, altoImg);
		add(caido2);
		

	}
	
	public void paint(Graphics g) {
		
		img = new ImageIcon(getClass().getResource("/imagenes/PlaceholderFondoD2.png")).getImage();
		
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		
		setOpaque(false);
		
		setBackground(new Color(0,0,0,0));
		
		super.paint(g);
	}
	
	public void evaluarCaida1(String path,int alto,int ancho) {
		
		int anchoBarra = ancho / 8;
		int altoImg = alto/2;
		int anchoImg = (ancho-anchoBarra*2)/2;
		
		Random r = new Random();
		int coordX = r.nextInt(ancho);
		int coordY = alto;
		
        this.moverCaido(path,0,coordX,altoImg, anchoImg);
	}
	
	public void moverCaido(String path, int posY, int posX,int alto, int ancho) {
		
		int anchoBarra = ancho / 8;
		int altoImg = alto/2;
		int anchoImg = (ancho-anchoBarra*2)/2;
		
		int ninoX = nino1.getX();
		int ninoY = nino1.getY();
		
		if (posY < alto/3+250) {
			caido1.setBounds(posX, posY - 50, anchoImg, altoImg);
			moverCaido(path,posY - 50,posX,altoImg, anchoImg);
			paintC1(path);
		} else if (((ninoY - posY) < 30) && ((ninoX - posX) < 30)){
			this.puntajeO++;
			caido1.setBounds(posX, 0, anchoImg, altoImg);
			}
			else caido1.setBounds(posX, 0, anchoImg, altoImg);
	}
	
	public void reubicarImgO(String path, float coordX,int alto, int ancho) {
		
		int anchoBarra = ancho / 8;
		int altoImg = alto/2;
		int anchoImg = (ancho-anchoBarra*2)/2;
		int posX = (int)(coordX * ancho);
		
		nino1.setBounds(posX, alto/3+200, anchoImg, altoImg);
		
		paintImgO(path);
		
	}
	
	public void paintImgO(String path) {
		
		Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
				.getScaledInstance(nino1.getWidth(), nino1.getHeight(), 0));
		
		nino1.setIcon(img);
		
	}
	
	public void paintImgV(String path) {
		
		Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
				.getScaledInstance(nino2.getWidth(), nino2.getHeight(), 0));
		
		nino2.setIcon(img);

	}
	
	public void paintC1(String path) {
		
		Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
				.getScaledInstance(caido1.getWidth(), caido1.getHeight(), 0));
		
		caido1.setIcon(img);

	}
	
	//todavia no lo uso - Completar
	public boolean cambioV(String path) {
		
		Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
				.getScaledInstance(nino2.getWidth(), nino2.getHeight(), 0));
		
		nino2.setIcon(img);
		
		return (true);
	}
	
	public int getTotalTimer() {
		return this.dt.getTotalTime();
	}
	
	public JLabel getPEquipoO() {
		return progreso[0];
	}

	
	public JLabel getPEquipoV() {
		return progreso[1];
	}
    
	public int terminoO(int pts) {
		//Muestra en pantalla los puntos y el tiempo que tardo el equipo naranja, y devuelve el tiempo total transcurrido
		//termineO.setText("Terminaste con "+pts+" puntos en "+dt.getTime());
		int fase = dt.getTotalTime() / 2;
		return fase;
	}

	public int terminoV(int pts) {
		//Muestra en pantalla los puntos y el tiempo que tardo el equipo violeta, y devuelve el tiempo total transcurrido
		//termineV.setText("Terminaste con "+pts+" puntos en "+dt.getTime());
		return dt.getTotalTime();
	}
	
	public void continuar() {
		continuar.setText("Continuar");
		continuar.setOpaque(true);
		continuar.setBackground(Color.black);
	}
	public void termine() {
		//Detengo el timer
		dt.stop();
	}
}