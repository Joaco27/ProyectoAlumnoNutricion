

public class MainClass {

	public static void main(String[] args) {
		//CustomTUIOListener customTUIOListener = new CustomTUIOListener();
		//MyTuioListener listener = new MyTuioListener();
		Puntaje p = new Puntaje();
		TuioClient client = new TuioClient();
		ListenerMP listenerInter = new ListenerMP(client,p);
		//client.addTuioListener(listener);
		//client.addTuioListener(customTUIOListener);
		client.addTuioListener(listenerInter);
		client.connect();
		//System.out.println(client.isConnected());
		
		
	}

}
