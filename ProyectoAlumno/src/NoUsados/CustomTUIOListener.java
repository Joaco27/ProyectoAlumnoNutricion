package NoUsados;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

import TUIO.TuioListener;
import TUIO.TuioObject;
import TUIO.TuioPoint;
import TUIO.TuioTime;
import TUIO.TuioCursor;
import TUIO.TuioBlob;

public class CustomTUIOListener extends JPanel implements TuioListener {
    private ArrayList<TuioObject> objects = new ArrayList<TuioObject>();
    private ArrayList<TuioCursor> cursors = new ArrayList<TuioCursor>();

    public CustomTUIOListener() {
        JFrame frame = new JFrame("TUIO Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new TimerP());
        frame.add(this);
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
            //g2d.setColor(new Color(0, 0, 0, 50));
            if (this.esSano(tuioObject)) {
            	g2d.setColor(new Color(113, 255, 0, 150));
            }
            else {
            		g2d.setColor(new Color(255, 0, 0, 150));
            	
            	/* else {
                    g2d.setColor(new Color(0, 0, 0, 50));
            	}*/
            }
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
    
    public boolean esSano(TuioObject tuioObject) {
    	
    	return tuioObject.getSymbolID() >= 0 && tuioObject.getSymbolID() <= 5;
    	
    }

    public void addTuioObject(TuioObject tuioObject) {
        objects.add(tuioObject);
        this.repaint();
    }

    public void updateTuioObject(TuioObject tuioObject) {
        this.repaint();
    }

    public void removeTuioObject(TuioObject tuioObject) {
        objects.remove(tuioObject);
        this.repaint();
    }

	@Override
	public void addTuioBlob(TuioBlob arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTuioCursor(TuioCursor tuioC) {
		cursors.add(tuioC);
        this.repaint();		
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
	public void removeTuioCursor(TuioCursor tuioC) {
		cursors.remove(tuioC);
        this.repaint();			
	}

	@Override
	public void updateTuioBlob(TuioBlob arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTuioCursor(TuioCursor arg0) {
		this.repaint();		
	}

  
}
