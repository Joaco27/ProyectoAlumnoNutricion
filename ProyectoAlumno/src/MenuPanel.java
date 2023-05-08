import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class MenuPanel extends JPanel{
	
	public MenuPanel(int v, int n, int ancho, int alto) {
		setLayout(null);
		int anchoBtn = ancho/3;
		int altoBtn = alto/8;
		int abajoBtn = alto/3/2;
		
		JLabel jl1 = new JLabel("Comenzar", SwingConstants.CENTER);
		jl1.setForeground(Color.WHITE);
		jl1.setOpaque(true);
		jl1.setBackground(Color.blue);
		jl1.setBounds(anchoBtn, abajoBtn, anchoBtn, altoBtn);
		jl1.setFont(new Font(null, 0, 40));
		add(jl1);
		
		int anchito = anchoBtn-anchoBtn/2/2;
		JLabel jl2 = new JLabel("Seleccionar Desafio", SwingConstants.CENTER);
		jl2.setForeground(Color.WHITE); 
		jl2.setOpaque(true);
		jl2.setBackground(Color.blue);
		jl2.setBounds(anchito, abajoBtn*2, anchoBtn+anchoBtn/2, altoBtn);
		jl2.setFont(new Font(null, 0, 40));
		add(jl2);
		
		int derechaTM = ancho/4/2;
		
		JLabel jl3 = new JLabel("Equipo Violeta: "+v, SwingConstants.CENTER);
		jl3.setForeground(Color.WHITE);
		jl3.setOpaque(true);
		jl3.setBackground(new Color(159, 0, 255));
		jl3.setBounds(derechaTM*4, abajoBtn*3, anchoBtn, altoBtn);
		jl3.setFont(new Font(null, 0, 30));
		add(jl3);
		
		JLabel jl4 = new JLabel("Equipo Naranja: "+n, SwingConstants.CENTER);
		jl4.setForeground(Color.WHITE);
		jl4.setOpaque(true);
		jl4.setBackground(Color.ORANGE);
		jl4.setBounds(derechaTM, abajoBtn*3, anchoBtn, altoBtn);
		jl4.setFont(new Font(null, 0, 30));
		add(jl4);
	}
}
