import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.*;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
	
	private ArrayList<TuioObject> objects = new ArrayList<TuioObject>();
    private ArrayList<TuioCursor> cursors = new ArrayList<TuioCursor>();
	
	private ListaEtiquetas etiquetasTotales = new ListaEtiquetas();
	
	private List<Integer> etiquetasO = new ArrayList<Integer>();
	private List<Integer> etiquetasV = new ArrayList<Integer>();
	
	private ListaProductos productosO = new ListaProductos();
	private ListaProductos productosV = new ListaProductos();
	
	private Producto productoO, productoV;
	
	private FondoD1 fondo; 


	//Agregar lista de comidas

	public ListenerD1(TuioClient client, Puntaje p) {
		pts = p;
    	this.client = client;
    	frame = new JFrame("Desafio 1");
        frame.setSize(1024, 768);
        //frame.setContentPane(new Desafio1(frame.getHeight(), frame.getWidth()));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setBackground(new Color(0,0,0,0));
        
        fondo = new FondoD1(frame.getWidth(), frame.getHeight());
        fondo.setOpaque(true);
        //panelFondo.setBackground(new Color(0,0,0,0));
        fondo.setBounds(0,0, frame.getWidth(), frame.getHeight());
        fondo.setBackground(Color.gray);
        //fondo.setLayout(null);
        
        panel = new Desafio1(frame.getHeight(), frame.getWidth(), this, fondo);
        productoO = productosO.getProducto();
        panel.paintImgO(productoO.getPath());
        productoV = productosV.getProducto();
        panel.paintImgV(productoV.getPath());
        frame.add(panel);
        frame.setVisible(true);
        frame.add(fondo);
        //frame.add(this);
        frame.setVisible(true);

    }
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (TuioObject tuioObject : objects) {
            int x = (int) (tuioObject.getScreenX(this.getWidth()) - 50 / 2);
            int y = (int) (tuioObject.getScreenY(this.getHeight()) - 50 / 2);
            int width = 50;
            int height = 50;
            g2d.setColor(new Color(0, 0, 0, 50));
            g2d.fillOval(x, y, width, height);
        } 
        for (TuioCursor tuioC : cursors) {
            int x = (int) (tuioC.getScreenX(this.getWidth()) - 50 / 2);
            int y = (int) (tuioC.getScreenY(this.getHeight()) - 50 / 2);
            int width = 50;
            int height = 50;
            g2d.setColor(new Color(0, 0, 0, 50));
            g2d.fillOval(x, y, width, height);
        }
        
        
    }
	
	
	@Override
	public void addTuioBlob(TuioBlob arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTuioCursor(TuioCursor tc) {
		cursors.add(tc);
        this.repaint();
		if(terminaron==2 && tc.getY()>0.5) {
			this.fin(true);	
		}
		if (tc.getX()>0.5 && tc.getY()>0.5 && !terminoV) {
			if (progresoV%2!=0 && progresoV<9) {
				JLabel label = panel.getPEquipoV();
				if(productoV.getEtiquetas().size()==0) {
					this.evaluarBlancoV(label, etiquetasV);
				}
				else {
					this.evaluarV(label, etiquetasV, productoV.getEtiquetas());
				}
				this.mostrarEtiquetasV(panel.getEtiquetasV());
				panel.removeImgV();
			}
			else {
				if(progresoV%2==0) {
					panel.blanquearEtsV();
					productoV = productosV.getProducto();
			        panel.paintImgV(productoV.getPath());
					
				}
				else {
					JLabel label = panel.getPEquipoV();
					if(productoV.getEtiquetas().size()==0) {
						this.evaluarBlancoV(label, etiquetasV);
					}
					else {
						this.evaluarV(label, etiquetasV, productoV.getEtiquetas());
					}
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
					if(productoO.getEtiquetas().size()==0) {
						this.evaluarBlancoO(label, etiquetasO);
					}
					else {
						this.evaluarO(label, etiquetasO, productoO.getEtiquetas());
					}
					this.mostrarEtiquetasO(panel.getEtiquetasO());
					panel.removeImgO();
				}
				else {
					if(progresoO%2==0) {
						panel.blanquearEtsO();
						productoO = productosO.getProducto();
				        panel.paintImgO(productoO.getPath());
						
					}
					else {
						JLabel label = panel.getPEquipoO();
						if(productoO.getEtiquetas().size()==0) {
							this.evaluarBlancoO(label, etiquetasO);
						}
						else {
							this.evaluarO(label, etiquetasO, productoO.getEtiquetas());
						}
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
	
	public void fin(boolean ok) {
		if(!ok) {
			tiempoTotalO=0;
			tiempoTotalV=0;
		}
		pts.aumentarEquipoO(puntosO);
		pts.aumentarEquipoV(puntosV);
		client.removeTuioListener(this);
		frame.dispose();
		client.addTuioListener(new ListenerRD1(client,pts, tiempoTotalO, tiempoTotalV));
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
		//label.setOpaque(true);
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
		frame.repaint();
	}
	
	public void evaluarV(JLabel label, List<Integer> ets, List<Integer> etiquetas) {
		//label.setOpaque(true);
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
		frame.repaint();
	}
	
	public void evaluarBlancoV(JLabel label, List<Integer> ets) {
		label.setOpaque(true);
		if (ets.size()>0) {
			label.setBackground(Color.red);
		}
		else {
			label.setBackground(Color.green);
			puntosV+=3;
		}
		frame.repaint();

	}
	
	public void evaluarBlancoO(JLabel label, List<Integer> ets) {
		label.setOpaque(true);
		if (ets.size()>0) {
			label.setBackground(Color.red);
		}
		else {
			label.setBackground(Color.green);
			puntosO+=3;
		}
		frame.repaint();
	}
	
	public void mostrarEtiquetasO(JLabel [] ets) {
		if(productoO.getEtiquetas().size()==0) {
			panel.getSinEtiquetasO().setText("No Tiene Etiquetas");
			panel.getSinEtiquetasO().setOpaque(true);
		}
		else {
			for(int i=0;i<productoO.getEtiquetas().size();i++) {
				ets[i].setText(etiquetasTotales.getLista().get(productoO.getEtiquetas().get(i)));
				ets[i].setOpaque(true);
				ets[i].setBackground(Color.black);
			}
		}
	}
	
	public void mostrarEtiquetasV(JLabel [] ets) {
		if(productoV.getEtiquetas().size()==0) {
			panel.getSinEtiquetasV().setText("No Tiene Etiquetas");
			panel.getSinEtiquetasV().setOpaque(true);
		}
		else {
			for(int i=0;i<productoV.getEtiquetas().size();i++) {
				ets[i].setText(etiquetasTotales.getLista().get(productoV.getEtiquetas().get(i)));
				ets[i].setOpaque(true);
				ets[i].setBackground(Color.black);
			}
		}
		
	}
	

	@Override
	public void addTuioObject(TuioObject to) {
		objects.add(to);
        this.repaint();
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
	public void removeTuioCursor(TuioCursor tc) {
		cursors.remove(tc);
        this.repaint();
	}

	@Override
	public void removeTuioObject(TuioObject to) {
		objects.add(to);
        this.repaint();
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
			this.repaint();
	}

	@Override
	public void updateTuioObject(TuioObject arg0) {
			this.repaint();
	}

}
