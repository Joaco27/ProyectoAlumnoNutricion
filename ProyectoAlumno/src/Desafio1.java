import java.awt.Color;
import java.awt.Font;

import javax.swing.*;


public class Desafio1 extends JPanel{
	
	private JLabel [][] progreso = new JLabel[2][5];
	private int pActualO = 5, pActualV = 5;
	private JLabel termineO, termineV;
	private DefaultTimer dt;
	private JLabel ganador;
	
	public Desafio1(int alto, int ancho){
		
		//System.out.println("Alto: "+alto+" Ancho: "+ancho);
		
		ganador = new JLabel();
		ganador.setBounds(300, 20, 200, 40);
		add(ganador);
		
		
		int anchoBarra = ancho / 8;
		int altoBarra = alto / 5;
		
		setLayout(null);
		progreso[0][0] = new JLabel();
		progreso[0][0].setOpaque(true);
		progreso[0][0].setBackground(Color.gray);
		progreso[0][0].setBounds(0, 0, anchoBarra, altoBarra);
		add(progreso[0][0]);
		
		progreso[0][1] = new JLabel();
		progreso[0][1].setOpaque(true);
		progreso[0][1].setBackground(Color.gray);
		progreso[0][1].setBounds(0, altoBarra, anchoBarra, altoBarra);
		add(progreso[0][1]);
		
		progreso[0][2] = new JLabel();
		progreso[0][2].setOpaque(true);
		progreso[0][2].setBackground(Color.gray);
		progreso[0][2].setBounds(0, altoBarra*2, anchoBarra, altoBarra);
		add(progreso[0][2]);
		
		progreso[0][3] = new JLabel();
		progreso[0][3].setOpaque(true);
		progreso[0][3].setBackground(Color.gray);
		progreso[0][3].setBounds(0, altoBarra*3, anchoBarra, altoBarra);
		add(progreso[0][3]);
		
		progreso[0][4] = new JLabel();
		progreso[0][4].setOpaque(true);
		progreso[0][4].setBackground(Color.gray);
		progreso[0][4].setBounds(0, altoBarra*4, anchoBarra, altoBarra);
		add(progreso[0][4]);
		
		
		progreso[1][0] = new JLabel();
		progreso[1][0].setOpaque(true);
		progreso[1][0].setBackground(Color.gray);
		progreso[1][0].setBounds(700, 0, anchoBarra, altoBarra);
		add(progreso[1][0]);
		
		progreso[1][1] = new JLabel();
		progreso[1][1].setOpaque(true);
		progreso[1][1].setBackground(Color.gray);
		progreso[1][1].setBounds(700, altoBarra, anchoBarra, altoBarra);
		add(progreso[1][1]);
		
		progreso[1][2] = new JLabel();
		progreso[1][2].setOpaque(true);
		progreso[1][2].setBackground(Color.gray);
		progreso[1][2].setBounds(700, altoBarra*2, anchoBarra, altoBarra);
		add(progreso[1][2]);
		
		progreso[1][3] = new JLabel();
		progreso[1][3].setOpaque(true);
		progreso[1][3].setBackground(Color.gray);
		progreso[1][3].setBounds(700, altoBarra*3, anchoBarra, altoBarra);
		add(progreso[1][3]);
		
		progreso[1][4] = new JLabel();
		progreso[1][4].setOpaque(true);
		progreso[1][4].setBackground(Color.gray);
		progreso[1][4].setBounds(700, altoBarra*4, anchoBarra, altoBarra);
		add(progreso[1][4]);
		
		int altoImg = 360;
		int anchoImg = 300;
		
		JLabel imagen1 = new JLabel();
		imagen1.setOpaque(true); 
		imagen1.setBackground(Color.black);
		imagen1.setBounds(100, 100, anchoImg, altoImg);
		add(imagen1);
		
		JLabel imagen2 = new JLabel();
		imagen2.setOpaque(true);
		imagen2.setBackground(Color.blue);
		imagen2.setBounds(400, 100, anchoImg, altoImg);
		add(imagen2);
		
		JLabel botonO = new JLabel("Confirmar", SwingConstants.CENTER);
		botonO.setOpaque(true);
		botonO.setBackground(Color.orange);
		botonO.setBounds(200, 520, 100, 40);
		add(botonO);
		
		JLabel botonV = new JLabel("Confirmar", SwingConstants.CENTER);
		botonV.setOpaque(true);
		botonV.setBackground(new Color(159, 0, 255));
		botonV.setBounds(500, 520, 100, 40);
		add(botonV);
		
		dt = new DefaultTimer();
		dt.setBounds(350, 520, 100, 40);
		add(dt);
		
		termineO = new JLabel();
		termineO.setBounds(180, 40, 200, 40);
		add(termineO);
		
		termineV = new JLabel();
		termineV.setBounds(480, 40, 200, 40);
		add(termineV);
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
		termineO.setText("Terminaste con "+pts+" puntos en "+dt.getTime());
		return dt.getTotalTime();
	}

	public int terminoV(int pts) {
		//Muestra en pantalla los puntos y el tiempo que tardo el equipo violeta, y devuelve el tiempo total transcurrido
		termineV.setText("Terminaste con "+pts+" puntos en "+dt.getTime());
		return dt.getTotalTime();
	}
	
	public void termine() {
		//Detengo el timer
		dt.stop();
	}
	
	public JLabel getPPanelWin() {
		//Retron el panel donde se informara equipo ganador y beneficio
		return ganador;
	}
}
