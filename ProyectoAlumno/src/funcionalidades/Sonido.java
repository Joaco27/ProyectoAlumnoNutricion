package funcionalidades;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Sonido {
	private Clip enviar;
	private Clip fondo;
	
	public Sonido(){
		try
	    {
			enviar=AudioSystem.getClip();
			enviar.open(AudioSystem.getAudioInputStream(getClass().getResource("/pistas/wError.wav")));
			fondo=AudioSystem.getClip();
			fondo.open(AudioSystem.getAudioInputStream(getClass().getResource("/pistas/fondo.wav")));
	  }catch(Exception ex){
		  	System.out.println("No se encontró el audio "+ex);
	     }
		

	}
	
	public void escucharFondo() {
		fondo.start();
		fondo.setFramePosition(0);
		fondo.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void escucharEnviar() {
		enviar.start();
		enviar.setFramePosition(0);
	}
	
	public void detenerMusica() {
		enviar.stop();
		fondo.stop();
	}
}
