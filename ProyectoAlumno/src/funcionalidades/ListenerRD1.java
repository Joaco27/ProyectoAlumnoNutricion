package funcionalidades;
import javax.swing.JFrame;
import javax.swing.JPanel;
import TUIO.TuioBlob;
import TUIO.TuioCursor;
import TUIO.TuioListener;
import TUIO.TuioObject;
import TUIO.TuioTime;
 
public class ListenerRD1 extends JPanel implements TuioListener{

	private TuioClient client;
	private JFrame frame;
	private ResultD1 panel;
	private Puntaje pts;
	private Sonido sonido;
	private ResultTimer timerR;
	private Boolean tiempoCero = false;
	
	public ListenerRD1(TuioClient client, Puntaje pts, int tiempoO, int tiempoV, Sonido s) {
		this.sonido = s;
		this.client = client;
		this.pts=pts;
    	frame = new JFrame("Resultados Desafio 1");
        frame.setSize(1024, 768);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new ResultD1(frame.getHeight(), frame.getWidth(),pts, tiempoO, tiempoV);
        timerR = new ResultTimer(this);
        add(timerR);
        frame.add(panel);
	}
	
	public void tiempoCeroIsTrue() {
		tiempoCero = true;
	}
	
	public void tiempoCeroIsFalse() {
		tiempoCero = false;
	}
	
	@Override
	public void addTuioBlob(TuioBlob arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTuioCursor(TuioCursor tc) {
		// TODO Auto-generated method stub
		if((tc.getY()>0.5)&&(tiempoCero == true)) {
			sonido.detenerMusica();
			client.removeTuioListener(this);
			frame.dispose();
			client.addTuioListener(new ListenerMP(client,pts));
		}
	}

	@Override
	public void addTuioObject(TuioObject to) {
		
		
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

}
