import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.border.Border;

import TUIO.TuioListener;


public class Desafio1 extends JPanel{
	
	private JLabel [][] etiquetas = new JLabel[2][4];
	private int pActualO = 5, pActualV = 5;
	private DefaultTimer dt;
	private Image img;
	private JLabel imagen1, imagen2, VR, noEts1, noEts2, sigImg1, sigImg2;
	private FondoD1 fondo;

	
	public Desafio1(int alto, int ancho, ListenerD1 list, FondoD1 fondo){
		this.fondo=fondo;

		setLayout(null);
		//System.out.println("Alto: "+alto+" Ancho: "+ancho);
		
		
		int anchoBarra = ancho / 8;
		int altoBarra = alto / 5;
		int altoImg = alto/2;
		int anchoImg = (ancho-anchoBarra*2)/2;
		
		
		int derechaImg = anchoBarra + anchoImg;
		int heightBtn = altoBarra/2;
		
		
		int derechaBarra = anchoBarra+anchoImg*2;
		
		dt = new DefaultTimer(list);
		dt.setOpaque(false);
		dt.setBackground(new Color(0,0,0,0));
		dt.setBounds(ancho/2-(ancho/6/2)-10, 5, ancho/6, heightBtn/2);
		add(dt);

		int anchoVR = ancho - ancho/8*2;
		VR = new JLabel("", SwingConstants.CENTER);
		VR.setOpaque(false);
		VR.setBounds(ancho/8, alto-135, anchoVR, heightBtn+15);
		add(VR);
		
	
		
		int anchoB = anchoBarra/4;	
		int derechaB = anchoB/4;
				
		
		int derechaET1 = anchoB*2;
		int abajoET = (alto/3-10)/2;
		int anchoET = (ancho/2-derechaET1)/5+15;
		int altoET = abajoET+65;
		
		noEts1=new JLabel("", SwingConstants.CENTER);
		noEts1.setOpaque(false);
		noEts1.setFont(new Font("Serif", Font.BOLD, 30));
		noEts1.setBounds(derechaET1, abajoET, anchoET*3, altoET/2);
		add(noEts1);
		
		for(int i=0; i<4; i++) {
			etiquetas[0][i] = new JLabel("", SwingConstants.CENTER);
			etiquetas[0][i].setOpaque(false);
			etiquetas[0][i].setForeground(Color.white);
			etiquetas[0][i].setBounds(derechaET1+(anchoET+5)*i, abajoET, anchoET, altoET/2);
			add(etiquetas[0][i]);
		}
		
		
		int derechaET2 = ancho/2+20;
		
		for(int i=0; i<4; i++) {
			etiquetas[1][i] = new JLabel("", SwingConstants.CENTER);
			etiquetas[1][i].setOpaque(false);
			etiquetas[1][i].setForeground(Color.white);
			etiquetas[1][i].setBounds(derechaET2+(anchoET+5)*i, abajoET, anchoET, altoET/2);
			add(etiquetas[1][i]);
		}
		
		noEts2=new JLabel("", SwingConstants.CENTER);
		noEts2.setFont(new Font("Serif", Font.BOLD, 30));
		noEts2.setOpaque(false);
		noEts2.setBounds(derechaET2, abajoET, anchoET*3, altoET/2);
		add(noEts2);
		
		
		
		
		
		imagen1 = new JLabel("<html>Levanta las<br> etiquetas!!</html>", SwingConstants.CENTER);
		imagen1.setOpaque(false);
		imagen1.setFont(new Font("Serif", Font.BOLD, 30));
		//imagen1.setBackground(Color.black);
		imagen1.setBounds(anchoBarra-anchoB-20, alto/3-10, anchoImg, altoImg);
		add(imagen1);
		
		int derechaSig=(ancho/2)/2-(ancho/6)/2+17;
		
		sigImg1 = new JLabel("", SwingConstants.CENTER);
		sigImg1.setBounds(derechaSig-5, alto-135, ancho/6+25, heightBtn+10);
		sigImg1.setOpaque(false);
		add(sigImg1);
		
		
		
		imagen2 = new JLabel("<html>Levanta las<br> etiquetas!!</html>", SwingConstants.CENTER);
		imagen2.setOpaque(false);
		imagen2.setFont(new Font("Serif", Font.BOLD, 30));
		imagen2.setBounds(derechaImg+anchoB+20, alto/3-10, anchoImg, altoImg);
		add(imagen2);
		
		sigImg2 = new JLabel("", SwingConstants.CENTER);
		sigImg2.setBounds(derechaSig*4-75, alto-135, ancho/6+25, heightBtn+10);
		sigImg2.setOpaque(false);
		add(sigImg2);
		

	}
	
	public void paint(Graphics g) {
		
		img = new ImageIcon(getClass().getResource("/imagenes/fondo(Barras Vacias).png")).getImage();
		
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		
		setOpaque(false);
		
		setBackground(new Color(0,0,0,0));
		
		super.paint(g);
	}
	
	public void paintImgO(String path) {
		
		//imagen1.setOpaque(false);
		
		Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
				.getScaledInstance(imagen1.getWidth(), imagen1.getHeight(), 0));
		
		imagen1.setIcon(img);
		
		//g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		
		//setOpaque(true);
				
		//super.paint(g);
	}
	
	public void paintImgV(String path) {
		
		//imagen2.setOpaque(false);
		
		Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
				.getScaledInstance(imagen2.getWidth(), imagen2.getHeight(), 0));
		
		imagen2.setIcon(img);

	}
	
	public void removeImgV() {
		imagen2.setIcon(null);
		//imagen2.setOpaque(true);
		//imagen2.setDisabledIcon(imagen2.getIcon());
	}
	
	public void removeImgO() {
		imagen1.setIcon(null);
		//imagen1.setOpaque(true);
		//imagen1.setDisabledIcon(imagen1.getIcon());
	}
	
	public JLabel getPEquipoO() {
		//Retron progreso actual del equipo naranja o null si ya termino
		// decremento porque el progreso de la primer posicion me quedo arriba, entonces lo invierto
		if (pActualO>0) {
			pActualO--;
			return fondo.getProgreso(0, pActualO);
		}
		return null;
	}
	
	public JLabel getPEquipoV() {
		//Retron progreso actual del equipo violeta o null si ya termino
		// decremento porque el progreso de la primer posicion me quedo arriba, entonces lo invierto
		if (pActualV>0) {
			pActualV--;
			return fondo.getProgreso(1, pActualV);
		}
		return null;
	}
	
	public JLabel[] getEtiquetasO() {
		if(pActualO>=1) {
			Icon img1 = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/siguienteO.png")).getImage()
					.getScaledInstance(sigImg1.getWidth(), sigImg1.getHeight(), 0));
			
			sigImg1.setIcon(img1);
			sigImg1.setOpaque(true);
		}
		return etiquetas[0];
	}
	public JLabel[] getEtiquetasV() {
		if(pActualV>=1) {
			Icon img2 = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/siguienteV.png")).getImage()
					.getScaledInstance(sigImg2.getWidth(), sigImg2.getHeight(), 0));
			
			sigImg2.setIcon(img2);
			sigImg2.setOpaque(true);
		}
		return etiquetas[1];
	}
	
	public JLabel getSinEtiquetasO() {
		if(pActualO>=1) {
			Icon img1 = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/siguienteO.png")).getImage()
					.getScaledInstance(sigImg1.getWidth(), sigImg1.getHeight(), 0));
			
			sigImg1.setIcon(img1);
			sigImg1.setOpaque(true);
		}
		return noEts1;
	}
	public JLabel getSinEtiquetasV() {
		if(pActualV>=1) {
			Icon img2 = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/siguienteV.png")).getImage()
					.getScaledInstance(sigImg2.getWidth(), sigImg2.getHeight(), 0));
			
			sigImg2.setIcon(img2);
			sigImg2.setOpaque(true);
		}
		return noEts2;
	}
	
	public void blanquearEtsO() {
		sigImg1.setIcon(null);
		sigImg1.setOpaque(false);
		noEts1.setText("");
		noEts1.setOpaque(false);
		for (int i=0; i<4; i++) {
			etiquetas[0][i].setIcon(null);;
			etiquetas[0][i].setOpaque(false);
		}
	}
	
	public void blanquearEtsV() {
		sigImg2.setIcon(null);
		sigImg2.setOpaque(false);
		noEts2.setText("");
		noEts2.setOpaque(false);
		for (int i=0; i<4; i++) {
			etiquetas[1][i].setIcon(null);;
			etiquetas[1][i].setOpaque(false);
		}
	}

	public int terminoO(int pts) {
		//Muestra en pantalla los puntos y el tiempo que tardo el equipo naranja, y devuelve el tiempo total transcurrido
		//termineO.setText("Terminaste con "+pts+" puntos en "+dt.getTime());
		return dt.getTotalTime();
	}

	public int terminoV(int pts) {
		//Muestra en pantalla los puntos y el tiempo que tardo el equipo violeta, y devuelve el tiempo total transcurrido
		//termineV.setText("Terminaste con "+pts+" puntos en "+dt.getTime());
		return dt.getTotalTime();
	}
	
	public void continuar() {
		Icon img2 = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/BotonVerResultados.png")).getImage()
				.getScaledInstance(VR.getWidth(), VR.getHeight(), 0));
		
		VR.setIcon(img2);
		VR.setOpaque(true);
		
	}
	public void termine() {
		//Detengo el timer
		dt.stop();
	}
	
}
