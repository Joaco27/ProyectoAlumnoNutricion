package funcionalidades;
import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.*;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import TUIO.TuioBlob;
import TUIO.TuioCursor;
import TUIO.TuioListener;
import TUIO.TuioObject;
import TUIO.TuioTime;

public class ListenerD2 extends JPanel implements TuioListener{
	private Integer contadoresFin = 0;
	private TuioClient client;
	private JFrame frame;
	private DefaultTimerD2 dtV,dtO;
	private Desafio2 panel;
	private int puntosO=0, puntosV=0;
	private int rachaO=0, rachaV=0;
	private int progresoO=1, progresoV=1;
	private Puntaje pts;	
	private int cant = 10;
	private Sonido sonido;
	
	
	private ListaCategorias carteles = new ListaCategorias();
	private Categoria [][] cartel = new Categoria[2][6];
	private ListaProductosD2 balas = new ListaProductosD2();
	private Producto [][] bala = new Producto[2][cant];    
	
	
	private ListaPersonajes personajesO = new ListaPersonajes();
    private ListaPersonajes personajesV = new ListaPersonajes();
    private ListaCargasCanion cargasV = new ListaCargasCanion();
    private ListaCargasCanion cargasO = new ListaCargasCanion();
	private Personaje personajeO, personajeV, cargaCO, cargaCV;
	
	private Integer cargaCanionV = 3, cargaCanionO = 2;


	//Agregar lista de comidas

	public ListenerD2(TuioClient client, Puntaje p) {
		
		sonido = new Sonido();
		sonido.escucharFondo();
		
		pts = p;
    	this.client = client;
    	frame = new JFrame("Desafio 2");
        frame.setSize(1024, 768);
        //frame.setContentPane(new Desafio1(frame.getHeight(), frame.getWidth()));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        
        panel = new Desafio2(frame.getHeight(), frame.getWidth(), this);
        
        
		cargaCO = cargasO.getPersonaje(cargaCanionO);
		cargaCV = cargasV.getPersonaje(cargaCanionV);
        personajeV = personajesV.getPersonaje(cargaCanionV);      
		personajeO = personajesO.getPersonaje(cargaCanionO);
		
		int pOx = (int)(Math.random() * cant);
		int pVx = (int)(Math.random() * cant);

		for (int i=0; i<4; i++) {
			while (bala[0][pOx] != null) {
				pOx++;
				if (pOx == cant) pOx = 0;
			}
			while (bala[1][pVx] != null) {
				pVx++;
				if (pVx == cant) pVx = 0;
			}
			bala[0][pOx] = balas.getProducto();
			while (bala[0][pOx].getCategoria() != panel.getCatV()) {
				bala[0][pOx] = balas.getProducto();
			}
			bala[1][pVx] = balas.getProducto();
			while (bala[1][pVx].getCategoria() != panel.getCatO()) {
				bala[1][pVx] = balas.getProducto();
			}
			pOx = (int)(Math.random() * cant);
			pVx = (int)(Math.random() * cant);
		}	
			   
        for (int i=0;i<2;i++) {
	        for (int j=0;j<10;j++) {
	        	if (bala[i][j] == null) {
	        		bala[i][j] = balas.getProducto();
	        		if (i == 0)
	        			while (bala[i][j].getCategoria() == panel.getCatV()) {
	        				bala[i][j] = balas.getProducto();
	        			}
	        		else 
	        			while (bala[i][j].getCategoria() == panel.getCatO()) {
	        				bala[i][j] = balas.getProducto();
	        			}		
	        	} 
	        	panel.paintProd(i,j,bala[i][j].getPath());
	        }
		}
        for (int j=0;j<6;j++) {
    		cartel[0][j] = carteles.getCategoria(j*2);
    		panel.paintCartel(0,j,cartel[0][j].getPath());
    		cartel[1][j] = carteles.getCategoria((j*2)+1);
    		panel.paintCartel(1,j,cartel[1][j].getPath());
    	}

        //Agrego los paneles
        frame.add(panel); 
        frame.setVisible(true);
        
		cargaCO.setX(0);
		cargaCO.setY((float)0.5);
		panel.reubicarImgO(cargaCO.getPath(),(float)0.5,frame.getHeight(), frame.getWidth());	
        cargaCV.setY((float)0.5);
        cargaCV.setX((1024 - 14)-185);
        panel.reubicarImgV(cargaCV.getPath(),(float)0.5,frame.getHeight(), frame.getWidth());
        
		personajeO.setX(0);
		personajeO.setY((float)0.5);
		panel.reubicarImgO(personajeO.getPath(),(float)0.5,frame.getHeight(), frame.getWidth());	
        personajeV.setY((float)0.5);
        personajeV.setX((1024 - 14)-185);
        panel.reubicarImgV(personajeV.getPath(),(float)0.5,frame.getHeight(), frame.getWidth());
        
       /* frame.add(fondo);
        frame.setVisible(true);*/
    }
	
	
	@Override
	public void addTuioBlob(TuioBlob arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTuioCursor(TuioCursor tc) {
		

	}
	
	public void cambioV(int i) {
		
		cargaCV = personajesV.getPersonaje(i);
        panel.paintImgV(cargaCV.getPath());
        cargaCanionV = i;
		
	}
	
	public void cambioO(int i) {
		
		cargaCO = personajesO.getPersonaje(i);
        panel.paintImgO(cargaCO.getPath());
        cargaCanionO = i;
		
	}
	
	
	public int getContadoresFin() {
		return contadoresFin;
	}
	
	public void finContador() {
		this.contadoresFin++;
		if (this.contadoresFin == 1) {
			panel.arrancarTimer();
		}	
	}
	
	//EN LUGAR DE BONO DE TIEMPO, PUEDO METER UN MULTIPLICADOR DE PTS DEPENDIENDO DE CUANTOS OBJETOS DE UNA MISMA CATEGORIA AGARR� SEGUIDOS SIN ERRAR
	//PONER MUCHOS MAS OBJETOS PARA AGARRAR, PARA Q SEA MAS FRENETICO
	
	public void fin(boolean ok) {
		// Finalizado el tiempo, cierro el frame
		// y activo listener del resultado de Desafio1
		System.out.println(puntosO+"  "+puntosV);
		pts.aumentarEquipoO(puntosO);
		pts.aumentarEquipoV(puntosV);
		client.removeTuioListener(this);
		frame.dispose();
		client.addTuioListener(new ListenerRD2(client,pts,sonido));
		
	}
	
	public void transparentar() {
	
		panel.transparentarHit(panel.getHit());
		panel.transparentarMiss(panel.getMiss());
		
	}
	
	public void transparentarCartel(int n) {
		
		if (this.contadoresFin == 0) {
			panel.transparentarCartelV(n);
		}	
		else if (this.contadoresFin == 1) {
			panel.transparentarCartelO(n);
		} 
		
	}
	
	
	public boolean balaFueraPantalla(JLabel b) {
		
		if ((this.contadoresFin == 0) && (b.getX() > 1124)) {
			return true;
		}	
		else if ((this.contadoresFin == 1) && (b.getX() < -100)) {
			return true;
		} 
		return false;
	}
	
	public void moverFueraPantalla(JLabel b) {
		
		int ancho = 1024;
		int alto = 768;
		int anchoBarra = ancho / 8;
		int altoImg = alto/2/2;
		int anchoImg = (ancho-14)/6;
		
		if (this.contadoresFin == 0) {
			b.setBounds(1134, b.getY(), anchoImg/2, altoImg/2);
		}	
		else if (this.contadoresFin == 1) {
			b.setBounds(-110, b.getY(), anchoImg/2, altoImg/2);
		} 
	}
	
	public void mostrarCartel(int n) {
		if (this.contadoresFin == 0) {
			panel.drawCatV(n);
		}	
		else if (this.contadoresFin == 1) {
			panel.drawCatO(n);
		} 
	}
	
	
	public void moverObj(JLabel b) {
		
		int ancho = 1024;
		int alto = 768;
		int anchoBarra = ancho / 8;
		int altoImg = alto/2/2;
		int anchoImg = (ancho-14)/6;
		
		if (this.contadoresFin == 0) {
			b.setBounds(b.getX() + 10, b.getY(), anchoImg/2, altoImg/2);
		}	
		else if (this.contadoresFin == 1) {
			b.setBounds(b.getX() - 10, b.getY(), anchoImg/2, altoImg/2);
		} 
	}
		
	public void lanzarObj(JLabel b) {
		
		int ancho = 1024;
		int alto = 768;
		int anchoBarra = ancho / 8;
		int altoImg = alto/2/2;
		int anchoImg = (ancho-14)/6;
    	
    //	bala[contadoresFin][i] = balas.getProducto();
    //	panel.paintProd(i,contadoresFin,bala[contadoresFin][i].getPath());
		
		if (this.contadoresFin == 0) {
			b.setBounds(2, personajeO.getY()-35, anchoImg/2, altoImg/2);
			
		}	
		else if (this.contadoresFin == 1) {	    	
			b.setBounds((1024 - 14)-185, personajeV.getY()-35, anchoImg/2, altoImg/2);
		} 
	}
	
	public boolean colision(JLabel b, int cat, int n) {
		
		boolean coli = false;	
		
		int bordeIzqB = b.getX();
	    int bordeAltoB = b.getY();
	    int bordeIzqO = panel.getPjO().getX();
	    int bordeAltoO = panel.getPjO().getY();
	    int bordeIzqV = panel.getPjV().getX() + 20;
	    int bordeAltoV = panel.getPjV().getY();
	    int widthb = b.getWidth();
	    int heightb = b.getHeight();
	    int widtho = panel.getPjO().getWidth();
	    int heighto = panel.getPjO().getHeight();
	    int widthv = panel.getPjV().getWidth();
	    int heightv = panel.getPjV().getHeight();
	    int bordeBajoV = heightv + bordeAltoV;
	    int bordeDerV = widthv + bordeIzqV;
	    int bordeDerB = widthb + bordeIzqB;
	    int bordeBajoB = heightb + bordeAltoB;
	    int bordeBajoO = heighto + bordeAltoO;
	    int bordeDerO = 145;
	    bordeAltoB = bordeAltoB + 5;
	    bordeBajoB = bordeBajoB - 5;
	    
		if (this.contadoresFin == 0) {
		    if (bordeIzqV == bordeDerB) {
		    	if ((bordeAltoB < bordeAltoV && bordeBajoB > bordeAltoV) || (bordeAltoB > bordeAltoV && bordeBajoB < bordeBajoV) || (bordeAltoB < bordeBajoV && bordeBajoB > bordeBajoV)) {
		    		coli = true;
		    		if (cat == bala[0][n].getCategoria()) {
					puntosV+= (3+rachaV) ;
		    		rachaV+=1;
		    		sonido.escucharAcierto();
		    		panel.drawHit((1024 - 14)-185,personajeV.getY()+55);
		    		panel.updateRachaV(rachaV);
		    		} else {
		    			puntosV-=1;
		    			rachaV = 0;
		    			sonido.escucharFallo();
		    			panel.drawMiss((1024 - 14)-185,personajeV.getY()+55);
		    			panel.updateRachaV(rachaV);
		    		}
		    	}
		    }
		}	
		else if (this.contadoresFin == 1) {
			if (bordeDerO == bordeIzqB) {
				if ((bordeAltoB < bordeAltoO && bordeBajoB > bordeAltoO) || (bordeAltoB > bordeAltoO && bordeBajoB < bordeBajoO) || (bordeAltoB < bordeBajoO && bordeBajoB > bordeBajoO)) {
		    		coli = true;
		    		if (cat == bala[1][n].getCategoria()) {
						puntosO+= (3+rachaO) ;
			    		rachaO+=1;
			    		sonido.escucharAcierto();
			    		panel.drawHit(0,personajeO.getY()+55);
			    		panel.updateRachaO(rachaO);
			    		} else {
			    			puntosO-=1;
			    			rachaO = 0;
			    			sonido.escucharFallo();
			    			panel.drawMiss(0,personajeO.getY()+55);
			    			panel.updateRachaO(rachaO);
			    		}
		    	}
		    }
		} 
		
		if (coli == true) {
			return true;
		}
		return false;

	}
	
	public JLabel getBala(int j) {
		if (contadoresFin == 0)
			return panel.getBalaO(j);
		return panel.getBalaV(j);
	}
	
	
	public int getSeconds() {
		if (contadoresFin == 0)
			return panel.getSecondsO();
		return panel.getSecondsV();
	}
	
	public String getNombreCat(int c) {
        
		switch (c) {
	        case 1:
	            return "Frutas";
	        case 2:
	            return "Lacteos";
	        case 3:
	            return "Legumbres";
	        case 4:
	            return "Carnes";
	        case 5:
	            return "Semillas";
	        case 6:
	            return "Procesados";
	        default:
	            return "Opción inválida";
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
	public void updateTuioCursor(TuioCursor tc) {
		// TODO Auto-generated method stub

	if ((tc.getX()>0.7) && (tc.getX()<0.94)) {
		if (progresoV<3) {
			personajeV = personajesV.getPersonaje(cargaCanionV);
	        panel.reubicarImgV(personajeV.getPath(),tc.getY(),frame.getHeight(), frame.getWidth());
	        personajeV.setY(tc.getY());
//		progresoV++;
		}
	}
	else if ((tc.getX()<0.3) && (tc.getX()>0.06)) {
		if (progresoO<3) {
			personajeO = personajesO.getPersonaje(cargaCanionO);
	        panel.reubicarImgO(personajeO.getPath(),tc.getY(),frame.getHeight(), frame.getWidth());
	        personajeO.setY(tc.getY());
		}
		
	}
	/*termine = panel.getTotalTimer();
	if (termine == 0 ) {
		panel.termine();
		panel.continuar();
	}*/
	}

	@Override
	public void updateTuioObject(TuioObject arg0) {
		// TODO Auto-generated method stub
		
	}

}
