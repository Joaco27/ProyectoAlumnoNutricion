package funcionalidades;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

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
	private JPanel panel;
	private final JFXPanel jfxpanel = new JFXPanel();
	
	
	public PresentacionD1Listener() {
        setLayout(null);
		frame = new JFrame("Presentacion");
        setSize(1024, 768);
        createScene();
        //setBounds(0,0,1024,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //jfxpanel.setSize(400,200);
        jfxpanel.setBounds(0,0,1024/2,768/2);
        panel = new JPanel();
        panel.setBounds(0,0,1024,768);
        panel.add(jfxpanel,BorderLayout.CENTER);
        add(panel);
        
        setVisible(true);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PresentacionD1Listener frame = new PresentacionD1Listener();
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
	public void addTuioCursor(TuioCursor arg0) {
		// TODO Auto-generated method stub
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
	
	private void createScene(){
		try{
		  Thread hilo= new Thread(new Runnable() {
             @Override
             public void run() {   
                //File file = new File("C:\\users\\"+(System.getProperty("user.name"))+ "\\Desktop\\MiPelicula.mp4"); 
            	 URL file;
                file=getClass().getResource("/pistas/presentacionCarreraDeSellos.mp4");
                    MediaPlayer oracleVid = new MediaPlayer(                                       
                        new javafx.scene.media.Media(file.toString())
                    );
                    //se añade video al jfxPanel
                    jfxpanel.setScene(new javafx.scene.Scene(new javafx.scene.Group(new MediaView(oracleVid))));                    
                    oracleVid.setVolume(1.0);//volumen
//                    oracleVid.setCycleCount(MediaPlayer.INDEFINITE);//repite video      
                    oracleVid.play();//play video               
             }
        });
		  hilo.start();

		 
		}
		catch(Exception e){
			
		}
		  
		  
	}

	

}
