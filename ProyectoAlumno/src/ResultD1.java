import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import TUIO.TuioBlob;
import TUIO.TuioCursor;
import TUIO.TuioListener;
import TUIO.TuioObject;
import TUIO.TuioTime;

public class ResultD1 extends JPanel{
	private Image img;

	
	
	public ResultD1(int alto, int ancho, Puntaje pts, int terminoO, int terminoV){
		
		setLayout(null);
		
		
		if(pts.getEquipoV()>pts.getEquipoO()) {
			pts.aumentarEquipoV(5);
		}
		else {
			if(pts.getEquipoV()<pts.getEquipoO()) {
				pts.aumentarEquipoO(5);
			}
			else {
				if(terminoO>terminoV) {
					pts.aumentarEquipoV(5);
				}
				else {
					pts.aumentarEquipoO(5);
				}
			}
		}

		
		int anchoBtn = ancho/3;
		int altoBtn = alto/8;
		int abajoBtn = alto/2;
		int derechaTM = ancho/7;
		
		JLabel puntosO= new JLabel(""+pts.getEquipoO(), SwingConstants.CENTER);
		puntosO.setOpaque(true);
		puntosO.setForeground(Color.white);
		puntosO.setBackground(new Color(0, 0, 0, 0));
		puntosO.setFont(new Font(null, 0, 40));
		puntosO.setBounds(derechaTM+15, abajoBtn-25, anchoBtn, altoBtn);
		add(puntosO);
		
		JLabel tiempoO= new JLabel(this.getTime(terminoO), SwingConstants.CENTER);
		tiempoO.setOpaque(true);
		tiempoO.setForeground(Color.white);
		tiempoO.setBackground(new Color(0, 0, 0, 0));
		tiempoO.setFont(new Font(null, 0, 40));
		tiempoO.setBounds(derechaTM+15, abajoBtn+35, anchoBtn, altoBtn);
		add(tiempoO);
		
		JLabel puntosV= new JLabel(""+pts.getEquipoV(), SwingConstants.CENTER);
		puntosV.setOpaque(true);
		puntosV.setForeground(Color.white);
		puntosV.setBackground(new Color(0, 0, 0, 0));
		puntosV.setFont(new Font(null, 0, 40));
		puntosV.setBounds(derechaTM*4+60, abajoBtn-25, anchoBtn, altoBtn);
		add(puntosV);
		
		JLabel tiempoV= new JLabel(this.getTime(terminoV), SwingConstants.CENTER);
		tiempoV.setOpaque(true);
		tiempoV.setForeground(Color.white);
		tiempoV.setBackground(new Color(0, 0, 0, 0));
		tiempoV.setFont(new Font(null, 0, 40));
		tiempoV.setBounds(derechaTM*4+60, abajoBtn+40, anchoBtn, altoBtn);
		add(tiempoV);
		
		
	}
	
	public String getTime(int tiempo) {
    	//devuelve el tiempo transcurrido en formato min:seg
    	int min = tiempo / 60;
        int seg = tiempo % 60;
    	return String.format("%d:%02d", min, seg);
    }
	
	public void paint(Graphics g) {
			
			img = new ImageIcon(getClass().getResource("/imagenes/fondoResultadosDesafio1024x768.png")).getImage();
			
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			
			setOpaque(false);
			
			setBackground(new Color(0,0,0,0));
			
			super.paint(g);
		}
		
	}
