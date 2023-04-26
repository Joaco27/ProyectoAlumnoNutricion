import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class MenuPanel extends JPanel{
	
	public MenuPanel(int v, int n) {
		setLayout(null);
		JLabel jl1 = new JLabel("Comenzar", SwingConstants.CENTER);
		jl1.setForeground(Color.WHITE);
		jl1.setOpaque(true);
		jl1.setBackground(Color.blue);
		jl1.setBounds(300, 40, 200, 50);
		jl1.setFont(new Font(null, 0, 40));
		add(jl1);
		
		JLabel jl2 = new JLabel("Seleccionar Desafio", SwingConstants.CENTER);
		jl2.setForeground(Color.WHITE); 
		jl2.setOpaque(true);
		jl2.setBackground(Color.blue);
		jl2.setBounds(200, 150, 400, 50);
		jl2.setFont(new Font(null, 0, 40));
		add(jl2);
		
		JLabel jl3 = new JLabel("Equipo Violeta: "+v, SwingConstants.CENTER);
		jl3.setForeground(Color.WHITE);
		jl3.setOpaque(true);
		jl3.setBackground(new Color(159, 0, 255));
		jl3.setBounds(400, 270, 350, 50);
		jl3.setFont(new Font(null, 0, 30));
		add(jl3);
		
		JLabel jl4 = new JLabel("Equipo Naranja: "+n, SwingConstants.CENTER);
		jl4.setForeground(Color.WHITE);
		jl4.setOpaque(true);
		jl4.setBackground(Color.ORANGE);
		jl4.setBounds(40, 270, 350, 50);
		jl4.setFont(new Font(null, 0, 30));
		add(jl4);
	}
}
