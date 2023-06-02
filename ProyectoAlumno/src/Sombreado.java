import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import TUIO.TuioCursor;
import TUIO.TuioObject;

public class Sombreado extends JPanel {
	
	private ArrayList<TuioObject> equipoV = new ArrayList<TuioObject>();
	private ArrayList<TuioObject> equipoO = new ArrayList<TuioObject>();
    private ArrayList<TuioCursor> cursors = new ArrayList<TuioCursor>();
    private List<Integer> aciertosO = new ArrayList<Integer>();
    private List<Integer> aciertosV = new ArrayList<Integer>();
    private boolean evaluarO=false,evaluarV=false;
    private Image backgroundImage;
    private final int tamañoO = 200;
	
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
            int y = (int) (tuioObject.getScreenY(this.getHeight())-tamañoO*2/3);
            if(!evaluarV) {
                g2d.setColor(Color.gray);
            }
            else {
            	if(aciertosV.contains(tuioObject.getSymbolID())) {
            		g2d.setColor(Color.green);
            	}
            	else {
            		g2d.setColor(Color.red);
            	}
            }
            Ellipse2D.Double oval = new Ellipse2D.Double(x, y, tamañoO, tamañoO);
            /*final float dash1[] = {10.0f};
            g2d.setStroke(new BasicStroke(1.0f,
                    BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER,
                    10.0f, dash1, 0.0f));*/
            g2d.draw(oval);
            //g2d.fillOval(x, y, width, height);
        } 
        for (TuioObject tuioObject : equipoO) {
            int x = (int) (tuioObject.getScreenX(this.getWidth())-tamañoO*2/3);
            int y = (int) (tuioObject.getScreenY(this.getHeight())-tamañoO*2/3);
            if(!evaluarO) {
                g2d.setColor(Color.gray);
            }
            else {
            	if(aciertosO.contains(tuioObject.getSymbolID())) {
            		g2d.setColor(Color.green);
            	}
            	else {
            		g2d.setColor(Color.red);
            	}
            }            
            Ellipse2D.Double oval = new Ellipse2D.Double(x, y, tamañoO, tamañoO);
            /*final float dash1[] = {10.0f};
            g2d.setStroke(new BasicStroke(1.0f,
                    BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER,
                    10.0f, dash1, 0.0f));*/
            g2d.draw(oval);
            //g2d.fillOval(x, y, width, height);
        } 
        for (TuioCursor tuioC : cursors) {
            int x = (int) (tuioC.getScreenX(this.getWidth()) -50 / 2);
            int y = (int) (tuioC.getScreenY(this.getHeight())-50 / 2);
            int width = 50;
            int height = 50;
            g2d.setColor(Color.gray);
            g2d.fillOval(x, y, width, height);
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
	

}
