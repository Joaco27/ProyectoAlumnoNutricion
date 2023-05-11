import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.*;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TUIO.TuioBlob;
import TUIO.TuioCursor;
import TUIO.TuioListener;
import TUIO.TuioObject;
import TUIO.TuioTime;

public class ListenerD2 extends JPanel implements TuioListener{
	private DefaultTimer dt;
	private TuioClient client;
	private JFrame frame;
	private Desafio2 panel;
	private int puntosO=0, puntosV=0;
	private int termine=120;
	private int tiempoTotalV, tiempoTotalO;
	private boolean terminoO=false, terminoV=false;
	private int progresoO=1, progresoV=1;
	private Puntaje pts;
	
	private ListaProductos frutaVerduras = new ListaProductos();
	private Producto frutaVerdura;
	
	private ListaPersonajes personajesO = new ListaPersonajes();
  //private ListaPersonajes personajesV = new ListaPersonajes();
	private Personaje personajeO/*, personajeV*/;


	//Agregar lista de comidas

	public ListenerD2(TuioClient client, Puntaje p) {
		pts = p;
    	this.client = client;
    	frame = new JFrame("Desafio 2");
        frame.setSize(1024, 768);
        //frame.setContentPane(new Desafio1(frame.getHeight(), frame.getWidth()));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new Desafio2(frame.getHeight(), frame.getWidth());
        personajeO = personajesO.getPersonaje(0);
        panel.paintImgO(personajeO.getPath());
      //personajeV = personajesV.getPersonaje(1);
      //panel.paintImgV(personajeV.getPath());
        frutaVerdura = frutaVerduras.getProducto(3);
        panel.paintC1(frutaVerdura.getPath());
        frame.add(panel); 
    }
	
	
	@Override
	public void addTuioBlob(TuioBlob arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTuioCursor(TuioCursor tc) {
		
		if(termine==0 && tc.getY()>0.5) {
			pts.aumentarEquipoO(puntosO);
			pts.aumentarEquipoV(puntosV);
			client.removeTuioListener(this);
			frame.dispose();
			client.addTuioListener(new ListenerRD2(client,pts, tiempoTotalO, tiempoTotalV));			
		}
		if (tc.getY()<0.3 && !terminoV) {
			/*if (progresoV<3) {
				personajeV = personajesV.getPersonaje(1);
		        panel.paintImgV(personajeV.getPath());
			progresoV++;
			}
			if (progresoV<3) {
				personajeO = personajesO.getPersonaje(1);
		        panel.paintImgO(personajeO.getPath());
			progresoV++;
			}*/
		}
		else if (tc.getY()>0.3) {
			if (progresoO<3) {
				personajeO = personajesO.getPersonaje(0);
		        panel.reubicarImgO(personajeO.getPath(),tc.getX(),frame.getHeight(), frame.getWidth());
			}
			//frutaVerdura = frutaVerduras.getProducto(3);
			//panel.evaluarCaida1(frutaVerdura.getPath(),frame.getHeight(), frame.getWidth());
		}
		/*termine = panel.getTotalTimer();
		if (termine == 0 ) {
			panel.termine();
			panel.continuar();
		}*/
	}
	
	public void evaluarO(JLabel label, List<Integer> ets, List<Integer> etiquetas) {
		label.setOpaque(true);
		int ok = 1;
		if(ok==etiquetas.size()) {
			label.setBackground(Color.green);
			puntosO+=3;
		}
		else {
			if(ok>0) {
				label.setBackground(Color.yellow);
				puntosO++;
			}
			else {
				label.setBackground(Color.red);
			}
		}
	}
	
	public void evaluarV(JLabel label, List<Integer> ets, List<Integer> etiquetas) {
		label.setOpaque(true);
		int ok = 1;
		if(ok==etiquetas.size()) {
			label.setBackground(Color.green);
			puntosV+=3;
		}
		else {
			if(ok>0) {
				label.setBackground(Color.yellow);
				puntosV++;
			}
			else {
				label.setBackground(Color.red);
			}
		}
	}
	
	/*int anchoBarra = frame.getWidth() / 8;
	int altoImg = frame.getHeight()/2;
	int anchoImg = (frame.getWidth()-anchoBarra*2)/2;*/

	@Override
	public void addTuioObject(TuioObject to) {
		
	}  //corregir, compltar

	@Override
	public void refresh(TuioTime arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTuioBlob(TuioBlob arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTuioCursor(TuioCursor arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTuioObject(TuioObject to) {

	} //corregir

	@Override
	public void updateTuioBlob(TuioBlob arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTuioCursor(TuioCursor arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTuioObject(TuioObject arg0) {
		// TODO Auto-generated method stub
		
	}

}
