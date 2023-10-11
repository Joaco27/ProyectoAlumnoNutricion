package funcionalidades;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import TUIO.TuioBlob;
import TUIO.TuioCursor;
import TUIO.TuioListener;
import TUIO.TuioObject;
import TUIO.TuioTime;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class PresentacionD1Listener extends JFrame implements TuioListener{
	private Puntaje p;
	private JFrame frame;
	private boolean corriendo=false;
	private TuioClient client;
	private Puntaje pts;
	private VideoD1 video;
	
	
	public PresentacionD1Listener(TuioClient cli, Puntaje puntos) {
		pts=puntos;
		client = cli;
        //setLayout(null);
		frame = new JFrame("Presentacion");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
//        JPanel panel = new JPanel();
//        panel.setBounds(900, 5, 30, 30);
//        panel.setLayout(null);
//        panel.setOpaque(true);
//        panel.setBackground(Color.black);
//        JButton btnNewButton = new JButton("SALTAR >>>");
//		btnNewButton.setBounds(900, 5, 30, 30);
//		btnNewButton.setVisible(true);
//		btnNewButton.setOpaque(true);
//		btnNewButton.addMouseListener(new saltarAdapter());
//		panel.add(btnNewButton);
//        add(panel);
//        setVisible(true);
        
        video = new VideoD1();
        video.setVisible(true);
        add(video);
        setVisible(true);
        
		
//		try {
//			Thread.sleep(38000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
        
		//this.saltear();
	}
	
	public void saltear(){
		if (!corriendo){
			client.removeTuioListener(this);
			corriendo = true;
			ListenerD1 prueba = new ListenerD1(client, pts);
			client.addTuioListener(prueba);
			this.dispose();
		}
	}
	
	private class saltarAdapter extends MouseAdapter {

		public void mouseReleased(MouseEvent c) {
			saltear();
			
		}
	}

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PresentacionD1Listener frame = new PresentacionD1Listener(new TuioClient(), new Puntaje());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void addTuioBlob(TuioBlob arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTuioCursor(TuioCursor tcur) {
		if((tcur.getX()>0.3)&&(tcur.getX()<0.6)){
			if((tcur.getY()>0.3)&&(tcur.getY()<0.6))
				saltear();
		}	}

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
	

}
