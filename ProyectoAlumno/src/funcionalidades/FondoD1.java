package funcionalidades;
import funcionalidades.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.Border;

public class FondoD1 extends JPanel{
	
	private JLabel [][] progreso = new JLabel[2][5];
	
	public FondoD1(int ancho, int alto) {
		setLayout(null);
		int altoBtn = alto/5-11;
		int anchoBtn = ancho/32+5;
		int derechaBtn = ancho-ancho/32*3/2-5;
		
		Border lineaBorde = BorderFactory.createLineBorder(Color.black);
		
		
		for(int i=0; i<5; i++) {
			progreso[0][i] = new JLabel();
			progreso[0][i].setOpaque(true);
			progreso[0][i].setBorder(lineaBorde);
			progreso[0][i].setBackground(Color.white);
			progreso[0][i].setBounds(0, altoBtn*i+7, anchoBtn, altoBtn);
			add(progreso[0][i]);
		}
		
		for(int i=0; i<5; i++) {
			progreso[1][i] = new JLabel();
			progreso[1][i].setOpaque(true);
			progreso[1][i].setBorder(lineaBorde);
			progreso[1][i].setBackground(Color.white);
			progreso[1][i].setBounds(derechaBtn,  altoBtn*i+7, anchoBtn, altoBtn);
			add(progreso[1][i]);
		}
		
		
		
	}
	
	public JLabel getProgreso(int i, int j) {
		return progreso[i][j];
	}
	
	public void tresCorazones(JLabel j) {
		Icon img = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/tresCorazones.png")).getImage()
				.getScaledInstance(j.getWidth(), j.getHeight(), 0));
		
		j.setIcon(img);
	}
	
	public void unCorazon(JLabel j) {
		Icon img = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/unCorazon.png")).getImage()
				.getScaledInstance(j.getWidth(), j.getHeight(), 0));
		
		j.setIcon(img);
	}
	
	
}
	
