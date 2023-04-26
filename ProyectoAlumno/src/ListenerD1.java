import java.awt.Color;
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
	private boolean pantallaBenef=false;
	private boolean terminoO=false, terminoV=false;
	//Agregar lista de comidas

	public ListenerD1(TuioClient client) {
    	this.client = client;
    	frame = new JFrame("Desafio 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        panel = new Desafio1(frame.getHeight(), frame.getWidth());
        frame.add(panel); 
        //frame.add(this);
        frame.setVisible(true);
    }
	
	
	@Override
	public void addTuioBlob(TuioBlob arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTuioCursor(TuioCursor tc) {
		// si los dos equipos terminaron informo el que gano y le sumo el beneficio
		// una vez que muestro la pantalla de beneficio vuelvo al MP
		if(terminaron==2) {
			panel.termine();
			if(!pantallaBenef) {
				JLabel winner = panel.getPPanelWin();
				if(tiempoTotalV<tiempoTotalO) {
					winner.setText("Termino primero el Violeta +5 pts");
					puntosV+=5;
				}
				else {
					if(tiempoTotalV>tiempoTotalO) {
						winner.setText("Termino primero el Naranja +5 pts");
						puntosO+=5;
					}
					else {
						winner.setText("Empate");
					}
				}
			}
			if(pantallaBenef) {
				client.removeTuioListener(this);
				frame.dispose();
				client.addTuioListener(new ListenerMP(client,puntosV,puntosO));
			}
			pantallaBenef=true;
		}
		
		// Si presiona el cursor en la mitad inferior de la pantalla y la parte derecha simula confirmacion del equipo
		// violeta, de lo contrario por la izquierda el naranja
		
		if (tc.getX()>0.5 && tc.getY()>0.5 && !terminoV) {
			// Traigo el progreso actual del equipo Violeta, si es null es porque termino
			JLabel label = panel.getPEquipoV();
			if (label != null) {
				// Genero un random: 0 error (0 pts), 1 incompleto (1 pt), 2 correcto (3 pts)
				Random rd = new Random();
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
			else {
				//Indico que termino el equipo Violeta y le paso los puntos, y me traigo tiempo total transcurrido
				tiempoTotalV = panel.terminoV(puntosV);
				terminoV=true;
				terminaron++;
			}
		}
		else {
			//Se repite lo mismo que el anterior pero con el equipo naranja
			if (tc.getX()<0.5 && tc.getY()>0.5 && !terminoO) {
				JLabel label = panel.getPEquipoO();
				if (label != null) {
					Random rd = new Random();
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
				else {
					tiempoTotalO = panel.terminoO(puntosO);
					terminoO=true;
					terminaron++;
				}
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
	public void removeTuioObject(TuioObject arg0) {
		// TODO Auto-generated method stub
		
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
