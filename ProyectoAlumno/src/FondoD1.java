import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.Border;

public class FondoD1 extends JPanel{
	
	private JLabel [][] progreso = new JLabel[2][10];
	
	public FondoD1(int ancho, int alto) {
		setLayout(null);
		int altoBtn = alto/5/2;
		int anchoBtn = ancho/8;
		int derechaBtn = ancho-ancho/8;
		
		Border lineaBorde = BorderFactory.createLineBorder(Color.black);
		
		
		for(int i=0; i<10; i++) {
			progreso[0][i] = new JLabel();
			progreso[0][i].setOpaque(true);
			//progreso[0][i].setBorder(lineaBorde);
			progreso[0][i].setBackground(Color.gray);
			progreso[0][i].setBounds(0, altoBtn*i, anchoBtn, altoBtn);
			add(progreso[0][i]);
		}
		
		for(int i=0; i<10; i++) {
			progreso[1][i] = new JLabel();
			progreso[1][i].setOpaque(true);
			//progreso[1][i].setBorder(lineaBorde);
			progreso[1][i].setBackground(Color.gray);
			progreso[1][i].setBounds(derechaBtn, altoBtn*i, anchoBtn, altoBtn);
			add(progreso[1][i]);
		}
		
		
		
	}
	
	public JLabel[] getProgreso(int i) {
		return progreso[i];
	}
	
	
	
}
	
