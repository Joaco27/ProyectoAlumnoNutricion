package funcionalidades;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import TUIO.TuioCursor;
import TUIO.TuioObject;

public class Sombreado extends JPanel {
	
	private List<TuioObject> equipoV = new ArrayList<TuioObject>();
	private List<TuioObject> equipoO = new ArrayList<TuioObject>();
    private List<TuioCursor> cursors = new ArrayList<TuioCursor>();
    private List<Integer> aciertosO = new ArrayList<Integer>();
    private List<Integer> aciertosV = new ArrayList<Integer>();
    private boolean evaluarO=false,evaluarV=false;
    private final int tamano = 200;
	
	public Sombreado() {
		setLayout(null);
		setOpaque(false);
		setBackground(new Color(0,0,0,0));
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (TuioObject tuioObject : equipoV) {
            //int x = (int) (tuioObject.getScreenX(this.getWidth())-tamañoO*2/3);
        	int x = (int) (tuioObject.getScreenX(this.getWidth())*0.9);
            int y = (int) (tuioObject.getScreenY(this.getHeight())-tamano*2/3);
            if(!evaluarV) {
                //g2d.setColor(Color.gray);
            	this.drawDifuminadoGrisCirculo(g2d, x, y, tamano);
            }
            else {
            	if(aciertosV.contains(tuioObject.getSymbolID())) {
            		//g2d.setColor(Color.green);
            		this.drawDifuminadoVerdeCirculo(g2d, x, y, tamano);
            	}
            	else {
            		//g2d.setColor(Color.red);
            		this.drawDifuminadoRojoCirculo(g2d, x, y, tamano);
            	}
            }
            //Ellipse2D.Double oval = new Ellipse2D.Double(x, y, tamañoO, tamañoO);
            /*final float dash1[] = {10.0f};
            g2d.setStroke(new BasicStroke(1.0f,
                    BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER,
                    10.0f, dash1, 0.0f));*/
            //g2d.draw(oval);
            //g2d.fillOval(x, y, width, height);
        } 
        for (TuioObject tuioObject : equipoO) {
            int x = (int) (tuioObject.getScreenX(this.getWidth())-tamano*2/3);
            int y = (int) (tuioObject.getScreenY(this.getHeight())-tamano*2/3);
            if(!evaluarO) {
                //g2d.setColor(Color.gray);
            	this.drawDifuminadoGrisCirculo(g2d, x, y, tamano);
            }
            else {
            	if(aciertosO.contains(tuioObject.getSymbolID())) {
            		//g2d.setColor(Color.green);
            		this.drawDifuminadoVerdeCirculo(g2d, x, y, tamano);
            	}
            	else {
            		//g2d.setColor(Color.red);
            		this.drawDifuminadoRojoCirculo(g2d, x, y, tamano);
            	}
            }          
            //Ellipse2D.Double oval = new Ellipse2D.Double(x, y, tamañoO, tamañoO);
            /*final float dash1[] = {10.0f};
            g2d.setStroke(new BasicStroke(1.0f,
                    BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER,
                    10.0f, dash1, 0.0f));*/
            //g2d.draw(oval);
            //g2d.fillOval(x, y, width, height);
        } 
        for (TuioCursor tuioC : cursors) {
            int x = (int) (tuioC.getScreenX(this.getWidth()) -50 / 2);
            int y = (int) (tuioC.getScreenY(this.getHeight())-50 / 2);
            int width = 50;
            int height = 50;
            this.drawDifuminadoGrisCirculo(g2d, x, y, width);
            //g2d.setColor(Color.gray);
            //g2d.fillOval(x, y, width, height);
        }
        
        
    }
	
	public void addCursor(TuioCursor tc) {
		this.cursors.add(tc);
	}
	
	public void addObjectO(TuioObject to) {
		this.equipoO.add(to);
	}
	
	public void addObjectV(TuioObject to) {
		this.equipoV.add(to);
	}
	
	public void removeObjectO(TuioObject to) {
		this.equipoO.remove(to);
	}
	
	public void removeObjectV(TuioObject to) {
		this.equipoV.remove(to);
	}
	
	public void removeCursor(TuioCursor to) {
		this.cursors.remove(to);
	}
	
	public void sombrearO(List<Integer> aciertos) {
		this.aciertosO=aciertos;
		this.setEvaluarO(true);
        super.repaint();
	}
	
	public void sombrearV(List<Integer> aciertos) {
		this.aciertosV=aciertos;
		this.setEvaluarV(true);
        super.repaint();
	}
	
	public void setEvaluarO(boolean ok) {
		this.evaluarO=ok;
	}
	
	public void setEvaluarV(boolean ok) {
		this.evaluarV=ok;
	}
	
	public List<TuioObject> getEquipoO() {
		return this.equipoO;
	}
	
	public List<TuioObject> getEquipoV() {
		return this.equipoV;
	}
	
	
	private void drawDifuminadoVerdeCirculo(Graphics2D g2d, int x, int y, int d) {
        // Configurar el suavizado de gráficos
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Crear el gradiente de color verde
        //GradientPaint gradient = new GradientPaint(x, y, Color.GREEN, x+d, y+d, Color.WHITE);
        
        //Color[] colors = {Color.WHITE, Color.GREEN};
        Color[] colors = {new Color(0, 255, 0, 0), new Color(0, 255, 0, 255)};
        float[] fractions = {0.0f, 1.0f};

        // Crear el gradiente radial
        RadialGradientPaint gradient = new RadialGradientPaint(x + d / 2, y + d / 2, d / 2, fractions, colors);
        
        // Aplicar el gradiente al objeto Graphics2D
        g2d.setPaint(gradient);

        // Crear un círculo en el centro del JPanel
//        int diameter = Math.min(getWidth(), getHeight()) / 2;
//        int centerX = getWidth() / 2;
//        int centerY = getHeight() / 2;
        Ellipse2D circle = new Ellipse2D.Double(x, y, d, d);

        // Dibujar el círculo
        g2d.fill(circle);
    }
	
	private void drawDifuminadoRojoCirculo(Graphics2D g2d, int x, int y, int d) {
        // Configurar el suavizado de gráficos
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Crear el gradiente de color verde
        //GradientPaint gradient = new GradientPaint(x, y, Color.GREEN, x+d, y+d, Color.WHITE);
        
        //Color[] colors = {Color.WHITE, Color.RED};
        Color[] colors = {new Color(255, 0, 0, 0), new Color(255, 0, 0, 255)};
        float[] fractions = {0.0f, 1.0f};

        // Crear el gradiente radial
        RadialGradientPaint gradient = new RadialGradientPaint(x + d / 2, y + d / 2, d / 2, fractions, colors);
        
        // Aplicar el gradiente al objeto Graphics2D
        g2d.setPaint(gradient);

        // Crear un círculo en el centro del JPanel
//        int diameter = Math.min(getWidth(), getHeight()) / 2;
//        int centerX = getWidth() / 2;
//        int centerY = getHeight() / 2;
        Ellipse2D circle = new Ellipse2D.Double(x, y, d, d);

        // Dibujar el círculo
        g2d.fill(circle);
    }
	
	private void drawDifuminadoGrisCirculo(Graphics2D g2d, int x, int y, int d) {
        // Configurar el suavizado de gráficos
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Crear el gradiente de color verde
        //GradientPaint gradient = new GradientPaint(x, y, Color.GREEN, x+d, y+d, Color.WHITE);
        
        //Color[] colors = {Color.WHITE, Color.GRAY};
        Color[] colors = {new Color(128, 128, 128, 0), new Color(128, 128, 128, 255)};
        float[] fractions = {0.0f, 1.0f};

        // Crear el gradiente radial
        RadialGradientPaint gradient = new RadialGradientPaint(x + d / 2, y + d / 2, d / 2, fractions, colors);
        
        // Aplicar el gradiente al objeto Graphics2D
        g2d.setPaint(gradient);

        // Crear un círculo en el centro del JPanel
//        int diameter = Math.min(getWidth(), getHeight()) / 2;
//        int centerX = getWidth() / 2;
//        int centerY = getHeight() / 2;
        Ellipse2D circle = new Ellipse2D.Double(x, y, d, d);

        // Dibujar el círculo
        g2d.fill(circle);
    }
	

}
