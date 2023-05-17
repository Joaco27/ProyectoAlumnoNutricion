import java.awt.Color;
import java.awt.Font;

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
	
	
	
	public ResultD1(int alto, int ancho, Puntaje pts, int terminoO, int terminoV){
		
		setLayout(null);
		int anchoBtn = ancho/3;
		int altoBtn = alto/8;
		int abajoBtn = alto/3/2;
		
		JLabel titulo = new JLabel("", SwingConstants.CENTER);
		if(pts.getEquipoV()>pts.getEquipoO()) {
			pts.aumentarEquipoV(5);
			titulo.setText("Ganador Violeta");
		}
		else {
			if(pts.getEquipoV()<pts.getEquipoO()) {
				titulo.setText("Ganador Naranja");
				pts.aumentarEquipoO(5);
			}
			else {
				titulo.setText("Empate");
			}
		}
		titulo.setBounds(anchoBtn, abajoBtn, anchoBtn, altoBtn);
		titulo.setFont(new Font(null, 0, 40));
		add(titulo);
		
		int anchito = anchoBtn-anchoBtn/2/2;
		JLabel siguiente = new JLabel("Siguiente", SwingConstants.CENTER);
		siguiente.setForeground(Color.WHITE); 
		siguiente.setOpaque(true);
		siguiente.setBackground(Color.blue);
		siguiente.setFont(new Font(null, 0, 40));
		siguiente.setBounds(anchito, abajoBtn*3, anchoBtn+anchoBtn/2, altoBtn);
		add(siguiente);
		
		int derechaTM = ancho/4/2;
		
		JLabel teamV = new JLabel("Equipo Violeta: "+pts.getEquipoV(), SwingConstants.CENTER);
		teamV.setForeground(Color.WHITE);
		teamV.setOpaque(true);
		teamV.setBackground(new Color(159, 0, 255));
		teamV.setFont(new Font(null, 0, 30));
		teamV.setBounds(derechaTM*4, abajoBtn*2, anchoBtn, altoBtn);
		add(teamV);
		
		JLabel teamO = new JLabel("Equipo Naranja: "+pts.getEquipoO(), SwingConstants.CENTER);
		teamO.setForeground(Color.WHITE);
		teamO.setOpaque(true);
		teamO.setBackground(Color.ORANGE);
		teamO.setFont(new Font(null, 0, 30));
		teamO.setBounds(derechaTM, abajoBtn*2, anchoBtn, altoBtn);
		add(teamO);
		
	}
	
}
