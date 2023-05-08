import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;


public class Desafio1 extends JPanel{
	
	private JLabel [][] progreso = new JLabel[2][5];
	private int pActualO = 5, pActualV = 5;
	private DefaultTimer dt;
	private Image img;

	
	public Desafio1(int alto, int ancho){

		setLayout(null);
		//System.out.println("Alto: "+alto+" Ancho: "+ancho);
		
		//ganador = new JLabel();
		//ganador.setBounds(300, 20, 200, 40);
		//add(ganador);
		
		
		
		int anchoBarra = ancho / 8;
		int altoBarra = alto / 5;
		int altoImg = alto/2;
		int anchoImg = (ancho-anchoBarra*2)/2;
		
		
		int derechaImg = anchoBarra + anchoImg;
		int heightBtn = altoBarra/2;
		
		
		int derechaBarra = anchoBarra+anchoImg*2;
		
		dt = new DefaultTimer();
		dt.setOpaque(false);
		dt.setBackground(new Color(0,0,0,0));
		dt.setBounds(ancho/2-(ancho/6/2)-10, 10, ancho/6, heightBtn/2);
		add(dt);
		//JLabel desafio = new JLabel("Etiqueta el alimento que te corresponde");
		//desafio.setBounds(anchoBarra*3, altoBarra/2, 300, 40);
		//add(desafio);
		
	
		
		int anchoB = anchoBarra/4;	
		int derechaB = anchoB/4;
		
		progreso[0][0] = new JLabel();
		progreso[0][0].setOpaque(false);
		progreso[0][0].setBounds(derechaB, altoBarra/4, anchoB, altoBarra);
		add(progreso[0][0]);
		
		progreso[0][1] = new JLabel();
		progreso[0][1].setOpaque(false); 
		progreso[0][1].setBounds(derechaB, altoBarra, anchoB, altoBarra);
		add(progreso[0][1]);
		
		progreso[0][2] = new JLabel();
		progreso[0][2].setOpaque(false);
		progreso[0][2].setBounds(derechaB, altoBarra*2, anchoB, altoBarra);
		add(progreso[0][2]);
		
		progreso[0][3] = new JLabel();
		progreso[0][3].setOpaque(false);
		progreso[0][3].setBounds(derechaB, altoBarra*3, anchoB, altoBarra);
		add(progreso[0][3]);
		
		progreso[0][4] = new JLabel();
		progreso[0][4].setOpaque(false);
		progreso[0][4].setBounds(derechaB, altoBarra*4, anchoB, altoBarra-altoBarra/2+10);
		add(progreso[0][4]);
		
		
		progreso[1][0] = new JLabel();
		progreso[1][0].setOpaque(false);
		progreso[1][0].setBounds(derechaBarra+anchoBarra/2+8, altoBarra/6, anchoB, altoBarra);
		add(progreso[1][0]);
		
		progreso[1][1] = new JLabel();
		progreso[1][1].setOpaque(false);
		progreso[1][1].setBounds(derechaBarra+anchoBarra/2+8, altoBarra, anchoB, altoBarra);
		add(progreso[1][1]);
		
		progreso[1][2] = new JLabel();
		progreso[1][2].setOpaque(false);
		progreso[1][2].setBounds(derechaBarra+anchoBarra/2+8, altoBarra*2, anchoB, altoBarra);
		add(progreso[1][2]);
		
		progreso[1][3] = new JLabel();
		progreso[1][3].setOpaque(false);
		progreso[1][3].setBounds(derechaBarra+anchoBarra/2+8, altoBarra*3, anchoB, altoBarra);
		add(progreso[1][3]);
		
		progreso[1][4] = new JLabel();
		progreso[1][4].setOpaque(false);
		progreso[1][4].setBounds(derechaBarra+anchoBarra/2+8, altoBarra*4, anchoB, altoBarra-altoBarra/2+10);
		add(progreso[1][4]);
		
		
		
		JLabel imagen1 = new JLabel("IMG-1", SwingConstants.CENTER);
		imagen1.setOpaque(false);
		//imagen1.setBackground(Color.black);
		imagen1.setBounds(anchoBarra-anchoB-20, alto/3-10, anchoImg, altoImg);
		add(imagen1);
		
		
		
		JLabel imagen2 = new JLabel("IMG-2", SwingConstants.CENTER);
		imagen2.setOpaque(false);
		//imagen2.setBackground(Color.blue);
		imagen2.setBounds(derechaImg+anchoB+20, alto/3-10, anchoImg, altoImg);
		add(imagen2);
		
		
		//JLabel botonO = new JLabel("Listo", SwingConstants.CENTER);
		//botonO.setOpaque(true);
		//botonO.setForeground(Color.white);
		//botonO.setBackground(Color.black);
		//botonO.setBounds(derechaConf1, abajoConf, anchoBarra, heightBtn);
		//add(botonO);
		
		//JLabel botonV = new JLabel("Listo", SwingConstants.CENTER);
		//botonV.setOpaque(true);
		//botonV.setForeground(Color.white);
		//botonV.setBackground(Color.black);
		//botonV.setBounds(derechaConf2, abajoConf, anchoBarra, heightBtn);
		//add(botonV);
		
		
		
		//termineO = new JLabel();
		//termineO.setBounds(derechaWin1, abajoWin, widhtWin, altoBarra/2);
		//add(termineO);
		
		//termineV = new JLabel();
		//termineV.setBounds(derechaWin2, abajoWin, widhtWin, altoBarra/2);
		//add(termineV);
	}
	
	public void paint(Graphics g) {
		
		img = new ImageIcon(getClass().getResource("/imagenes/fondo(Barras Vacias).png")).getImage();
		
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		
		setOpaque(false);
		
		setBackground(new Color(0,0,0,0));
		
		super.paint(g);
	}
	
	public JLabel getPEquipoO() {
		//Retron progreso actual del equipo naranja o null si ya termino
		// decremento porque el progreso de la primer posicion me quedo arriba, entonces lo invierto
		if (pActualO>0) {
			pActualO--;
			return progreso[0][pActualO];
		}
		return null;
	}
	
	public JLabel getPEquipoV() {
		//Retron progreso actual del equipo violeta o null si ya termino
		// decremento porque el progreso de la primer posicion me quedo arriba, entonces lo invierto
		if (pActualV>0) {
			pActualV--;
			return progreso[1][pActualV];
		}
		return null;
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
	
	//public void termine() {
		//Detengo el timer
		//dt.stop();
	//}
	
	//public JLabel getPPanelWin() {
		//Retron el panel donde se informara equipo ganador y beneficio
		//return ganador;
	//}
}
