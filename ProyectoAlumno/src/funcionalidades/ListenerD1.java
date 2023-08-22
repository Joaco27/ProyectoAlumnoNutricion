package funcionalidades;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	private boolean congeladoO=false, congeladoV=false;
	private int terminaron=0;
	private int tiempoTotalV, tiempoTotalO;
	private boolean terminoO=false, terminoV=false;
	private int progresoO=1, progresoV=1;
	private Puntaje pts;
	
	private String [][] etiquetas;

	private Sonido sonido;
	// Listado de todas las etiquetas
	private ListaEtiquetas etiquetasTotales = new ListaEtiquetas();
	
	// Estructuras para guardar etiquetas colocadas de cada equipo
	private List<Integer> etiquetasO = new ArrayList<Integer>();
	private List<Integer> etiquetasV = new ArrayList<Integer>();
	
	// Lista de productos para cada equipo
	private ListaProductos listaProductos = new ListaProductos();
	
	// Lista de aciertos para cada equipo
	private List<Integer> listaAciertosO = new ArrayList<Integer>();
	private List<Integer> listaAciertosV = new ArrayList<Integer>();
	
	// Producto actual de cada equipo
	private Producto productoO, productoV;
	
	// Panel de fondo
	private FondoD1 fondo; 
	
	// Panel de sombreado
	private Sombreado somb;


	public ListenerD1(TuioClient client, Puntaje p) {
		
		sonido = new Sonido();
		sonido.escucharFondo();
		// Reseteo los puntos
		pts = p;
		pts.resetear();
    	this.client = client;
    	// Creo el frame (faltaria centrarlo en pantalla)
    	frame = new JFrame("Desafio 1");
    	//frame.setUndecorated(true);
        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Quitar la barra superior de cierre y minimizar
        //frame.setUndecorated(true);

        // Establecer el estado del JFrame a pantalla completa
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        // Creo panel Fondo
        fondo = new FondoD1(frame.getWidth(), frame.getHeight());
        fondo.setOpaque(true);
        fondo.setBounds(0,0, frame.getWidth(), frame.getHeight());
        fondo.setBackground(Color.gray);
        
        // Creo y agrego panel Sombreado
        somb = new Sombreado();
        frame.add(somb);
        frame.setVisible(true);
        
        // Creo panel Desafio1 y muestro las imagenes iniciales
        panel = new Desafio1(frame.getHeight(), frame.getWidth(), this, fondo);
        productoO = listaProductos.getProducto();
        panel.paintImgO(productoO.getPath());
        productoV = listaProductos.getProducto();
        panel.paintImgV(productoV.getPath());
        
        // Agrego los paneles
        frame.add(panel);
        frame.setVisible(true);
        frame.add(fondo);
        frame.setVisible(true);

    }

	 
	
	@Override
	public void addTuioBlob(TuioBlob arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTuioCursor(TuioCursor tc) {
		somb.addCursor(tc);
        somb.repaint();
        // Si terminaron los dos finaliza el juego y si se presiona una vez mas muestra resultados
		if(terminaron==4 && tc.getY()>0.8) {
			this.fin(true);	
		}
		else {
			if(terminoO && !congeladoO && tc.getX()<0.5 && tc.getY()>0.8) {
				terminaron++;
				panel.terminoJO();
				this.congeladoO=true;
			}
			if(terminoV && !congeladoV && tc.getX()>0.5 && tc.getY()>0.8) {
				terminaron++;
				panel.terminoJV();
				this.congeladoV=true;
			}
		}
		// Si presiono del lado del equipo violeta y no termino
		if (tc.getX()>0.5 && tc.getY()>0.8 && !terminoV) {
			// Si mi mi click es impar muestro etiquetas, si es par cambio la imagen
			if (progresoV%2!=0 && progresoV<9) {
				sonido.escucharEnviar();
				// Me traigo la porcion del fondo que voy a pintar
				JLabel label = panel.getPEquipoV();
				// Si el tama�o la lista de etiquetas del producto es 0, evaluo el producto como
				// sin etiquetas
				// sino evaluo cuantas etiquetas acerto
				if(productoV.getEtiquetas().size()==0) {
					this.evaluarBlancoV(label, etiquetasV);
					this.cargarAciertos(etiquetasV, productoV.getEtiquetas(), listaAciertosV);
					somb.sombrearV(listaAciertosV);
				}
				else {
					this.evaluarV(label, etiquetasV, productoV.getEtiquetas());
					this.cargarAciertos(etiquetasV, productoV.getEtiquetas(), listaAciertosV);
					somb.sombrearV(listaAciertosV);
				}
				// Muestro las etiquetas correspondientes y remuevo la imagen
				this.mostrarEtiquetasV(panel.getEtiquetasV());
				this.panel.getContadorCorazonesV().setText(this.puntosV+"X");
				frame.repaint();
				//panel.removeImgV();
			}
			else {
				if(progresoV%2==0) {
					// Como el click es par limpio las etiquetas y muestro otra imagen
					panel.blanquearEtsV();
					this.listaAciertosV = new ArrayList<Integer>();
					somb.setEvaluarV(false);
					productoV = listaProductos.getProducto();
			        panel.paintImgV(productoV.getPath());
					
				}
				else {
					sonido.escucharEnviar();
					// Si es el noveno click evaluo una ultima vez y me guardo el tiempo
					JLabel label = panel.getPEquipoV();
					if(productoV.getEtiquetas().size()==0) {
						this.evaluarBlancoV(label, etiquetasV);
						this.cargarAciertos(etiquetasV, productoV.getEtiquetas(), listaAciertosV);
						somb.sombrearV(listaAciertosV);
					}
					else {
						this.evaluarV(label, etiquetasV, productoV.getEtiquetas());
						this.cargarAciertos(etiquetasV, productoV.getEtiquetas(), listaAciertosV);
						somb.sombrearV(listaAciertosV);
					}
					this.mostrarEtiquetasV(panel.getEtiquetasV());
					this.panel.getContadorCorazonesV().setText(this.puntosV+"X");
					tiempoTotalV = panel.terminoV(puntosV);
					terminoV=true;
					terminaron++;
					panel.sigImgV();
					frame.repaint();
				}
			}
			progresoV++;

		}
		else {
		
			if (tc.getX()<0.5 && tc.getY()>0.8 && !terminoO) {
				if (progresoO%2!=0 && progresoO<9) {
					sonido.escucharEnviar();
					JLabel label = panel.getPEquipoO();
					if(productoO.getEtiquetas().size()==0) {
						this.evaluarBlancoO(label, etiquetasO);
						this.cargarAciertos(etiquetasO, productoO.getEtiquetas(), listaAciertosO);
						somb.sombrearO(listaAciertosO);
					}
					else {
						this.evaluarO(label, etiquetasO, productoO.getEtiquetas());
						this.cargarAciertos(etiquetasO, productoO.getEtiquetas(), listaAciertosO);
						somb.sombrearO(listaAciertosO);
					}
					this.mostrarEtiquetasO(panel.getEtiquetasO());
					this.panel.getContadorCorazonesO().setText(this.puntosO+"X");
					frame.repaint();
					//panel.removeImgO();
				}
				else {
					if(progresoO%2==0) {
						this.listaAciertosO = new ArrayList<Integer>();
						somb.setEvaluarO(false);
						panel.blanquearEtsO();
						productoO = listaProductos.getProducto();
				        panel.paintImgO(productoO.getPath());
						
					}
					else {
						sonido.escucharEnviar();
						JLabel label = panel.getPEquipoO();
						if(productoO.getEtiquetas().size()==0) {
							this.evaluarBlancoO(label, etiquetasO);
							this.cargarAciertos(etiquetasO, productoO.getEtiquetas(), listaAciertosO);
							somb.sombrearO(listaAciertosO);
						}
						else {
							this.evaluarO(label, etiquetasO, productoO.getEtiquetas());
							this.cargarAciertos(etiquetasO, productoO.getEtiquetas(), listaAciertosO);
							somb.sombrearO(listaAciertosO);
						}
						this.mostrarEtiquetasO(panel.getEtiquetasO());
						this.panel.getContadorCorazonesO().setText(this.puntosO+"X");
						tiempoTotalO = panel.terminoO(puntosO);
						terminoO=true;
						terminaron++;
						panel.sigImgO();
						frame.repaint();
					}
				}
				progresoO++;
			}
		
		// Si los dos terminaron detengo el timer y muestro boton de continuar
		if(terminaron==4) {
			panel.termine();
			panel.continuar();			
		}
	}
	}
	
	public void fin(boolean ok) {
		// Finalizado el juego o el tiempo, sumo los puntos de los equipos, cierro el frame
		// y activo listener del resultado de Desafio1
		if (!terminoO) {
			tiempoTotalO = 300;
		}
		if (!terminoV) {
			tiempoTotalV = 300;
		}
		pts.aumentarEquipoO(puntosO);
		pts.aumentarEquipoV(puntosV);
		client.removeTuioListener(this);
		frame.dispose();
		client.addTuioListener(new ListenerRD1(client,pts, tiempoTotalO, tiempoTotalV, sonido));
	}
	
	public int contarElementosCompartidos(List<Integer> ets, List<Integer> etiquetas) {
        // Cuenta cantidad de etiquetas colocadas compartidas con la lista de todas 
		// las etiquetas del producto
		int contador = 0;

        for (int i = 0; i < ets.size(); i++) {
            if (etiquetas.contains(ets.get(i))) {
                contador++;
            }
        }

        return contador;
    }
	
	public void cargarAciertos(List<Integer> ets, List<Integer> etiquetas, List<Integer> aciertos) {
        // Cargo las etiquetas colocadas acertadas

        for (int i = 0; i < ets.size(); i++) {
            if (etiquetas.contains(ets.get(i))) {
            	aciertos.add(ets.get(i));
            }
        }
    }
	
	public void evaluarO(JLabel label, List<Integer> ets, List<Integer> etiquetas) {
		// Si el tama�o de la lista de etiquetas colocadas es igual al de las etiquetas del
		// producto acierta, sino si al menos hay un elemento en comun es incompleto
		// y si no tiene elementos en comun es fallo
		int ok = contarElementosCompartidos(ets, etiquetas);
		label.setOpaque(true);
		if(ok==etiquetas.size() && etiquetas.size()==ets.size()) {
			fondo.tresCorazones(label);
			puntosO+=3;
		}
		else {
			if(ok>0) {
				fondo.unCorazon(label);
				puntosO++;
			}
			else {
				label.setBackground(new Color(180,180,180));
			}
		}
		frame.repaint();
	}
	
	public void evaluarV(JLabel label, List<Integer> ets, List<Integer> etiquetas) {
		// Si el tama�o de la lista de etiquetas colocadas es igual al de las etiquetas del
		// producto acierta, sino si al menos hay un elemento en comun es incompleto
		// y si no tiene elementos en comun es fallo
		label.setOpaque(true);
		int ok = contarElementosCompartidos(ets, etiquetas);
		if(ok==etiquetas.size() && etiquetas.size()==ets.size()) {
			fondo.tresCorazones(label);
			puntosV+=3;
		}
		else {
			if(ok>0) {
				fondo.unCorazon(label);
				puntosV++;
			}
			else {
				label.setBackground(new Color(180,180,180));
			}
		}
		frame.repaint();
	}
	
	public void evaluarBlancoV(JLabel label, List<Integer> ets) {
		// Si el producto no tiene etiquetas, chequeo la lista de elementos colocados,
		// si no hay ninguno es acierto y sino es fallo
		label.setOpaque(true);
		if (ets.size()==0) {
			fondo.tresCorazones(label);
			puntosV+=3;
		}
		else {
			label.setBackground(new Color(180,180,180));
		}
		frame.repaint();

	}
	
	public void evaluarBlancoO(JLabel label, List<Integer> ets) {
		// Si el producto no tiene etiquetas, chequeo la lista de elementos colocados,
		// si no hay ninguno es acierto y sino es fallo
		label.setOpaque(true);
		if (ets.size()==0) {
			fondo.tresCorazones(label);
			puntosO+=3;
		}
		else {
			label.setBackground(new Color(180,180,180));
		}
		frame.repaint();
	}
	
	public void mostrarEtiquetasO(JLabel [] ets) {
		// Si el producto no tiene etiquetas se muestra en pantalla que no tiene
		// sino muestra las etiquetas correspondientes
		if(productoO.getEtiquetas().size()==0) {
			panel.libreSellosO();
		}
		else {
			for(int i=0;i<productoO.getEtiquetas().size();i++) {

				if(this.listaAciertosO.contains(productoO.getEtiquetas().get(i))) {
					if(productoO.getEtiquetas().get(i)<117) {
						Icon img = new ImageIcon(
								new ImageIcon(getClass().getResource(etiquetasTotales.getLista().get(productoO.getEtiquetas()
										.get(i)-112)+"OK.png")).getImage()
										.getScaledInstance(ets[i].getWidth(), ets[i].getHeight(), 0));
						
						ets[i].setIcon(img);
					}
					else {
						Icon img = new ImageIcon(
								new ImageIcon(getClass().getResource(etiquetasTotales.getLista().get(productoO.getEtiquetas()
										.get(i)-112)+"OK.png")).getImage()
										.getScaledInstance(ets[productoO.getEtiquetas().get(i)-112].getWidth(), ets[productoO.getEtiquetas().get(i)-112].getHeight(), 0));
						
						ets[productoO.getEtiquetas().get(i)-112].setIcon(img);
					}
					
				}
				else {
					if(productoO.getEtiquetas().get(i)<117) {
						Icon img = new ImageIcon(
								new ImageIcon(getClass().getResource(etiquetasTotales.getLista().get(productoO.getEtiquetas()
										.get(i)-112)+"ERROR.png")).getImage()
										.getScaledInstance(ets[i].getWidth(), ets[i].getHeight(), 0));
						
						ets[i].setIcon(img);
					}
					else {
						Icon img = new ImageIcon(
								new ImageIcon(getClass().getResource(etiquetasTotales.getLista().get(productoO.getEtiquetas()
										.get(i)-112)+"ERROR.png")).getImage()
										.getScaledInstance(ets[productoO.getEtiquetas().get(i)-112].getWidth(), ets[productoO.getEtiquetas().get(i)-112].getHeight(), 0));
						
						ets[productoO.getEtiquetas().get(i)-112].setIcon(img);
					}
				}
			}
		}
	}
	
	public void mostrarEtiquetasV(JLabel [] ets) {
		// Si el producto no tiene etiquetas se muestra en pantalla que no tiene
		// sino muestra las etiquetas correspondientes
		if(productoV.getEtiquetas().size()==0) {
			panel.libreSellosV();
		}
		else {
			for(int i=0;i<productoV.getEtiquetas().size();i++) {
				
				if(this.listaAciertosV.contains(productoV.getEtiquetas().get(i))) {
					if(productoV.getEtiquetas().get(i)<117) {
						Icon img = new ImageIcon(
								new ImageIcon(getClass().getResource(etiquetasTotales.getLista().get(productoV.getEtiquetas()
										.get(i)-112)+"OK.png")).getImage().getScaledInstance(ets[i].getWidth(), ets[i].getHeight(), 0));
						ets[i].setIcon(img);
					}
					else {
						Icon img = new ImageIcon(
								new ImageIcon(getClass().getResource(etiquetasTotales.getLista().get(productoV.getEtiquetas()
										.get(i)-112)+"OK.png")).getImage().getScaledInstance(ets[productoV.getEtiquetas().get(i)-112].getWidth(), ets[productoV.getEtiquetas().get(i)-112].getHeight(), 0));
						ets[productoV.getEtiquetas().get(i)-112].setIcon(img);
					}
				}
				else {
					if(productoV.getEtiquetas().get(i)<117) {
						Icon img = new ImageIcon(
								new ImageIcon(getClass().getResource(etiquetasTotales.getLista().get(productoV.getEtiquetas()
										.get(i)-112)+"ERROR.png")).getImage().getScaledInstance(ets[i].getWidth(), ets[i].getHeight(), 0));
						ets[i].setIcon(img);
					}
					else {
						Icon img = new ImageIcon(
								new ImageIcon(getClass().getResource(etiquetasTotales.getLista().get(productoV.getEtiquetas()
										.get(i)-112)+"ERROR.png")).getImage().getScaledInstance(ets[productoV.getEtiquetas().get(i)-112].getWidth(), ets[productoV.getEtiquetas().get(i)-112].getHeight(), 0));
						ets[productoV.getEtiquetas().get(i)-112].setIcon(img);
					}
									
					}
			}
		}
		
	}
	

	@Override
	public void addTuioObject(TuioObject to) {
		// Si coloco un objeto me fijo que tenga id valido
		// si lo tiene me fijo en que parte de la pantalla se coloco para agregarlo al equipo
		// correspondiente, ademas chequeo que no se repita el elemento
		
		System.out.println("X " + to.getX());
		int nro = to.getSymbolID()/*+ 102*/;
		
		if (nro<119 && nro>111) {
			if (to.getX()>0.47) {
				if (!this.etiquetasV.contains(nro)) {
					System.out.println("V +"+nro);
					this.etiquetasV.add(nro);
					somb.addObjectV(to);
			        somb.repaint();

				}
			}
			else {
				if(to.getX()<0.4) {
					if (!this.etiquetasO.contains(nro)) { 
						System.out.println("O +"+nro);
						this.etiquetasO.add(nro);
						somb.addObjectO(to);
				        somb.repaint();
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
		somb.removeCursor(tc);
        somb.repaint();
	}

	@Override
	public void removeTuioObject(TuioObject to) {
		// Si saco un objeto me fijo que tenga id valido
		// si lo tiene me fijo en que parte de la pantalla se coloco para sacarlo del equipo
		// correspondiente, ademas chequeo que se encuentre en la lista de etiquetas
		
		int nro = to.getSymbolID()/*+ 102*/;
		
		if(nro<119 && nro>111) {
			if (to.getX()>=0.5) {
				if (this.etiquetasV.contains(nro)) {
					System.out.println("V -"+nro);
					int i = this.etiquetasV.indexOf(nro);
					this.removerObjV(i, nro, to);
				}
				else {
					int i = this.etiquetasO.indexOf(nro);
					if(i != -1) {
						System.out.println("O -"+nro);
						this.removerObjO(i, nro, to);
					}
				}
				
			}
			else {
				if (to.getX()<0.5) {
					if(this.etiquetasO.contains(nro)) {
						System.out.println("O -"+nro);
						int i = this.etiquetasO.indexOf(nro);
						this.removerObjO(i, nro, to);
						}
				
					else {
						int i = this.etiquetasV.indexOf(nro);
						if (i != -1) {
							System.out.println("V -"+nro);
							this.removerObjV(i, nro, to);
						}
					
				}
				
				
			}
		}
		
	}
	}
	
	public void removerObjO(int pos, int id, TuioObject to) {
		TuioObject tuio = somb.getEquipoO().stream().filter(t -> t.getSymbolID()/*+ 102*/==id).findAny().orElse(null); 
		//if (tuio!=null) {
			System.out.println("Guardado X,Y: "+tuio.getX()+", "+tuio.getY());
			System.out.println("A Eliminar X,Y: "+to.getX()+", "+to.getY());
			if(tuio.getX()==to.getX() && tuio.getY()>=to.getY()) {
					this.etiquetasO.remove(pos);
					somb.removeObjectO(to);
					somb.repaint();
				}
			//}
	}
	
	public void removerObjV(int pos, int id, TuioObject to) {
		TuioObject tuio = somb.getEquipoV().stream().filter(t -> t.getSymbolID()/*+ 102*/==id).findAny().orElse(null);
		//if (tuio!=null) {
			System.out.println("Guardado X,Y: "+tuio.getX()+", "+tuio.getY());
			System.out.println("A Eliminar X,Y: "+to.getX()+", "+to.getY());
			if(tuio.getX()==to.getX() && tuio.getY()>=to.getY()) {
					this.etiquetasV.remove(pos);
					somb.removeObjectV(to);
					somb.repaint();
				}
			//}
	}
	

	@Override
	public void updateTuioBlob(TuioBlob arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTuioCursor(TuioCursor arg0) {
			somb.repaint();
	}

	@Override
	public void updateTuioObject(TuioObject arg0) {
			somb.repaint();
	}

}
