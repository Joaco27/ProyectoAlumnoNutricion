package funcionalidades;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.Border;


public class Desafio1 extends JPanel{
	
	private JLabel [][] etiquetas = new JLabel[2][7];
	private int pActualO = 5, pActualV = 5, alto, ancho;
	private DefaultTimer dt;
	private Image img;
	private JLabel imagen1, imagen2, VR, noEts1, noEts2, sigImg1, sigImg2, contO, contV;
	private FondoD1 fondo;
	
	Border lineaBordeV = BorderFactory.createLineBorder(Color.green);
	Border lineaBordeR = BorderFactory.createLineBorder(Color.red);


	
	public Desafio1(int alto, int ancho, ListenerD1 list, FondoD1 fondo){
		this.fondo=fondo;
		this.alto=alto;
		this.ancho=ancho;
		setLayout(null);
		//System.out.println("Alto: "+alto+" Ancho: "+ancho);
		
		
		int anchoBarra = ancho / 8;
		int altoBarra = alto / 5;
		int altoImg = alto/2;
		int anchoImg = (ancho-anchoBarra*2)/2;
		
		
		int derechaImg = anchoBarra + anchoImg;
		int heightBtn = altoBarra/2;
		
		
		int derechaBarra = anchoBarra+anchoImg*2;
		
		
		dt = new DefaultTimer(list);
		dt.setOpaque(false);
		dt.setBackground(new Color(0,0,0,0));
		dt.setBounds(ancho/2-(ancho/6/2)-10, 5, ancho/6, heightBtn/2);
		add(dt);

		int anchoVR = ancho - ancho/8*2;
		VR = new JLabel("", SwingConstants.CENTER);
		VR.setOpaque(false);
		VR.setBackground(new Color(0,0,0,0));
		VR.setBounds(ancho/8, alto-135, anchoVR, heightBtn+15);
		add(VR);
		
	
		
		int anchoB = anchoBarra/4;	
		int derechaB = anchoB/4;
				
		
		int derechaET1 = anchoB*2-15;
		int abajoET = (alto/3-10)/2-25;
		int anchoET = (ancho/2-derechaET1)/5+15;
		int altoET = abajoET+65;
		
		noEts1=new JLabel("", SwingConstants.CENTER);
		noEts1.setOpaque(false);
		noEts1.setBounds(derechaET1+50, abajoET, anchoET*3, altoET/2);
		add(noEts1);
		
		for(int i=0; i<5; i++) {
			etiquetas[0][i] = new JLabel("", SwingConstants.CENTER);
			etiquetas[0][i].setOpaque(false);
			etiquetas[0][i].setBounds(derechaET1 + (anchoET+5)*i - (25*i),
					abajoET-(abajoET*((i+1) % 2))+(50*((i+1)%2)), anchoET, altoET/2);
			add(etiquetas[0][i]);
		}
		
		for(int i=0; i<2; i++) {
			etiquetas[0][i+5] = new JLabel("", SwingConstants.CENTER);
			etiquetas[0][i+5].setOpaque(false);
			etiquetas[0][i+5].setBounds(derechaET1+(anchoET+5)*i*2, abajoET+85, anchoET*2, altoET/1/3);
			add(etiquetas[0][i+5]);
		}
		
		
		int derechaET2 = ancho/2;
		
		for(int i=0; i<5; i++) {
			etiquetas[1][i] = new JLabel("", SwingConstants.CENTER);
			etiquetas[1][i].setOpaque(false);
			etiquetas[1][i].setBounds(derechaET2+(anchoET+5)*i - (25*i),
					abajoET-(abajoET*((i+1) % 2))+(50*((i+1)%2)), anchoET, altoET/2);
			add(etiquetas[1][i]);
		}
		
		for(int i=0; i<2; i++) {
			etiquetas[1][i+5] = new JLabel("", SwingConstants.CENTER);
			etiquetas[1][i+5].setOpaque(false);
			etiquetas[1][i+5].setBounds(derechaET2+(anchoET+5)*i*2, abajoET+85, anchoET*2, altoET/1/3);
			add(etiquetas[1][i+5]);
		}
		
		noEts2=new JLabel("", SwingConstants.CENTER);
		noEts2.setOpaque(false);
		noEts2.setBounds(derechaET2+75, abajoET, anchoET*3, altoET/2);
		add(noEts2);
		
		
		
		imagen1 = new JLabel("");
		imagen1.setOpaque(false);
		imagen1.setBounds(anchoBarra-anchoB-20, alto/3-10, anchoImg, altoImg);
		add(imagen1);
		
		int derechaSig=(ancho/2)/2-(ancho/6)/2+17;
		
		sigImg1 = new JLabel("", SwingConstants.CENTER);
		sigImg1.setBounds(derechaSig-5, alto-135, ancho/6+35, heightBtn+20);
		sigImg1.setOpaque(false);
		sigImg1.setBackground(new Color(0,0,0,0));
		add(sigImg1);
		
		contO = new JLabel("0X ");
		contO.setOpaque(true);
		contO.setBackground(new Color(0,0,0,0));
		contO.setFont(new Font("Monospaced", Font.PLAIN, 24));
		contO.setBounds(derechaSig-105, alto-138, ancho/16, heightBtn);
		add(contO);
		
		
		JLabel imgCO = new JLabel();
		imgCO.setBounds(derechaSig-70, alto-122, ancho/22, heightBtn-30);
		Icon imgcorO = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/unCorazon-SinFondo.png")).getImage()
				.getScaledInstance(imgCO.getWidth(), imgCO.getHeight(), 0));
		imgCO.setOpaque(true);
		imgCO.setIcon(imgcorO);
		imgCO.setBackground(new Color(0,0,0,0));
		add(imgCO);
		
		imagen2 = new JLabel("");
		imagen2.setOpaque(false);
		imagen2.setBounds(derechaImg+anchoB+20, alto/3-10, anchoImg, altoImg);
		add(imagen2);
		
		sigImg2 = new JLabel("", SwingConstants.CENTER);
		sigImg2.setBounds(derechaSig*4-75, alto-135, ancho/6+35, heightBtn+20);
		sigImg2.setOpaque(false);
		sigImg2.setBackground(new Color(0,0,0,0));
		add(sigImg2);
		
		contV = new JLabel("0X ");
		contV.setOpaque(true);
		contV.setBackground(new Color(0,0,0,0));
		contV.setFont(new Font("Monospaced", Font.PLAIN, 24));
		contV.setBounds(derechaSig*4-75-105, alto-138, ancho/16, heightBtn);
		add(contV);
		
		
		JLabel imgCV = new JLabel();
		imgCV.setBounds(derechaSig*4-75-70, alto-122, ancho/22, heightBtn-30);
		Icon imgcorV = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/unCorazon-SinFondo.png")).getImage()
				.getScaledInstance(imgCV.getWidth(), imgCV.getHeight(), 0));
		imgCV.setOpaque(true);
		imgCV.setIcon(imgcorV);
		imgCV.setBackground(new Color(0,0,0,0));
		add(imgCV);
		

	}
	
	

	public void paint(Graphics g) {
		
		img = new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/fondoV2SinTexto.png")).getImage();
		
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		
		setOpaque(false);
		
		setBackground(new Color(0,0,0,0));
		
		super.paint(g);
	}
	
	public void paintImgO(String path) {
		
		//imagen1.setOpaque(false);
		
		Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
				.getScaledInstance(imagen1.getWidth(), imagen1.getHeight(), 0));
		
		imagen1.setIcon(img);
		
		//g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		
		//setOpaque(true);
				
		//super.paint(g);
	}
	
	public void paintImgV(String path) {
		
		//imagen2.setOpaque(false);
		
		Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
				.getScaledInstance(imagen2.getWidth(), imagen2.getHeight(), 0));
		
		imagen2.setIcon(img);

	}
	
	public void removeImgV() {
		imagen2.setIcon(null);
		//imagen2.setOpaque(true);
		//imagen2.setDisabledIcon(imagen2.getIcon());
	}
	
	public void removeImgO() {
		imagen1.setIcon(null);
		//imagen1.setOpaque(true);
		//imagen1.setDisabledIcon(imagen1.getIcon());
	}
	
	public JLabel getPEquipoO() {
		//Retron progreso actual del equipo naranja o null si ya termino
		// decremento porque el progreso de la primer posicion me quedo arriba, entonces lo invierto
		if (pActualO>0) {
			pActualO--;
			return fondo.getProgreso(0,pActualO);
		}
		return null;
	}
	
	public JLabel getPEquipoV() {
		//Retron progreso actual del equipo violeta o null si ya termino
		// decremento porque el progreso de la primer posicion me quedo arriba, entonces lo invierto
		if (pActualV>0) {
			pActualV--;
			return fondo.getProgreso(1,pActualV);
		}
		return null;
	}
	
	public JLabel[] getEtiquetasO() {
		if(pActualO>=1) {
			Icon img1 = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/siguienteO.png")).getImage()
					.getScaledInstance(sigImg1.getWidth(), sigImg1.getHeight(), 0));
			
			sigImg1.setIcon(img1);
			sigImg1.setOpaque(true);
		}
		return etiquetas[0];
	}
	public JLabel[] getEtiquetasV() {
		if(pActualV>=1) {
			Icon img2 = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/siguienteV.png")).getImage()
					.getScaledInstance(sigImg2.getWidth(), sigImg2.getHeight(), 0));
			
			sigImg2.setIcon(img2);
			sigImg2.setOpaque(true);
		}
		return etiquetas[1];
	}
	
	public JLabel getSinEtiquetasO() {
		if(pActualO>=1) {
			Icon img1 = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/siguienteO.png")).getImage()
					.getScaledInstance(sigImg1.getWidth(), sigImg1.getHeight(), 0));
			
			sigImg1.setIcon(img1);
			sigImg1.setOpaque(true);
		}
		return noEts1;
	}
	public JLabel getSinEtiquetasV() {
		if(pActualV>=1) {
			Icon img2 = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/siguienteV.png")).getImage()
					.getScaledInstance(sigImg2.getWidth(), sigImg2.getHeight(), 0));
			
			sigImg2.setIcon(img2);
			sigImg2.setOpaque(true);
		}
		return noEts2;
	}
	
	public void blanquearEtsO() {
		for(int i=0; i<7; i++) {
			etiquetas[0][i].setBorder(null);
		}
		sigImg1.setIcon(null);
		sigImg1.setOpaque(false);
		noEts1.setOpaque(false);
		noEts1.setIcon(null);
		for (int i=0; i<7; i++) {
			etiquetas[0][i].setIcon(null);;
			etiquetas[0][i].setOpaque(false);
		}
	}
	
	public void blanquearEtsV() {
		for(int i=0; i<7; i++) {
			etiquetas[1][i].setBorder(null);
		}
		sigImg2.setIcon(null);
		sigImg2.setOpaque(false);
		noEts2.setOpaque(false);
		noEts2.setIcon(null);
		for (int i=0; i<7; i++) {
			etiquetas[1][i].setIcon(null);;
			etiquetas[1][i].setOpaque(false);
		}
	}

	public int terminoO(int pts) {
		//Muestra en pantalla los puntos y el tiempo que tardo el equipo naranja, y devuelve el tiempo total transcurrido
		//termineO.setText("Terminaste con "+pts+" puntos en "+dt.getTime());
		return dt.getTotalTime();
	}

	public int terminoV(int pts) {
		//Muestra en pantalla los puntos y el tiempo que tardo el equipo violeta, y devuelve el tiempo total transcurrido
		//termineV.setText("Terminaste con "+pts+" puntos en "+dt.getTime());
		return dt.getTotalTime();
	}
	
	public void continuar() {
		Icon img2 = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/BotonVerResultados.png")).getImage()
				.getScaledInstance(VR.getWidth(), VR.getHeight(), 0));
		
		VR.setIcon(img2);
		VR.setOpaque(true);
		
	}
	
	public void terminoJO() {
		this.blanquearEtsO();
		this.removeImgO();
//		this.sigImg1.setText("<html>Espera al<br>otro jugador</html>");
//		this.sigImg1.setForeground(Color.white);
//		this.sigImg1.setBackground(Color.black);
		sigImg1.setBounds(43, 90, ancho/2-56, alto-130);
		Icon i = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/finNaranja.png")).getImage()
				.getScaledInstance(sigImg1.getWidth(), sigImg1.getHeight(), 0));
		
		sigImg1.setIcon(i);
		this.sigImg1.setOpaque(true);
		this.repaint();
	}
	
	public void terminoJV() {
		this.blanquearEtsV();
		this.removeImgV();
//		this.sigImg2.setText("<html>Espera al<br>otro jugador</html>");
//		this.sigImg2.setForeground(Color.white);
//		this.sigImg2.setBackground(Color.black);
		sigImg2.setBounds(ancho/2, 90, ancho/2-56, alto-130);
		Icon i = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/FondosYBotones/finVioleta.png")).getImage()
				.getScaledInstance(sigImg2.getWidth(), sigImg2.getHeight(), 0));
		
		sigImg2.setIcon(i);
		this.sigImg2.setOpaque(true);
		this.repaint();
	}
	
	public void termine() {
		//Detengo el timer
		dt.stop();
	}
	
	public JLabel getContadorCorazonesO() {
		return this.contO;
	}
	
	public JLabel getContadorCorazonesV() {
		return this.contV;
	}
	
	public void libreSellosO() {
		Icon noetO = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/Sellos/libreDeSellos.png")).getImage()
				.getScaledInstance(noEts1.getWidth(), noEts1.getHeight(), 0));
		noEts1.setIcon(noetO);
		noEts1.setOpaque(true);
	}
	
	public void libreSellosV() {
		Icon noetV = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/Sellos/libreDeSellos.png")).getImage()
				.getScaledInstance(noEts2.getWidth(), noEts2.getHeight(), 0));
		noEts2.setIcon(noetV);
		noEts2.setOpaque(true);
	}
	
}
