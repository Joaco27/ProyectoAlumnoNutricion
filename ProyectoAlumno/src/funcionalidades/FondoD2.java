
package funcionalidades;
import funcionalidades.*;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class FondoD2 extends JPanel{
	private Image img;
	
	public void paint(Graphics g) {
		
		img = new ImageIcon(getClass().getResource("/imagenes/fondo.png")).getImage();
		
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		
		setOpaque(false);
		
		super.paint(g);
	}
}
