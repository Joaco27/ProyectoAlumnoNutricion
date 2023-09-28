package funcionalidades;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Sonido {
	private Clip enviar;
	private Clip fondo;
	private Clip acierto;
	private Clip fallo;
	
	public Sonido(){
		try
	    {
			enviar=AudioSystem.getClip();
			enviar.open(AudioSystem.getAudioInputStream(getClass().getResource("/pistas/Messenger.wav")));
			fondo=AudioSystem.getClip();
			fondo.open(AudioSystem.getAudioInputStream(getClass().getResource("/pistas/fondo.wav")));
			acierto=AudioSystem.getClip();
			acierto.open(AudioSystem.getAudioInputStream(getClass().getResource("/pistas/CorrectAnswer.wav")));
			fallo=AudioSystem.getClip();
			fallo.open(AudioSystem.getAudioInputStream(getClass().getResource("/pistas/WrongAnswer.wav")));
	    }catch(Exception ex){
		  	System.out.println("No se encontr� el audio "+ex);
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
	
	public void escucharAcierto() {
		acierto.start();
		acierto.setFramePosition(0);
	}
	
	public void escucharFallo() {
		fallo.start();
		fallo.setFramePosition(0);
	}
	
	public void detenerMusica() {
		enviar.stop();
		fondo.stop();
		acierto.stop();
		fallo.stop();
	}
}
