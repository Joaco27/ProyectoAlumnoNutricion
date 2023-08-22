package funcionalidades;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.URL;

import javax.swing.JFrame;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class VideoD1 extends JPanel{
	private Puntaje p;
	private final JFXPanel jfxpanel = new JFXPanel();
	
	
	public VideoD1() {
        setLayout(null);
        setSize(1024, 768);
        createScene();
        jfxpanel.setBounds(0,0,1024,768);		
        add(jfxpanel,BorderLayout.CENTER);
	}

	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VideoD1 frame = new VideoD1();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	private void createScene(){
		try{
		  Thread hilo= new Thread(new Runnable() {
             @Override
             public void run() {   
            	 URL file;
                file=getClass().getResource("/pistas/presentacionCarreraDeSellos.mp4");
                    MediaPlayer oracleVid = new MediaPlayer(                                       
                        new javafx.scene.media.Media(file.toString())
                    );
                    jfxpanel.setScene(new javafx.scene.Scene(new javafx.scene.Group(new MediaView(oracleVid))));                    
                    oracleVid.setVolume(1.0);//volumen
//                    oracleVid.setCycleCount(MediaPlayer.INDEFINITE);//repite video      
                    oracleVid.play();//play video               
             }
        });
		  hilo.start();

		 
		}
		catch(Exception e){
			System.out.println("Fallo la reproduccion del Video");
		}
		  
		  
	}
	
	public void fin() {
		
	}

	

}
