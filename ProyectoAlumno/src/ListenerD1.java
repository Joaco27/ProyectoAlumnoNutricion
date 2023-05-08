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

public class ListenerD1 extends JPanel implements TuioListener{
	private TuioClient client;
	private JFrame frame;
	private Desafio1 panel;
	private int puntosO=0, puntosV=0;
	private int terminaron=0;
	private int tiempoTotalV, tiempoTotalO;
	private boolean terminoO=false, terminoV=false;
	private int progresoO=1, progresoV=1;
	private Puntaje pts;
	
	private List<Integer> etiquetasO = new ArrayList<Integer>();
	private List<Integer> etiquetasV = new ArrayList<Integer>();
	
	private List <Producto> productosO = new ListaProductos().getLista();
	private List <Producto> productosV = new ListaProductos().getLista();


	//Agregar lista de comidas

	public ListenerD1(TuioClient client, Puntaje p) {
		pts = p;
    	this.client = client;
    	frame = new JFrame("Desafio 1");
        frame.setSize(1024, 768);
        //frame.setContentPane(new Desafio1(frame.getHeight(), frame.getWidth()));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new Desafio1(frame.getHeight(), frame.getWidth());
        frame.add(panel); 
    }
	
	
	@Override
	public void addTuioBlob(TuioBlob arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTuioCursor(TuioCursor tc) {
		
		// Si presiona el cursor en la mitad inferior de la pantalla y la parte derecha simula confirmacion del equipo
		// violeta, de lo contrario por la izquierda el naranja
		if (tc.getX()>0.5 && tc.getY()>0.5 && !terminoV) {
			// Traigo el progreso actual del equipo Violeta, si es null es porque termino
			JLabel label = panel.getPEquipoV();
			if (progresoV<5) {
				this.evaluarV(label);
			}
			if(progresoV==5) {
				//Indico que termino el equipo Violeta y le paso los puntos, y me traigo tiempo total transcurrido
				this.evaluarV(label);
				tiempoTotalV = panel.terminoV(puntosV);
				terminoV=true;
				terminaron++;
			}
			progresoV++;

		}
		else {
			//Se repite lo mismo que el anterior pero con el equipo naranja
			if (tc.getX()<0.5 && tc.getY()>0.5 && !terminoO) {
				JLabel label = panel.getPEquipoO();
				if (progresoO<5) {
						this.evaluarO(label);		
				}
			    if(progresoO==5)  {
			    	this.evaluarO(label);
					tiempoTotalO = panel.terminoO(puntosO);
					terminoO=true;
					terminaron++;
				}
				progresoO++;
			}
		}
		if(terminaron==2) {
			pts.aumentarEquipoO(puntosO);
			pts.aumentarEquipoV(puntosV);
			client.removeTuioListener(this);
			frame.dispose();
			client.addTuioListener(new ListenerRD1(client,pts, tiempoTotalO, tiempoTotalV));			
			}
	}
	
	public void evaluarO(JLabel label) {
		Random rd = new Random();
		label.setOpaque(true);
		int ok = rd.nextInt(3);
		if(ok==2) {
			label.setBackground(Color.green);
			puntosO+=3;
		}
		else {
			if(ok==1) {
				label.setBackground(Color.yellow);
				puntosO++;
			}
			else {
				label.setBackground(Color.red);
			}
		}
	}
	
	public void evaluarV(JLabel label) {
		// Genero un random: 0 error (0 pts), 1 incompleto (1 pt), 2 correcto (3 pts)
		Random rd = new Random();
		label.setOpaque(true);
		int ok = rd.nextInt(3);
		if(ok==2) {
			//Sumo 3 pts y pongo progreso en verde
			label.setBackground(Color.green);
			puntosV+=3;
		}
		else {
			if(ok==1) {
				//Sumo 1 pt y pongo progreso en amarillo
				label.setBackground(Color.yellow);
				puntosV++;
			}
			else {
				//Pongo progreso en rojo
				label.setBackground(Color.red);
			}
		}
	}

	@Override
	public void addTuioObject(TuioObject arg0) {
		// TODO Auto-generated method stub
		
	}

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
		if (to.getX()>0.5) {
			this.etiquetasV.add(to.getSymbolID());
		}
		else {
			this.etiquetasO.add(to.getSymbolID());
		}
	}

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
