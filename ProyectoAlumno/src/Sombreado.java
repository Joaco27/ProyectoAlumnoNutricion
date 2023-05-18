import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

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
	
	public Sombreado() {
		setLayout(null);
		setOpaque(false);
		setBackground(new Color(0,0,0,0));
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (TuioObject tuioObject : equipoV) {
            int x = (int) (tuioObject.getScreenX(this.getWidth()) - 50 / 2);
            int y = (int) (tuioObject.getScreenY(this.getHeight()) - 50 / 2);
            int width = 150;
            int height = 150;
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
            g2d.fillOval(x, y, width, height);
        } 
        for (TuioObject tuioObject : equipoO) {
            int x = (int) (tuioObject.getScreenX(this.getWidth()) - 50 / 2);
            int y = (int) (tuioObject.getScreenY(this.getHeight()) - 50 / 2);
            int width = 150;
            int height = 150;
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
            g2d.fillOval(x, y, width, height);
        } 
        for (TuioCursor tuioC : cursors) {
            int x = (int) (tuioC.getScreenX(this.getWidth()) - 50 / 2);
            int y = (int) (tuioC.getScreenY(this.getHeight()) - 50 / 2);
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
