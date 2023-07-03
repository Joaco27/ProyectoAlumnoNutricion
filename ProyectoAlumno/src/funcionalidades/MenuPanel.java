package funcionalidades;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class MenuPanel extends JPanel{
	private Image img;
	private JLabel cSellos;

	
	public MenuPanel(int v, int n, int ancho, int alto) {
		setLayout(null);
		
		
		cSellos = new JLabel();
		cSellos.setOpaque(true);
		cSellos.setBounds(50, 200, 400, 400);
		Icon carrera = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/InicioCarreraDeSellos.png")).getImage()
				.getScaledInstance(cSellos.getWidth(), cSellos.getHeight(), 0));
		cSellos.setIcon(carrera);
		add(cSellos);
		
		this.setGanador(v, n);
		
		
	}
	
	public void paint(Graphics g) {
			
			img = new ImageIcon(getClass().getResource("/imagenes/inicioVacio.png")).getImage();
			
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			
			setOpaque(false);
			
			setBackground(new Color(0,0,0,0));
			
			super.paint(g);
		}
	
	public void setGanador(int v, int n) {
		if (v>n) {
			Icon i = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/InicioCarreraDeSellosConMedalla.png")).getImage()
					.getScaledInstance(cSellos.getWidth(), cSellos.getHeight(), 0));
			cSellos.setIcon(i);
		}
		else {
			if(n>v) {
				Icon i = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/InicioCarreraDeSellosConMedallaNaranja.png")).getImage()
						.getScaledInstance(cSellos.getWidth(), cSellos.getHeight(), 0));
				cSellos.setIcon(i);
			}
		}
	}
}