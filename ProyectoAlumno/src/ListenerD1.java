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
	
	private ListaEtiquetas etiquetasTotales = new ListaEtiquetas();
	
	private List<Integer> etiquetasO = new ArrayList<Integer>();
	private List<Integer> etiquetasV = new ArrayList<Integer>();
	
	private ListaProductos productosO = new ListaProductos();
	private ListaProductos productosV = new ListaProductos();
	
	private Producto productoO, productoV;


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
        productoO = productosO.getProducto();
        panel.paintImgO(productoO.getPath());
        productoV = productosV.getProducto();
        panel.paintImgV(productoV.getPath());
        frame.add(panel); 
    }
	
	
	@Override
	public void addTuioBlob(TuioBlob arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTuioCursor(TuioCursor tc) {
		if(terminaron==2 && tc.getY()>0.5) {
			pts.aumentarEquipoO(puntosO);
			pts.aumentarEquipoV(puntosV);
			client.removeTuioListener(this);
			frame.dispose();
			client.addTuioListener(new ListenerRD1(client,pts, tiempoTotalO, tiempoTotalV));			
		}
		if (tc.getX()>0.5 && tc.getY()>0.5 && !terminoV) {
			if (progresoV%2!=0 && progresoV<9) {
				JLabel label = panel.getPEquipoV();
				this.evaluarV(label, etiquetasV, productoV.getEtiquetas());
				this.mostrarEtiquetasV(panel.getEtiquetasV());
			}
			else {
				if(progresoV%2==0) {
					panel.blanquearEtsV();
					productoV = productosV.getProducto();
			        panel.paintImgV(productoV.getPath());
					
				}
				else {
					JLabel label = panel.getPEquipoV();
					this.evaluarV(label, etiquetasV, productoO.getEtiquetas());
					this.mostrarEtiquetasV(panel.getEtiquetasV());
					tiempoTotalV = panel.terminoV(puntosV);
					terminoV=true;
					terminaron++;
				}
			}
			progresoV++;

		}
		else {
			if (tc.getX()<0.5 && tc.getY()>0.5 && !terminoO) {
				if (progresoO%2!=0 && progresoO<9) {
					JLabel label = panel.getPEquipoO();
					this.evaluarO(label, etiquetasO, productoO.getEtiquetas());
					this.mostrarEtiquetasO(panel.getEtiquetasO());
				}
				else {
					if(progresoO%2==0) {
						panel.blanquearEtsO();
						productoO = productosO.getProducto();
				        panel.paintImgO(productoO.getPath());
						
					}
					else {
						JLabel label = panel.getPEquipoO();
						this.evaluarO(label, etiquetasO, productoO.getEtiquetas());
						this.mostrarEtiquetasO(panel.getEtiquetasO());
						tiempoTotalO = panel.terminoO(puntosO);
						terminoO=true;
						terminaron++;
					}
				}
				progresoO++;
			}
		}
		if(terminaron==2) {
			panel.termine();
			panel.continuar();			
		}
	}
	
	public int contarElementosCompartidos(List<Integer> ets, List<Integer> etiquetas) {
        int contador = 0;

        for (int i = 0; i < ets.size(); i++) {
            if (etiquetas.contains(ets.get(i))) {
                contador++;
            }
        }

        return contador;
    }
	
	public void evaluarO(JLabel label, List<Integer> ets, List<Integer> etiquetas) {
		label.setOpaque(true);
		int ok = contarElementosCompartidos(ets, etiquetas);
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
		int ok = contarElementosCompartidos(ets, etiquetas);
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
	
	public void mostrarEtiquetasO(JLabel [] ets) {
		for(int i=0;i<productoO.getEtiquetas().size();i++) {
			ets[i].setText(etiquetasTotales.getLista().get(productoO.getEtiquetas().get(i)));
			ets[i].setOpaque(true);
			ets[i].setBackground(Color.black);
		}
	}
	
	public void mostrarEtiquetasV(JLabel [] ets) {
		for(int i=0;i<productoV.getEtiquetas().size();i++) {
			ets[i].setText(etiquetasTotales.getLista().get(productoV.getEtiquetas().get(i)));
			ets[i].setOpaque(true);
			ets[i].setBackground(Color.black);
		}
	}
	

	@Override
	public void addTuioObject(TuioObject to) {
		if (to.getSymbolID()<6) {
			if (to.getX()>0.5) {
				if (!this.etiquetasV.contains(to.getSymbolID())) {
					System.out.println("V +"+to.getSymbolID());
					this.etiquetasV.add(to.getSymbolID());

				}
			}
			else {
				if(to.getX()<0.5) {
					if (!this.etiquetasO.contains(to.getSymbolID())) {
						System.out.println("O +"+to.getSymbolID());
						this.etiquetasO.add(to.getSymbolID());
				}
				}
			}
		}
		
		
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
		if(to.getSymbolID()<6) {
			if (to.getX()>0.5) {
				System.out.println("V -"+to.getSymbolID());
				if (this.etiquetasV.contains(to.getSymbolID())) {
					int i = this.etiquetasV.indexOf(to.getSymbolID());
					//System.out.println(i);
					this.etiquetasV.remove(i);
				}
				
			}
			else {
				System.out.println("O -"+to.getSymbolID());
				if(this.etiquetasO.contains(to.getSymbolID())) {
					int i = this.etiquetasO.indexOf(to.getSymbolID());
					//System.out.println(i);
					this.etiquetasO.remove(i);
				}
				
			}
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
