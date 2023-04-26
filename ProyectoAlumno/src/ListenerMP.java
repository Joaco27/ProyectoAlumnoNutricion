import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TUIO.TuioBlob;
import TUIO.TuioCursor;
import TUIO.TuioListener;
import TUIO.TuioObject;
import TUIO.TuioTime;

public class ListenerMP extends JPanel implements TuioListener {
    
	private TuioClient client;
	private JFrame frame;
	
	
    public ListenerMP(TuioClient client, int v, int n) {
    	this.client = client;
    	frame = new JFrame("Menu Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new MenuPanel(v,n)); 
        //frame.add(this);
        frame.setVisible(true);
    }

	@Override
	public void addTuioBlob(TuioBlob arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTuioCursor(TuioCursor tc) {
		// Cuando presiono con el cursor la parte superior de la pantalla desactiva el listener, cierra el frame 
		// y activa el listener del desafio 1
		if (tc.getY()<0.5) {
			client.removeTuioListener(this);
			frame.dispose();
			client.addTuioListener(new ListenerD1(client));
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
    
    // Implementación de métodos de la interfaz TUIOListener
    // ...
}