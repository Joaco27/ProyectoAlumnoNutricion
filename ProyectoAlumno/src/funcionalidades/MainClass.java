package funcionalidades;
public class MainClass {

	public static void main(String[] args) {
		Puntaje p = new Puntaje();
		TuioClient client = new TuioClient();
		ListenerMP menuP = new ListenerMP(client,p);
		client.addTuioListener(menuP);
		//PresentacionD1Listener present = new PresentacionD1Listener(client, p);
		//client.addTuioListener(new PresentacionD1Listener(client, p));
		client.connect();
		
		
	}

}
