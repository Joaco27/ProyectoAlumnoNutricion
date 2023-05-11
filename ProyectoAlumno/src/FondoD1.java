import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class FondoD1 extends JPanel{
	
	private JLabel [][] progreso = new JLabel[2][5];
	
	public FondoD1(int ancho, int alto) {
		setLayout(null);
		int altoBtn = alto/5;
		int anchoBtn = ancho/8;
		int derechaBtn = ancho-ancho/8;
		
		progreso[0][0] = new JLabel();
		progreso[0][0].setOpaque(true);
		progreso[0][0].setBackground(Color.gray);
		progreso[0][0].setBounds(0, 0, anchoBtn, altoBtn);
		add(progreso[0][0]);

		progreso[0][1] = new JLabel();
		progreso[0][1].setOpaque(true); 
		progreso[0][1].setBackground(Color.gray);
		progreso[0][1].setBounds(0, altoBtn, anchoBtn, altoBtn);
		add(progreso[0][1]);
		
		progreso[0][2] = new JLabel();
		progreso[0][2].setOpaque(true);
		progreso[0][2].setBackground(Color.gray);
		progreso[0][2].setBounds(0, altoBtn*2, anchoBtn, altoBtn);
		add(progreso[0][2]);
		
		progreso[0][3] = new JLabel();
		progreso[0][3].setOpaque(true);
		progreso[0][3].setBackground(Color.gray);
		progreso[0][3].setBounds(0, altoBtn*3, anchoBtn, altoBtn);
		add(progreso[0][3]);
		
		progreso[0][4] = new JLabel();
		progreso[0][4].setOpaque(true);
		progreso[0][4].setBackground(Color.gray);
		progreso[0][4].setBounds(0, altoBtn*4, anchoBtn, altoBtn);
		add(progreso[0][4]);
		
		
		progreso[1][0] = new JLabel();
		progreso[1][0].setOpaque(true);
		progreso[1][0].setBackground(Color.gray);
		progreso[1][0].setBounds(derechaBtn, 0, anchoBtn, altoBtn);
		add(progreso[1][0]);
		
		progreso[1][1] = new JLabel();
		progreso[1][1].setOpaque(true);
		progreso[1][1].setBackground(Color.gray);
		progreso[1][1].setBounds(derechaBtn, altoBtn, anchoBtn, altoBtn);
		add(progreso[1][1]);
		
		progreso[1][2] = new JLabel();
		progreso[1][2].setOpaque(true);
		progreso[1][2].setBackground(Color.gray);
		progreso[1][2].setBounds(derechaBtn, altoBtn*2, anchoBtn, altoBtn);
		add(progreso[1][2]);
		
		progreso[1][3] = new JLabel();
		progreso[1][3].setOpaque(true);
		progreso[1][3].setBackground(Color.gray);
		progreso[1][3].setBounds(derechaBtn, altoBtn*3, anchoBtn, altoBtn);
		add(progreso[1][3]);
		
		progreso[1][4] = new JLabel();
		progreso[1][4].setOpaque(true);
		progreso[1][4].setBackground(Color.gray);
		progreso[1][4].setBounds(derechaBtn, altoBtn*4, anchoBtn, altoBtn);
		add(progreso[1][4]);
		
	}
	
	public JLabel getProgreso(int i, int j) {
		return progreso[i][j];
	}
	
	
	
}
	
