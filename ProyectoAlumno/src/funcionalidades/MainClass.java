package funcionalidades;
public class MainClass {

	public static void main(String[] args) {
		Puntaje p = new Puntaje();
		TuioClient client = new TuioClient();
		ListenerMP listenerInter = new ListenerMP(client,p);
		client.addTuioListener(listenerInter);
		client.connect();
		
		
	}

}
