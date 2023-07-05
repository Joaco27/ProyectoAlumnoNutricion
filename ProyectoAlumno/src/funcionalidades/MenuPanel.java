package funcionalidades;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class MenuPanel extends JPanel{
	private Image img;
	private JLabel cSellos, cAlimentos;

	
	public MenuPanel(int v, int n, int ancho, int alto) {
		setLayout(null);
		
		
		cSellos = new JLabel();
		cSellos.setOpaque(true);
		cSellos.setBackground(new Color(0,0,0,0));
		cSellos.setBounds(50, 200, 400, 400);
		Icon carrera = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/InicioCarreraDeSellos.png")).getImage()
				.getScaledInstance(cSellos.getWidth(), cSellos.getHeight(), 0));
		cSellos.setIcon(carrera);
		add(cSellos);
		
		cAlimentos = new JLabel();
		cAlimentos.setOpaque(true);
		cAlimentos.setBackground(new Color(0,0,0,0));
		cAlimentos.setBounds(550, 200, 400, 400);
		Icon captura = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/inicioCapturaDeAlimentosPROX.png")).getImage()
				.getScaledInstance(cAlimentos.getWidth(), cAlimentos.getHeight(), 0));
		cAlimentos.setIcon(captura);
		add(cAlimentos);
		
		this.setGanador(v, n);
		
		
	}
	
	public void paint(Graphics g) {
			
			img = new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/inicioVacio.png")).getImage();
			
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			
			setOpaque(false);
			
			setBackground(new Color(0,0,0,0));
			
			super.paint(g);
		}
	
	public void setGanador(int v, int n) {
		if (v>n) {
			cSellos.setBounds(50, 200, 400, 480);
			Icon i = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/InicioCarreraDeSellosConMedalla.png")).getImage()
					.getScaledInstance(cSellos.getWidth(), cSellos.getHeight(), 0));
			cSellos.setIcon(i);
		}
		else {
			if(n>v) {
				cSellos.setBounds(50, 200, 400, 480);
				Icon i = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/InicioCarreraDeSellosConMedallaNaranja.png")).getImage()
						.getScaledInstance(cSellos.getWidth(), cSellos.getHeight(), 0));
				cSellos.setIcon(i);
			}
		}
	}
}